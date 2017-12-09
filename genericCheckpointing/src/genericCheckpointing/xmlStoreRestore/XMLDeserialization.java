package genericCheckpointing.xmlStoreRestore;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;
public class XMLDeserialization implements SerStrategy{
  public void processInput(FileProcessor fp) {
    ArrayList<String> lines = new ArrayList<String>();
    String line = fp.readLine();
    while(line != null){
      lines.add(line);
      //System.out.println(line);
      if(line.charAt(0) == 'x'){
        //System.out.println(line);
        String[] tokens = line.split("[:=</>]+");
        for (String t:tokens){
          System.out.println(t);
          break;
        }
      }
      line = fp.readLine();


    }
    System.out.println(lines.size());
  }



  //Not implemented
  public void processInput(SerializableObject sObject) {}
}
