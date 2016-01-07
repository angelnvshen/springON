package jmi_hello.client;

import jmi_hello.inter.Hello;
import jmi_hello.inter.HelloImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by bf50 on 2016/1/6.
 */
public class HelloClient {
    /**
     * ����Զ�̶��󲢵���Զ�̷���
     */
    public static void main(String[] args) {
        try {
            Hello hello = (Hello) Naming.lookup("Hello");

            //���Ҫ����һ̨������RMIע�����Ļ����ϲ���helloʵ��
            //HelloInterface hello = (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");

            //����Զ�̷���
            System.out.println(hello.say());

        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e);
        }
    }
}
