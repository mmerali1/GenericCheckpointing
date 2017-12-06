
package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import java.util.ArrayList;


// import the other types used in this file

public class Driver {
	//Command line validation
  public static void main(String[] args) {
		boolean readFlag = true;
		String parsArg = "";
		int NUM_OF_OBJECTS = 0;	
		for(int i=0; i<args.length; i++){
			parsArg = args[i];
			if (parsArg.charAt(0) == '$'){
				readFlag = false;
				break;
			}
			if (0 == i){
				if ((parsArg.equals("serdeser")==false) || (parsArg.equals("deser")==false)) readFlag = false; break;
			}
			if (1 == i){
				try{
					NUM_OF_OBJECTS = Integer.parseInt(args[1]);
				}catch(NumberFormatException e){
					readFlag = false;
					break;
				}
			}	
		}

		if (readFlag == false){
			System.err.println("Error: Invalid command line inputs");
			System.exit(1);

		} else {
		

			// FIXME: read the value of checkpointFile from the command line

			ProxyCreator pc = new ProxyCreator();

			// create an instance of StoreRestoreHandler (which implements
			// the InvocationHandler
			StoreRestoreHandler srHandler = new StoreRestoreHandler();
			// create a proxy
			StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
										 new Class[] {
											   StoreI.class, RestoreI.class
										 },
										 srHandler
										 );

			// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
			srHandler.setFilename(args[2]);
			srHandler.openFile();
	
			MyAllTypesFirst myFirst;
			MyAllTypesSecond  mySecond;

			//Data structures for MyAllTypesFirst and MyAllTypesSecond
			ArrayList<MyAllTypesFirst> myAllTypesFirstArr = new ArrayList<MyAllTypesFirst>();
			ArrayList<MyAllTypesSecond> myAllTypesSecondArr = new ArrayList<MyAllTypesSecond>();
		

			// Use an if/switch to proceed according to the command line argument
			// For deser, just deserliaze the input file into the data structure and then print the objects
			// The code below is for "serdeser" mode
			// For "serdeser" mode, both the serialize and deserialize functionality should be called.

			// create a data structure to store the objects being serialized
			// NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
			for (int i=0; i<NUM_OF_OBJECTS; i++) {

				  // FIXME: create these object instances correctly using an explicit value constructor
				  // use the index variable of this loop to change the values of the arguments to these constructors
				  myFirst = new MyAllTypesFirst();
				  mySecond = new MyAllTypesSecond();

				  // FIXME: store myFirst and mySecond in the data structure
				  // FIXME: authCode --put in temporary one "666" to compile
				  ((StoreI) cpointRef).writeObj(myFirst,666 ,"XML");
				  ((StoreI) cpointRef).writeObj(mySecond,666 ,"XML");

			}

			SerializableObject myRecordRet;

			// create a data structure to store the returned ojects
			for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

				  myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				  // FIXME: store myRecordRet in the vector
			}

			// FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

			// FIXME: compare and confirm that the serialized and deserialzed objects are equal.
			// The comparison should use the equals and hashCode methods. Note that hashCode
			// is used for key-value based data structures
		}
	}
}
