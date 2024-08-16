package com.prakash.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

//@Configuration
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String, Object> producerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "locahost:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "${kafka.group-id}");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.prakash.dto");
		
		DefaultKafkaConsumerFactory<String, Object> dkcf = new DefaultKafkaConsumerFactory<>(props);
		return dkcf;
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> containerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Object> cklcf = new ConcurrentKafkaListenerContainerFactory<>();
		cklcf.setConsumerFactory(producerFactory());
		return cklcf;
	}
}
