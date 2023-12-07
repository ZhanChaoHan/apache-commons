package com.jachs.commons.collections4.queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;

import com.jachs.commons.vo.People;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CircularFifoQueueTest {
    CircularFifoQueue<People> cfq=new CircularFifoQueue<People>();
    
    private void print() {
        cfq.forEach ( p->{
            System.out.println ( p.getName ()+"\t\t"+p.getAge () );
        } );
    }
	@Test
	public void test1() {
		cfq.add(new People("amn", 0));
		cfq.add(new People("bmn", 1));
		cfq.add(new People("cmn", 2));
		cfq.add(new People("dmn", 3));
		cfq.add(new People("emn", 4));
		
		cfq.peek();//取队头数据不删除
		
		cfq.poll ();//取队头数据删除,如果队列为空返回null
		cfq.remove ();//取队头数据删除,如果队列为空抛异常
		
		cfq.clear ();//清空队列
		
		cfq.maxSize ();//最大容量
		cfq.size ();//实际存储大小
		
		cfq.isEmpty ();//是否为空
		cfq.isAtFullCapacity ();//是否满队
		
		cfq.isFull ();//但对于 CircularFifoQueue，isFull 方法将始终返回 false，因为队列始终可以接受新元素：
		
		
		print();
		
		cfq.get ( 1 );//下标读取
		
		
	}
}
