package com.jachs.commons.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class D1 {

    @Test
    public void t1() throws Exception {
        FTPClient ftpClient = new FTPClient();
        
        ftpClient.connect("127.0.0.1",21);//IP地址，端口号
        ftpClient.login("admin","123456");//验证用户名密码
        
        //获取当前目录中所有文件
        FTPFile[] ftpFilesList = ftpClient.listFiles();
    }
    
}
