package com.jachs.commons.collections4.list;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.list.FixedSizeList;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class FixedSizeListDemo {

    /***
        装饰另一个列表以修复阻止添加/删除的大小。
        不支持添加、删除、清除和保留操作。set方法是允许的（因为它不会更改列表大小）。
        注意：直接修改修饰列表会影响此对象上方法调用的结果。例如，此列表的边界将反映新添加到基础列表的对象。
        此类可从Commons Collections 3.1中序列化。
     */
    @Test
    public void t1() {
        List<FixedSizeList>fc=new ArrayList<> ();
        FixedSizeList<FixedSizeList> fList=FixedSizeList.fixedSizeList ( fc );
        
    }
}
