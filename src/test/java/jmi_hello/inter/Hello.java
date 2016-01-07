package jmi_hello.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by bf50 on 2016/1/6.
 */
/**
 * 远程接口必须扩展接口java.rmi.Remote
 */
public interface Hello extends Remote{
    /**
     * 远程接口方法必须抛出 java.rmi.RemoteException
     */
    public String say() throws RemoteException;
}
