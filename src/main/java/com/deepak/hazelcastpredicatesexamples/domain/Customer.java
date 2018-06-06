package com.deepak.hazelcastpredicatesexamples.domain;

import com.deepak.hazelcastpredicatesexamples.config.PortableFactoryImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable, Portable{

    private String customerName;
    private String customerId;
    private String customerAddress;
    private String customerPostcode;

    private static final long serialVersionUID = -1452911413348479402L;

    @JsonIgnore
    public int getFactoryId() {
        return PortableFactoryImpl.FACTORY_ID;
    }

    @JsonIgnore
    public int getClassId() {
        return PortableFactoryImpl.CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF("customerName", customerName);
        portableWriter.writeUTF("customerId", customerId);
        portableWriter.writeUTF("customerAddress", customerAddress);
        portableWriter.writeUTF("customerPostcode", customerPostcode);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        this.customerName=portableReader.readUTF("customerName");
        this.customerId=portableReader.readUTF("customerId");
        this.customerAddress=portableReader.readUTF("customerAddress");
        this.customerPostcode=portableReader.readUTF("customerPostcode");
    }
}
