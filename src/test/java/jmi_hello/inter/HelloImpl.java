package jmi_hello.inter;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by bf50 on 2016/1/6.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    private String message;

    /**
     *  ���붨�幹�췽������ʹ��Ĭ�Ϲ��췽����Ҳ���������ȷ��д��������Ϊ�������׳���RemoteException�쳣
     * @param message
     */
    public HelloImpl(String message) throws RemoteException{
        this.message = message;
    }

    public String say() throws RemoteException {
        System.out.println("Called By HelloClient ");
        return message;
    }
}
