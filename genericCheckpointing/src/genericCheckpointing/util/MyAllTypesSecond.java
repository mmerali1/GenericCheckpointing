package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
  private double myDoubleT;
  private double myOtherDoubleT;
  private float myFloatT;
  private short myShortT;
  private short myOtherShortT;
  private char myCharT;

  public MyAllTypesSecond(){}

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

  public void setmyOtherDoubleT(short input){
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
}
