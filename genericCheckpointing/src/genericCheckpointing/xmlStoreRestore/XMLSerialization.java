package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import genericCheckpointing.util.Results;
import java.lang.reflect.InvocationTargetException;

public class XMLSerialization  implements SerStrategy {
  private Results res = null;

  public XMLSerialization(){
    res = new Results();
  }

  public void processInput(Object sObject) {
    Class<?> cls = sObject.getClass();
    Field[] flds = cls.getDeclaredFields();
    //Hardcoded XML
    res.storeNewResult("<DPSerialization>");
    res.storeNewResult("\t<complexType xsi:type=" +'"'+cls.getPackage()+'"'+">");
    for (int i=0;i<flds.length;i++){
      Field fld = flds[i];
      if (fld.getType() == int.class){
        String mName = "get" + fld.getName();
        System.out.println(mName);
        //Get the method or handle exception
        Method getterMethod = null;
        try{getterMethod = cls.getMethod(mName);}
        catch(NoSuchMethodException e){
          System.err.println("Error: cannot find getter method");
          e.printStackTrace();
          System.exit(1);
        }
        //Invoke getter method or handle exception
        Object invokeRet = null;
        try{invokeRet = getterMethod.invoke(sObject); }
        catch(IllegalAccessException | InvocationTargetException e){
          System.err.println("Error: cannot invoke getter");
          e.printStackTrace();
          System.exit(1);
        }
        res.storeNewResult("\t\t<"+fld.getName()+" xsi:type="+'"'+"xsd:int"+'"'+">"+((int)invokeRet)+"</myInt>");
      }
    }
    res.storeNewResult("\t</complexType");
    res.storeNewResult("</DPSerialization>");
    res.writeToFile("out.txt");


  }


}
