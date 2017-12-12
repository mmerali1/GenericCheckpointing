
package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.Results;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import java.util.Vector;
import java.util.Random;
import java.lang.Math;

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
        System.err.println("Not enough arguments");
				break;
			}
			if (0 == i){
				if ((parsArg.equals("serdeser")==false) && (parsArg.equals("deser")==false)){
          readFlag = false;
          System.out.println("Invalid Mode Entered");
          break;
        }
			}
			if (1 == i){
				try{
					NUM_OF_OBJECTS = Integer.parseInt(args[1]);
				}catch(NumberFormatException e){
          System.err.println("NumberFormatException");
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
										 new Class[] {StoreI.class, RestoreI.class}, srHandler);

			//FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
			srHandler.setFilename(args[2]);
			srHandler.openFile();

			MyAllTypesFirst myFirst;
			MyAllTypesSecond  mySecond;

			//Data structures for MyAllTypesFirst and MyAllTypesSecond
			Vector<SerializableObject> serderserVec = new Vector<SerializableObject>(NUM_OF_OBJECTS);
			// Use an if/switch to proceed according to the command line argument
			// For deser, just deserliaze the input file into the data structure and then print the objects

			// The code below is for "serdeser" mode
			// For "serdeser" mode, both the serialize and deserialize functionality should be called.
		Results res = new Results();	
			// create a data structure to store the objects being serialized
			// NUM_OF_OBJECTS refers to the count for e ach of MyAllTypesFirst and MyAllTypesSecond
		Random rGen = new Random();
		int intValArr[] = new int[NUM_OF_OBJECTS];
		long longValArr[] = new long[NUM_OF_OBJECTS];
		//String 341 characters long
		String randStr = "The purpose of this assignment is to create a generic library to serialize and deserialize objects. The code should allow the conversion of objects into a wire format. The code should be designed using dynamic proxies and reflection so that addition of new objects or serialization formats causes minimal changes (reduces the ripple effect).";
		String randStrT = "abcdefghijklmnopqrstuvwxyz";		
		String strValArr[] = new String[NUM_OF_OBJECTS];
		boolean boolValArr[] = new boolean[NUM_OF_OBJECTS];
		double doubleValArr[] = new double[NUM_OF_OBJECTS];
		float floatValArr[] = new float[NUM_OF_OBJECTS];
		char charValArr[] = new char[NUM_OF_OBJECTS];
		short shortValArr[] = new short[NUM_OF_OBJECTS];
		short shortValArrT[] = new short[NUM_OF_OBJECTS];
		for(int k=0; k<NUM_OF_OBJECTS; k++){
			intValArr[k] = rGen.nextInt(1000);
			longValArr[k] = Math.abs(rGen.nextLong());
			strValArr[k] = randStr.substring(rGen.nextInt(99), 100+rGen.nextInt(241));
			boolValArr[k] = rGen.nextBoolean();
			doubleValArr[k] = rGen.nextDouble();
			floatValArr[k] = rGen.nextFloat();
			charValArr[k] = randStrT.charAt(rGen.nextInt(26));
			shortValArr[k] = (short)rGen.nextInt(32768);
			shortValArrT[k] = (short)rGen.nextInt(32768/2);
		}			
		SerializableObject myRecordRet;
		Vector<SerializableObject> deserVec = new Vector<SerializableObject>(NUM_OF_OBJECTS);
		int matchCount = 0;
      if (args[0].equals("serdeser")){
        for (int i=0; i<NUM_OF_OBJECTS; i++) {

  				  //create these object instances correctly using an explicit value constructor
  				  // use the index variable of this loop to change the values of the arguments to these constructors
  				myFirst  = new MyAllTypesFirst(intValArr[i], intValArr[i]*2, longValArr[i], (longValArr[i]/2), strValArr[i], boolValArr[i]);
  				mySecond = new MyAllTypesSecond(doubleValArr[i], doubleValArr[i]+.5, floatValArr[i], shortValArr[i], shortValArrT[i], charValArr[i]);
            serderserVec.add(myFirst);
				serderserVec.add(mySecond);
            ((StoreI) cpointRef).writeObj(myFirst, 666 ,"XML");
  				((StoreI) cpointRef).writeObj(mySecond, 666 ,"XML");

			  }
			  
			 
			for (int j=0; j<NUM_OF_OBJECTS*2; j++) {
  				  myRecordRet = ((RestoreI) cpointRef).readObj("XML");
  				  deserVec.add(myRecordRet);
  				  //res.storeNewResult(myRecordRet.toString());
  				  // FIXME: store myRecordRet in the vector
  			}
  			for (int h=0; h<NUM_OF_OBJECTS*2; h++){
				if (!deserVec.get(h).equals(serderserVec.get(h))){
					 matchCount++;
					System.out.println(deserVec.get(h).toString());
					System.out.println(serderserVec.get(h).toString());
				}
				}
			}
      

		if (args[0].equals("deser")){
			// create a data structure to store the returned ojects
  			for (int j=0; j<NUM_OF_OBJECTS*2; j++) {
  				  myRecordRet = ((RestoreI) cpointRef).readObj("XML");
  				  deserVec.add(myRecordRet);
  				  res.storeNewResult(myRecordRet.toString());
  				  // FIXME: store myRecordRet in the vector
  			}
      }
		srHandler.closeFile();
		res.storeNewResult(matchCount + " mismatched objects");		
		res.writeToStdout();

		
		
	}
}
}
