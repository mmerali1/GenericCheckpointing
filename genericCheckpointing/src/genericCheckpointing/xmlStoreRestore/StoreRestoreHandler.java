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
					System.out.println(args[0].toString());
					for (int i=0; i<args.length; i++){
						serializeData(args[i], new XMLSerialization());
					}
				}else{
					System.out.println("In method: " + mName);
				}
				return null;
	}

	public void serializeData(Object sObject, SerStrategy sStrat){
		sStrat.processInput(sObject);
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
