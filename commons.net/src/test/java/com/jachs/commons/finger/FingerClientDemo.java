package com.jachs.commons.finger;


import org.apache.commons.net.finger.FingerClient;
import org.junit.Test;

/***
 * Finger：显示有关运行 Finger 服务或 Daemon 的指定远程计算机（通常是运行 UNIX 的计算机）上用户的信息。
 * 该远程计算机指定显示用户信息的格式和输出。实现该协议的类是FingerClient

 * @author zhanchaohan
 *
 */
public class FingerClientDemo {
    FingerClient finger= new FingerClient();
    
    @Test
    public void t1() throws Exception {
        finger.connect("192.168.2.150");
        System.out.println(finger.query(true,"root"));
        finger.disconnect();
    }
}
