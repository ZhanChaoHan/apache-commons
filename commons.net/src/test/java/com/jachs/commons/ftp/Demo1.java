package com.jachs.commons.ftp;


/***
 * 
 * @author zhanchaohan
 *
 */
public class Demo1 {
    /** 
     *  创建文件夹
     */  
    public  void mkdir() {
        FtpClientUtil clientUtil=new FtpClientUtil();
        clientUtil.mkdir("test");
    }  

    /** 
     *  下载文件
     */  
    public  void download() {  
        String remoteFileName="./111.txt";
        String locaFileName="F:\\test\\txt\\3333.txt";
        FtpClientUtil clientUtil=new FtpClientUtil();
        clientUtil.download(remoteFileName, locaFileName);
    }  

    /** 
     *  上传文件
     */  
    public  void upload() {  
        String remoteFileName="./111.txt";
        String locaFileName="F:\\test\\txt\\aaa.txt";
        FtpClientUtil clientUtil=new FtpClientUtil();
        clientUtil.upload(remoteFileName, locaFileName);
    }  
}
