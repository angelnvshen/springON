package jmi_hello.server;

import jmi_hello.inter.Hello;
import jmi_hello.inter.HelloImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by bf50 on 2016/1/6.
 */
public class HelloService {
    public static void main(String[] args) {
        try {
            //����RMIע�����ָ���˿�Ϊ1099����1099ΪĬ�϶˿ڣ�
            //Ҳ����ͨ������ ��java_home/bin/rmiregistry 1099����
            //���������ַ�ʽ�������ٴ�һ��DOS����
            //����������rmiregistry����ע����񻹱���������RMIC����һ��stub��Ϊ������
            LocateRegistry.createRegistry(1099);

            //����Զ�̶����һ������ʵ����������hello����
            //�����ò�ͬ����ע�᲻ͬ��ʵ��
            Hello hello = new HelloImpl("Hello, world !");

            //��helloע�ᵽRMIע��������ϣ�����ΪHello
            Naming.rebind("Hello", hello);

            //���Ҫ��helloʵ��ע�ᵽ��һ̨������RMIע�����Ļ�����
            //Naming.rebind("//192.168.1.105:1099/Hello",hello);

            System.out.println("Hello server is ready .");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hello server failed : " + e);
        }
    }
}
