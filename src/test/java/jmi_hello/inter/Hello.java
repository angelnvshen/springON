package jmi_hello.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by bf50 on 2016/1/6.
 */
/**
 * Զ�̽ӿڱ�����չ�ӿ�java.rmi.Remote
 */
public interface Hello extends Remote{
    /**
     * Զ�̽ӿڷ��������׳� java.rmi.RemoteException
     */
    public String say() throws RemoteException;
}
