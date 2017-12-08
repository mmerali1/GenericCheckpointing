package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
  private int myInt;
  private int myOtherInt;
  private long myLong;
  private long myOtherLong;
  private String myString;
  private boolean myBool;

  public MyAllTypesFirst(){}

  public MyAllTypesFirst(int myIntIn, int myOtherIntIn, long myLongIn, long myOtherLongIn, String myStringIn, boolean myBoolIn){
    myInt = myIntIn;
    myOtherInt = myOtherIntIn;
    myLong = myLongIn;
    myOtherLong = myOtherLongIn;
    myString = myStringIn;
    myBool = myBoolIn;
  }

  public void setMyInt(int input){
    myInt = input;
  }

  public int getMyInt(){
    return myInt;
  }

  public void setMyOtherInt(int input){
    myOtherInt = input;
  }

  public int getMyOtherInt(){
    return myOtherInt;
  }

  public void setMyLong(long input){
    myLong = input;
  }

  public long getMyLong(){
    return myLong;
  }

  public void setMyOtherLong(long input){
    myOtherLong = input;
  }

  public long getMyOtherLong(){
    return myOtherLong;
  }

  public void setMyString(String input){
    myString = input;
  }

  public String getMyString(){
    return myString;
  }

  public void setMyBool(boolean input){
    myBool = input;
  }

  public boolean getMyBool(){
    return myBool;
  }
}
