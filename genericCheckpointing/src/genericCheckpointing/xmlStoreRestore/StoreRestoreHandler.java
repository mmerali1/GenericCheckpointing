package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;

public class StoreRestoreHandler implements InvocationHandler{
	private String filename = null;
	private FileProcessor fp = null;
	private XMLSerialization xmlSer = new XMLSerialization();
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable{
		String mName = m.getName();
				if (mName == "writeObj"){
					System.out.println("In method: " + mName);
					serializeData((SerializableObject)args[0], new XMLSerialization());
				}else{
					if(args[0].equals("XML")){
						deserializeData(new XMLDeserialization());
					}
				}
				return null;
	}

	public void serializeData(SerializableObject sObject, SerStrategy sStrat){
		sStrat.processInput(sObject);
	}

	public void deserializeData(SerStrategy sStrat){
		sStrat.processInput(fp);
	}

	public void setFilename(String filenameIn){
		filename = filenameIn;
	}

	public String getFilename(){
		return filename;
	}

	public void openFile(){
		fp = new FileProcessor(filename);
	}

	public void closeFile(){
		fp.closeFile();
	}
}
