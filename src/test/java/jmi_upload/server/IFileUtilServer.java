package jmi_upload.server;

import jmi_upload.inter.FileUtil;
import jmi_upload.inter.FileUtilImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by bf50 on 2016/1/7.
 */

/**
 * 声明Naming.rebind("rmi://127.0.0.1/IFileUtilServer", file) 中假定了RMI注册工具(RMI registry )
 * 使用并启动了1099端口。如果在其他端口运行了RMI注册工具，则必须在这个声明中定义。例如，
 * 如果RMI注册工具在4500端口运行，则声明应为：　　
 * Naming.rebind("rmi://127.0.0.1:4500/IFileUtilServer", file)
 * 另外我们已经同时假定了我们的服务端和RMI注册工具是运行在同一台机器上的。否则需要修改rebind方法中的地址。
 */
public class IFileUtilServer {
    public static void main(String[] args) {
        try {
            FileUtil file = new FileUtilImpl();

            LocateRegistry.createRegistry(1099); //加上此程序，就可以不要在控制台上开启RMI的注册程序，1099是RMI服务监视的默认端口

            Naming.rebind("rmi://127.0.0.1/IFileUtilServer", file);

            System.out.print("Ready");

        } catch (Exception e) {

            System.out.println("IFileUtilServer: " + e.getMessage());

            e.printStackTrace();

        }
    }
}
