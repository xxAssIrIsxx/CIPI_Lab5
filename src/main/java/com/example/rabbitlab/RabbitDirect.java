package com.example.rabbitlab;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirect {

    final static String directExchangeName = "NovikovDanila-direct-exchange-2103290";
    final static String directQueueName = "NovikovDanila-direct-queue-2103290";
    final static String routingKey = "2103290";

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchangeName);
    }

    @Bean
    Queue directQueue() {
        return new Queue(directQueueName, true);
    }

    @Bean
    Binding directBinding(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(routingKey);
    }
}