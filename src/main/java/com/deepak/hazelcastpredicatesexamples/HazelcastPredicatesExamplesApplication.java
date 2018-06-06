package com.deepak.hazelcastpredicatesexamples;

import com.deepak.hazelcastpredicatesexamples.config.PortableFactoryImpl;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.jet.Jet;
import com.hazelcast.jet.JetInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HazelcastPredicatesExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastPredicatesExamplesApplication.class, args);
	}

	@Bean
	public JetInstance jetInstance(){
		ClientConfig clientConfig = new ClientConfig();
		SerializationConfig serializationConfig = clientConfig.getSerializationConfig();
		serializationConfig.addPortableFactoryClass(1, PortableFactoryImpl.class);
		return Jet.newJetClient(clientConfig);
	}
}
