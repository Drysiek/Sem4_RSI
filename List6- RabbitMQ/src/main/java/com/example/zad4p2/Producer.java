package com.example.zad4p2;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Producer {
    public void publishMessage(String exchangeKey, String msg) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare("Exchange", BuiltinExchangeType.DIRECT);

            channel.basicPublish("Exchange", exchangeKey, null, msg.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception e ) {
            System.err.println(e.toString());
        }
    }
}
