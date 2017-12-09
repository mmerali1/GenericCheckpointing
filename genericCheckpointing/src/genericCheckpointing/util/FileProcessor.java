//FILENAME: FileProcessor.java
//Author: Mehdi Merali, 2017

package genericCheckpointing.util;
// FIXME: Do we need a logger? If so, uncomment this
//import fileVisitors.util.MyLogger;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * FileProcessor is used to open, read, and close files from the directory
 */
public class FileProcessor {
    private File file = null;
    private Scanner sc = null;

    /**
     * Constructor takes in filename to open file
     * @param filename the name of the file being opened
     * @throws  FileNotFoundException if file cannot be found
     */
    public FileProcessor(String filename){
	// FIXME: Uncomment if need logger
	//MyLogger.writeMessage("FileProcessor class constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	file = new File(filename);
	try{
	    sc = new Scanner(file);
	} catch (FileNotFoundException e){
	    System.err.println("Exception thrown. File " + filename + " not found.");
	    System.exit(0);
	}

    }

    /**
       readLine function reads a line from file using a private scanner data member
       @return (String) returns one line from a text file
    */
    public String readLine(){
		    String temp = null;
		      if (sc.hasNext()){
	    	      temp = sc.nextLine();
		      } else{
	    	          temp = "-1";
		          }
		      return temp;
    }

    /**
       closeFile() closes the Scanner used in this class
       @return void
    */
    public void closeFile(){
		sc.close();
    }
}
