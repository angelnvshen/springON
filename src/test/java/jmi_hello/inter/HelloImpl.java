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
     *  必须定义构造方法，即使是默认构造方法，也必须把它明确地写出来，因为它必须抛出出RemoteException异常
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
