package jmi_upload.server;

import jmi_upload.inter.FileUtil;
import jmi_upload.inter.FileUtilImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by bf50 on 2016/1/7.
 */

/**
 * ����Naming.rebind("rmi://127.0.0.1/IFileUtilServer", file) �мٶ���RMIע�Ṥ��(RMI registry )
 * ʹ�ò�������1099�˿ڡ�����������˿�������RMIע�Ṥ�ߣ����������������ж��塣���磬
 * ���RMIע�Ṥ����4500�˿����У�������ӦΪ������
 * Naming.rebind("rmi://127.0.0.1:4500/IFileUtilServer", file)
 * ���������Ѿ�ͬʱ�ٶ������ǵķ���˺�RMIע�Ṥ����������ͬһ̨�����ϵġ�������Ҫ�޸�rebind�����еĵ�ַ��
 */
public class IFileUtilServer {
    public static void main(String[] args) {
        try {
            FileUtil file = new FileUtilImpl();

            LocateRegistry.createRegistry(1099); //���ϴ˳��򣬾Ϳ��Բ�Ҫ�ڿ���̨�Ͽ���RMI��ע�����1099��RMI������ӵ�Ĭ�϶˿�

            Naming.rebind("rmi://127.0.0.1/IFileUtilServer", file);

            System.out.print("Ready");

        } catch (Exception e) {

            System.out.println("IFileUtilServer: " + e.getMessage());

            e.printStackTrace();

        }
    }
}
