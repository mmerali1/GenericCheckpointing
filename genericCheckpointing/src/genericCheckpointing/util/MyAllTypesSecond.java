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

  public void setMyDoubleT(double input){
    myDoubleT = input;
  }

  public double getMyDoubleT(){
    return myDoubleT;
  }

  public void setMyOtherDoubleT(double input){
    myOtherDoubleT = input;
  }

  public double getMyOtherDoubleT(){
    return myOtherDoubleT;
  }

  public void setMyFloatT(float input){
    myFloatT = input;
  }

  public float getMyFloatT(){
    return myFloatT;
  }

  public void setMyShortT(short input){
    myShortT = input;
  }

  public short getMyOtherShortT(){
    return myOtherShortT;
  }

  public void setMyCharT(char input){
    myCharT = input;
  }

  public char getMyCharT(){
    return myCharT;
  }
}
