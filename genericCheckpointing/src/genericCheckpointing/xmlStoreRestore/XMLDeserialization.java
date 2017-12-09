package genericCheckpointing.xmlStoreRestore;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;
public class XMLDeserialization implements SerStrategy{
  public SerializableObject processInput(FileProcessor fp) {
    ArrayList<String> lines = new ArrayList<String>();
    String line = fp.readLine();
    String clsName = "";

    while(line != "-1"){
      //lines.add(line);
      //System.out.println(line);
      line = line.replaceAll("[<>=]+", " ");
      String[] tokens = line.split("[ ]+");
      for (int i=0; i<tokens.length; i++){
          if(tokens[1].equals("DPSerialization")){}

          if(tokens[1].equals("complexType")){
            clsName = tokens[3].replaceAll("\"", "");
            System.out.println(clsName);


          }
      }
      //System.out.println(tokens.length);
      //System.out.println(line);

      //else if(line.substring(1,))

      /*if(line.charAt(0) == 'x'){
        //System.out.println(line);
        String[] tokens = line.split("[:=</>]+");
        //Class<?> cls = Class.forName();
      }*/
      line = fp.readLine();


    }
    System.out.println(lines.size());
    return null;
  }



  //Not implemented
  public void processInput(SerializableObject sObject) {}
}
