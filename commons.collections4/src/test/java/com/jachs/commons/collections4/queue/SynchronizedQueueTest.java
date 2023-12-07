package com.jachs.commons.collections4.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.SynchronizedQueue;

import com.jachs.commons.collections4.queue.thread.SynchronizedQueueThread;
import com.jachs.commons.vo.People;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SynchronizedQueueTest {
    static int Qsize=20;//队列大小不设默认32
    private static CircularFifoQueue<People> cfq=new CircularFifoQueue(Qsize);
    public static SynchronizedQueue<People> sq;
    
    public static void init() {
        for ( int kk = 0 ; kk < Qsize ; kk++ ) {//初始化几条测试数据
            cfq.add ( new People ( "测试人"+kk, kk ) );
        }
    }
    
    public static void main ( String[] args ) {
        init();
        sq=SynchronizedQueue.synchronizedQueue ( cfq );
        
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        
        /*
        while(!sq.isEmpty ()) {
            try {
//                System.out.println ("队列大小:"+ sq.size () );
                fixedThreadPool.execute ( new SynchronizedQueueThread() );
                Thread.sleep ( 500 );//避免死循环一直创建线程,主线程休眠一段时间等任务线程 
            }
            catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
        */
        
       for ( int kk = 0 ; kk < Qsize; kk++ ) {//for循环不用考虑死循环问题
           fixedThreadPool.execute ( new SynchronizedQueueThread() );
       }
       fixedThreadPool.shutdown ();
    }
}
