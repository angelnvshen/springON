package jmi_upload.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by bf50 on 2016/1/7.
 */
public interface FileUtil extends Remote {
    public byte [] downloadFile(String fileName) throws RemoteException;
}
