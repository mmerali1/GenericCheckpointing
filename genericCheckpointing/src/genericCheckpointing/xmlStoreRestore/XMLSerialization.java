package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import genericCheckpointing.util.Results;
import java.lang.reflect.InvocationTargetException;
import genericCheckpointing.util.FileProcessor;

public class XMLSerialization  implements SerStrategy {
  private Results res = null;

  public XMLSerialization(){
    res = new Results();
  }

  public void processInput(SerializableObject sObject) {
    Class<?> cls = sObject.getClass();
    Field[] fields = cls.getDeclaredFields();
    //Hardcoded XML
    res.storeNewResult("<DPSerialization>");
    res.storeNewResult("\t<complexType xsi:type=" +'"'+cls.toString()+'"'+">");
    for (Field fld : fields){
      String mName = "get" + fld.getName();
      System.out.println(mName);
      //Get the method or handle exception
      Method getterMethod = null;
      try{ getterMethod = cls.getMethod(mName);}
      catch(NoSuchMethodException e){
        System.err.println("Error: cannot find getter method:" + mName);
        //e.printStackTrace();
        System.exit(1);
      }
      //Invoke getter method or handle exception
      Object invokeRet = null;
      try{ invokeRet = getterMethod.invoke(sObject); }
      catch(IllegalAccessException | InvocationTargetException e){
        System.err.println("Error: cannot invoke getter");
        //e.printStackTrace();
        System.exit(1);
      }
      //Integer data members
      if (fld.getType() == int.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:int"+'"'+">"+((int)invokeRet)+"</"+fld.getName()+">");
      }
      //Long data members
      if (fld.getType() == long.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:long"+'"'+">"+((long)invokeRet)+"</"+fld.getName()+">");
      }
      //String data members
      if (fld.getType() == String.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:String"+'"'+">"+((String)invokeRet)+"</"+fld.getName()+">");
      }
      //boolean data members
      if (fld.getType() == boolean.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:boolean"+'"'+">"+((boolean)invokeRet)+"</"+fld.getName()+">");
      }
      //double data members
      if (fld.getType() == double.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:double"+'"'+">"+((double)invokeRet)+"</"+fld.getName()+">");
      }
      //float data members
      if (fld.getType() == float.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:float"+'"'+">"+((float)invokeRet)+"</"+fld.getName()+">");
      }
      //short data members
      if (fld.getType() == short.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:short"+'"'+">"+((short)invokeRet)+"</"+fld.getName()+">");
      }
      //char data members
      if (fld.getType() == char.class){
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:char"+'"'+">"+((char)invokeRet)+"</"+fld.getName()+">");
      }
    }
    res.storeNewResult("\t</complexType");
    res.storeNewResult("</DPSerialization>");
    //writeXMLToFile("out.txt");
  }
  public void writeXMLToFile(String filename){
    res.writeToFile(filename);
  }
  //Not implemented
  public void processInput(FileProcessor fp){}


}
