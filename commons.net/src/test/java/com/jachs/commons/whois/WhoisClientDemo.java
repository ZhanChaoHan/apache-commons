package com.jachs.commons.whois;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.whois.WhoisClient;
import org.junit.Test;

/***
 * 利用WHOIS协议查询Internet域名
 * @author zhanchaohan
 *
 */
public class WhoisClientDemo {

    @Test
    public void t1() throws SocketException, IOException {
        WhoisClient whois= new WhoisClient();
        whois.connect(WhoisClient.DEFAULT_HOST);
        System.out.println(whois.query("baidu.com"));
        whois.disconnect();
    }
}
