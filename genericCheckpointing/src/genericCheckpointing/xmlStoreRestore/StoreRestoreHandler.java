package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import genericCheckpointing.util.FileProcessor;

public class StoreRestoreHandler implements InvocationHandler{
	private String filename = null;
	private FileProcessor fp = null;	

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable{
		// FIXME: need to fix return statement and write this function.
		return null;
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
