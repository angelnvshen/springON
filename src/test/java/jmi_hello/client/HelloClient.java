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
     * 查找远程对象并调用远程方法
     */
    public static void main(String[] args) {
        try {
            Hello hello = (Hello) Naming.lookup("Hello");

            //如果要从另一台启动了RMI注册服务的机器上查找hello实例
            //HelloInterface hello = (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");

            //调用远程方法
            System.out.println(hello.say());

        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e);
        }
    }
}
