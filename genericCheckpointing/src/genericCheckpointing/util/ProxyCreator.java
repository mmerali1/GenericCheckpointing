package genericCheckpointing.util;

import genericCheckpointing.server.StoreRestoreI;
public class ProxyCreator{

	public void createProxy(StoreRestoreI interfaceArray){
		StoreRestoreI  serDeserObj =
            (StoreRestoreI)
            Proxy.newProxyInstance(getClass().getClassLoader(),
                                   interfaceArray,
                                   handler
                                   );

	}

}
