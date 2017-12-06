package genericCheckpointing.util;

import genericCheckpointing.server.StoreRestoreI;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class ProxyCreator{

	public void createProxy(StoreRestoreI interfaceArray, InvocationHandler handler){
		StoreRestoreI  serDeserObj =
            (StoreRestoreI)
            Proxy.newProxyInstance(getClass().getClassLoader(),
                                   interfaceArray,
                                   handler
                                   );

	}

}
