package com.jachs.commons_pool2.example.part1;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/***
 * 
 * @author zhanchaohan
 *
 */
public class CommonObjectPool extends GenericObjectPool<Student> {
	 
    public CommonObjectPool(PooledObjectFactory<Student> factory, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
