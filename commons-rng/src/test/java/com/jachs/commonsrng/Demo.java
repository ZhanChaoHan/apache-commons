package com.jachs.commonsrng;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.Test;

/**
 * @author zhanchaohan
 * @see https://commons.apache.org/proper/commons-rng/userguide/rng.html#Table_of_contents
 */
public class Demo {
    UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create();
    
    
    @Test
    public void t1() {
        //随机0-1之间小数
        double random = rng.nextDouble();
        
        System.out.println ( random);
    }
    
    @Test
    public void t2() {
        //随机生成布尔
        boolean isOn = rng.nextBoolean();
        
        System.out.println ( isOn);
    }
    
    @Test
    public void t3() {
        int max=100;
        int min=2;
        
        int n = rng.nextInt();         // Integer.MIN_VALUE <= n <= Integer.MAX_VALUE.
        int m = rng.nextInt(max);      // 0 <= m < max.
        int l = rng.nextInt(min, max); // min <= l < max.
        
        System.out.println (n);
        System.out.println (m);
        System.out.println (l);
    }
    
    @Test
    public void t5() {
        long max=100;
        long min=2;
        
        long n = rng.nextLong();         // Long.MIN_VALUE <= n <= Long.MAX_VALUE.
        long m = rng.nextLong(max);      // 0 <= m < max.
        long l = rng.nextLong(min, max); // min <= l < max.
        
        System.out.println (n);
        System.out.println (m);
        System.out.println (l);
    }
    
    @Test
    public void t6() {
        float max=99.9f;
        float min=6.6f;
        
        float x = rng.nextFloat();         // 0 <= x < 1.
        float y = rng.nextFloat(max);      // 0 <= y < max.
        float z = rng.nextFloat(min, max); // min <= z < max.
        
        System.out.println (x);
        System.out.println (y);
        System.out.println (z);
    }
    
    @Test
    public void t7() {
        double max=99.9;
        double min=6.6;
        
        double x = rng.nextDouble();         // 0 <= x < 1.
        double y = rng.nextDouble(max);      // 0 <= y < max.
        double z = rng.nextDouble(min, max); // min <= z < max.
        
        System.out.println (x);
        System.out.println (y);
        System.out.println (z);
    }
}
