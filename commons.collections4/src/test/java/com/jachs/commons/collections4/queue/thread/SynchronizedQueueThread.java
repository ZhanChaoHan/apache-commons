package com.jachs.commons.collections4.queue.thread;

import org.apache.commons.lang3.RandomUtils;

import com.jachs.commons.collections4.queue.SynchronizedQueueTest;
import com.jachs.commons.vo.People;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SynchronizedQueueThread implements Runnable{

    @Override
    public void run () {
        RandomUtils ru=new RandomUtils ();
        
        try {
            long sleepTime=ru.nextLong (1000, 5000 );
            Thread.sleep ( sleepTime );//随机休眠个几秒,模拟任务执行耗时
            
            People peo= SynchronizedQueueTest.sq.poll ();
            if(peo!=null) {
                System.out.println ("线程ID："+Thread.currentThread ().getId ()+"\t"
                +"休眠："+sleepTime+"毫秒\t\t"
                + peo.getName ()+"\t\t"+peo.getAge () );
            }
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        
    }

}
