package com.jachs.commons.collections4.list;

import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;

import com.jachs.commons.vo.People;

/***
 * 
 * @author zhanchaohan
 *
 */
public class TreeListDemo {

    /***
        列表实现经过优化，可在列表中的任何索引处快速插入和删除。
        此列表实现在内部使用树结构来确保所有插入和删除都是O（logn）。
        这提供了比ArrayList和LinkedList更快的性能，在ArrayList或LinkedList中，元素从列表中的任何位置重复插入和删除。
     */
    @Test
    public void t1() {
        TreeList<People>pList=new TreeList<> ();
        
    }
}
