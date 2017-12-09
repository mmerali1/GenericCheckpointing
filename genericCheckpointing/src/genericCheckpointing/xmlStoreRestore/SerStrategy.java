package genericCheckpointing.xmlStoreRestore;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.FileProcessor;
public interface SerStrategy{
  public void processInput(SerializableObject sObject);
  public void processInput(FileProcessor fp);

}
