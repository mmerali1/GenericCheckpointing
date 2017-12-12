package genericCheckpointing.xmlStoreRestore;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public class XMLDeserialization implements SerStrategy{
  public SerializableObject processInput(FileProcessor fp) {
    ArrayList<String> lines = new ArrayList<String>();
    String line = fp.readLine();
    String clsName = "";
    Class<?> cls = null;
    Constructor<?> ctor = null;
    Object obj = null;
    SerializableObject sObject = null;
    boolean isObjCreated = false;
    Method setterMethod = null;
    DeserializeTypes deser = new DeserializeTypes();
    while(line != "-1"){
      line = line.replaceAll("[<>=]+", " ");
      String[] tokens = line.split("[ ]+");
      for (int i=0; i<tokens.length; i++){
          if(tokens[1].equals("DPSerialization")){}
          if(tokens[1].equals("complexType")){
            clsName = tokens[3].replaceAll("\"", "");
	    try{ 
		    cls = Class.forName(clsName);
	    } catch (ClassNotFoundException ex){
		    System.err.println("Error: could not find class " + clsName);
		    ex.printStackTrace();
		    System.exit(1);
	    }
	    try{
		    ctor = cls.getConstructor();
	    } catch (NoSuchMethodException ex){
		    System.err.println("Error: could not find constructor for " + clsName);
		    ex.printStackTrace();
		    System.exit(1);
	    }
	    try{
		    obj = ctor.newInstance(new Object[] {});
	    }catch(InstantiationException | IllegalAccessException | InvocationTargetException ex){
		    System.err.println("Error: could not instantiate class " + clsName);
		    ex.printStackTrace();
		    System.exit(1);
	    }
	    isObjCreated = true;
	    sObject = (SerializableObject)obj;
       }
		
	  //System.out.println(tokens[i]);
	  if (tokens[1].startsWith("my") && (isObjCreated = true)){
		String setMethodName = "set" + tokens[1];
		String memType = tokens[3].replaceAll("\"", "");
		switch (memType){
			case "xsd:int":
				int myIntValue = 0;
				try{
					myIntValue = Integer.parseInt(tokens[4]);				
				} catch (NumberFormatException ex){
					System.err.println("Error: invalid integer format");
					ex.printStackTrace();
					System.exit(1);				
				}
				deser.deserInt(setMethodName, myIntValue, sObject, cls);
				break;
			case "xsd:long":
				long mylongValue = 0;
				try{
					mylongValue = Long.parseLong(tokens[4]);
				} catch (NumberFormatException ex){
					System.err.println("Error: invalid long format");
					ex.printStackTrace();
					System.exit(1);
				}
				deser.deserLong(setMethodName, mylongValue, sObject, cls);
				break;
			case "xsd:string":
				int ind = 4;
				String myStringValue = "";
				
				while(ind < tokens.length){
					if(!tokens[ind].equals("/myString")){
						myStringValue = myStringValue + " " + tokens[ind];
					}
					ind++;
				}

				myStringValue = myStringValue.substring(1);
				deser.deserString(setMethodName, myStringValue, sObject, cls);
				break;
			case "xsd:boolean":
				deser.deserBool(setMethodName, tokens[4], sObject, cls);
				break;
			case "xsd:double":
				deser.deserDouble(setMethodName, tokens[4], sObject, cls);
				break;
			case "xsd:float":
					deser.deserFloat(setMethodName, tokens[4], sObject, cls);
				break;
			case "xsd:char":
				deser.deserChar(setMethodName, tokens[4].charAt(0), sObject, cls);	
				break;
			case "xsd:short":
				deser.deserShort(setMethodName, tokens[4], sObject, cls);
				break;
			default:
				break;

		}		
		  }
	  }
	  //System.out.println(line);
	  if (line.equals(" /DPSerialization ")) {
	  	//System.out.println("here "+ sObject);
	  	return sObject;
	  }
	  else {
		line = fp.readLine();	  
	  }
    }
    return sObject;
  }



  //Not implemented
  public void processInput(SerializableObject sObject) {}
}
