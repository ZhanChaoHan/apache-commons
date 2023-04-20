package com.jachs.commonsrng;

import java.util.stream.IntStream;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.Test;

/**
 * @author zhanchaohan
 * @see https://commons.apache.org/proper/commons-rng/userguide/rng.html#Table_of_contents
 */
public class Demo2 {
    UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create();
    
    
    @Test
    public void t1() {
        byte[] a = new byte[47];
        // The elements of "a" are replaced with random values from the interval [-128, 127].
        rng.nextBytes(a);
        //随机填满数组
        for ( byte b : a ) {
            System.out.println (b);
        }
    }
    
    @Test
    public void t2() {
        byte[] a = new byte[47];
        // Replace 3 elements of the array (at indices 15, 16 and 17) with random values.
        rng.nextBytes(a, 15, 3);
        //替换三个元素 起始下标15-17随机生成
        for ( byte b : a ) {
            System.out.println (b);
        }
    }
    
    @Test
    public void t3() {
        int max=99;
        int min=2;
        
        IntStream s1 = rng.ints();         // [Integer.MIN_VALUE, Integer.MAX_VALUE]
        IntStream s2 = rng.ints(max);      // [0, max)
        IntStream s3 = rng.ints(min, max); // [min, max)
        
        // Roll a die 1000 times
        int[] rolls = rng.ints(1000, 1, 7).toArray();
        
        for ( int i : rolls ) {
            System.out.println (i);
        }
    }
    
}
