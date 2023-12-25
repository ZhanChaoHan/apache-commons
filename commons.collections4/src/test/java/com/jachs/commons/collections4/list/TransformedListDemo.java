package com.jachs.commons.collections4.list;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.list.TransformedList;
import org.junit.Test;

import com.jachs.commons.vo.Human;
import com.jachs.commons.vo.People;

/***
 * 
 * @author zhanchaohan
 *
 */
public class TransformedListDemo {

    
    /***
        装饰另一个列表以变换添加的对象。
        add和set方法受此类的影响。因此，必须使用转换后的形式删除或搜索对象。
        例如，如果转换将Strings转换为Integers，则必须使用Integer形式删除对象。
        此类可从Commons Collections 3.1中序列化。
     */
    @Test
    public void t1() {
        Transformer tf=new Transformer<People, Human>() {
            @Override
            public Human transform ( People input ) {
                Human h=new Human ();
                
                h.setH_age ( input.getAge () );
                h.setH_name ( input.getName () );
                return h;
            }
        };
        
        List<People>pList=new ArrayList<> ();
        pList.add ( new People ( "jack", 0 ) );
        pList.add ( new People ( "pm", 1 ) );
        
        TransformedList<Human> tList=TransformedList.transformedList ( pList, tf );
        
        tList.forEach ( a->{
            System.out.println ( a.getH_name ()+"\t\t"+a.getH_age () );
        } );
    }
}
