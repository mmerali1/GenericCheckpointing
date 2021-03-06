package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
  private double myDoubleT;
  private double myOtherDoubleT;
  private float myFloatT;
  private short myShortT;
  private short myOtherShortT;
  private char myCharT;

  public MyAllTypesSecond(){
		myDoubleT = 0.0;
		myOtherDoubleT = 0.0;
		myFloatT = 0;
		myShortT = 0;
		myOtherShortT = 0;
		myCharT = '0';
  
  }

  public MyAllTypesSecond(double myDoubleTIn, double myOtherDoubleTIn, float myFloatTIn, short myShortTIn, short myOtherShortTIn, char myCharTIn){
    myDoubleT = myDoubleTIn;
    myOtherDoubleT = myOtherDoubleTIn;
    myFloatT = myFloatTIn;
    myShortT = myShortTIn;
    myOtherShortT = myOtherShortTIn;
    myCharT = myCharTIn;
  }

  public void setmyDoubleT(double input){
    myDoubleT = input;
  }

  public double getmyDoubleT(){
    return myDoubleT;
  }

  public void setmyOtherDoubleT(double input){
    myOtherDoubleT = input;
  }

  public double getmyOtherDoubleT(){
    return myOtherDoubleT;
  }

  public void setmyFloatT(float input){
    myFloatT = input;
  }

  public float getmyFloatT(){
    return myFloatT;
  }

  public void setmyShortT(short input){
    myShortT = input;
  }

  public short getmyShortT(){
    return myShortT;
  }

  public void setmyOtherShortT(short input){
    myOtherShortT = input;
  }

  public short getmyOtherShortT(){
    return myOtherShortT;
  }

  public void setmyCharT(char input){
    myCharT = input;
  }

  public char getmyCharT(){
    return myCharT;
  }
  
  public String toString(){
		return "MyAllTypesSecond\n\tmyDoubleT: " + myDoubleT + "\n\tmyOtherDoubleT" + myOtherDoubleT + "\n\tmyFloatT: " + myFloatT + "\n\tmyShortT" + myShortT + "\n\tmyOtherShortT: " + myOtherShortT + "\n\tmyCharT: " + myCharT + "\n";
		
  }
  
  @Override
  public boolean equals(final Object obj){
		MyAllTypesSecond tempObj = (MyAllTypesSecond)obj;
		if (this.getmyDoubleT() != tempObj.getmyDoubleT()) return false;
  		if (this.getmyOtherDoubleT() != tempObj.getmyOtherDoubleT()) return false;
  		if (this.getmyShortT() != tempObj.getmyShortT()) return false;
  		if (this.getmyOtherShortT() != tempObj.getmyOtherShortT()) return false;
  		if (this.getmyCharT() != tempObj.getmyCharT()) return false;
  		if (this.getmyFloatT() != tempObj.getmyFloatT()) return false;
  		return true;  
  }
}
