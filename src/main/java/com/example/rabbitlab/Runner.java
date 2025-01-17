package com.example.rabbitlab;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private static final String directExchangeName = "NovikovDanila-direct-exchange-2103290";
    private static final String fanoutExchangeName = "NovikovDanila-fanout-exchange-2103290";
    private static final String routingKey = "2103290";

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        int i = 0;
        while (true) {
            System.out.printf("Iteration %d: Sending message to fanout exchange...\n", i);
            rabbitTemplate.convertAndSend(fanoutExchangeName, "", "Fanout Exchange -> Novikov D V 2103829 | Time: " + LocalTime.now());
            System.out.printf("Iteration %d: Sending message to direct exchange...\n", i);
            rabbitTemplate.convertAndSend(directExchangeName, routingKey, "Direct Exchange -> Novikov D V 2103829 | Time: " + LocalTime.now());
            i++;
            Thread.sleep(10000);
        }
    }
}

