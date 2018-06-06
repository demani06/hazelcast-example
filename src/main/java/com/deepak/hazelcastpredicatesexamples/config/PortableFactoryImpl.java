package com.deepak.hazelcastpredicatesexamples.config;

import com.deepak.hazelcastpredicatesexamples.domain.Customer;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

public class PortableFactoryImpl implements PortableFactory{


    public static final int CLASS_ID = 1;
    public static final int FACTORY_ID = 1;

    @Override
    public Portable create(int classId) {
        switch (classId){
            case CLASS_ID:
                return new Customer();
                default:
                    return null;
        }
    }
}
