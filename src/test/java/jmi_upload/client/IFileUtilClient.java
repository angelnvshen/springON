package jmi_upload.client;

import jmi_upload.inter.FileUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.Naming;

/**
 * Created by bf50 on 2016/1/7.
 */
public class IFileUtilClient {
    public static void main(String[] args) {
        try {
            String remoteServerIP = "127.0.0.1";
            String remoteFileName = "D:\\Jar\\TODO_Co.txt";
            String savedFileName = "C:\\Users\\bf50\\Desktop\\T.txt";
            String name = "rmi://" + remoteServerIP + "/IFileUtilServer";

            FileUtil fileUtil = (FileUtil) Naming.lookup(name);

            byte[] filedata = fileUtil.downloadFile(remoteFileName);

            if(filedata==null){

                System.out.println("Error£º<filedata is null!>");

                System.exit(0);

            }

            File file = new File(savedFileName);

            System.out.println("file.getAbsolutePath() = "+file.getAbsolutePath());

            BufferedOutputStream output = new BufferedOutputStream(

                    new FileOutputStream(file.getAbsolutePath()));

            output.write(filedata, 0, filedata.length);

            output.flush();

            output.close();

            System.out.println("~~~~~End~~~~~");

        } catch (Exception e) {

            System.err.println("IFileUtilServer exception: " + e.getMessage());

            e.printStackTrace();

        }

    }
}
