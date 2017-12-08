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

  public void setmyInt(int input){
    myInt = input;
  }

  public int getmyInt(){
    return myInt;
  }

  public void setmyOtherInt(int input){
    myOtherInt = input;
  }

  public int getmyOtherInt(){
    return myOtherInt;
  }

  public void setmyLong(long input){
    myLong = input;
  }

  public long getmyLong(){
    return myLong;
  }

  public void setmyOtherLong(long input){
    myOtherLong = input;
  }

  public long getmyOtherLong(){
    return myOtherLong;
  }

  public void setmyString(String input){
    myString = input;
  }

  public String getmyString(){
    return myString;
  }

  public void setmyBool(boolean input){
    myBool = input;
  }

  public boolean getmyBool(){
    return myBool;
  }

  public String toString(){
    return "MyAllTypesFirst class";
  }
}
