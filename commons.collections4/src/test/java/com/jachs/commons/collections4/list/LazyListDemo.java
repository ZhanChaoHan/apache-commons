package com.jachs.commons.collections4.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.list.LazyList;
import org.junit.Test;

/**
 * 
 * @author zhanchaohan
 *
 */
public class LazyListDemo {

    /***
     * 当使用大于列表大小的索引调用get（int）方法时，列表的大小将自动增加，并从指定的工厂或转换器返回新对象。
     * 空白将由null填充。如果get方法调用遇到null，它将被工厂中的新对象替换。因此，此列表不适合存储空对象。
     */
    @Test
    public void t1() {
        Factory<Date> factory = new Factory<Date>() {
            public Date create() {
                return new Date();
            }
        };
        List<Date> lazy = LazyList.lazyList(new ArrayList<Date>(), factory);
        Date date = lazy.get(3);
        
        System.out.println ( date );
    }
}
