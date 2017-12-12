package genericCheckpointing.xmlStoreRestore;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class DeserializeTypes{

	public void deserInt(String setMethodName, int myIntValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;	
		try{			
			setterMethod = cls.getMethod(setMethodName, int.class);
			setterMethod.invoke(sObject, new Integer(myIntValue));		
		} catch (NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);			
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	
	}
	public void deserLong(String setMethodName, long mylongValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;		
		try{			
			setterMethod = cls.getMethod(setMethodName, long.class);
			setterMethod.invoke(sObject, new Long(mylongValue));
		} catch (NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);			
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	}
	public void deserString(String setMethodName, String mystrValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;
		try{
			setterMethod = cls.getMethod(setMethodName, String.class);
			setterMethod.invoke(sObject, new String(mystrValue));	
		} catch(NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);					
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	
	
	}
	public void deserBool(String setMethodName, String myboolValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;
		try{
			setterMethod = cls.getMethod(setMethodName, boolean.class);
			setterMethod.invoke(sObject, new Boolean(myboolValue));	
		} catch(NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);					
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	}
	public void deserDouble(String setMethodName, String myDoubleValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;
		try{
			setterMethod = cls.getMethod(setMethodName, double.class);
			setterMethod.invoke(sObject, new Double(myDoubleValue));	
		} catch(NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);					
		} catch(NumberFormatException ex){
			System.err.println("Invalid number format for Double");
			ex.printStackTrace();
			System.exit(1);			
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	}
	public void deserFloat(String setMethodName, String myFloatValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;
		try{
			setterMethod = cls.getMethod(setMethodName, float.class);
			setterMethod.invoke(sObject, new Float(myFloatValue));	
		} catch(NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);					
		} catch(NumberFormatException ex){
			System.err.println("Invalid number format for Float");
			ex.printStackTrace();
			System.exit(1);		
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	}
	public void deserChar(String setMethodName, char myCharValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;
		try{
			setterMethod = cls.getMethod(setMethodName, char.class);
			setterMethod.invoke(sObject, new Character(myCharValue));	
		} catch(NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);					
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	
	}
	public void deserShort(String setMethodName, String myShortValue, SerializableObject sObject, Class<?> cls){
		Method setterMethod = null;
		try{
			setterMethod = cls.getMethod(setMethodName, short.class);
			setterMethod.invoke(sObject, new Short(myShortValue));	
		} catch(NoSuchMethodException ex){
			System.err.println("Cannot find method: " + setMethodName);
			ex.printStackTrace();
			System.exit(1);					
		} catch(NumberFormatException ex){
			System.err.println("Invalid number format for Short");
			ex.printStackTrace();
			System.exit(1);		
		} catch (IllegalAccessException | InvocationTargetException ex){
			System.err.println("Error: could not access method "+ setMethodName);
			ex.printStackTrace();
			System.exit(1);		
		}	
	}
}