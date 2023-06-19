package com.example.zad4p2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;

public class consumer2 {
    public static void main(String[] args)
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String exchange = "my_exchange";
            channel.exchangeDeclare(exchange, "direct");

            String queueName = channel.queueDeclare().getQueue();

            String routingKey1 = "key2";
            channel.queueBind(queueName, exchange, routingKey1);

            System.out.println("Waiting for messages with routing key " + routingKey1);

            Consumer consumer = new DefaultConsumer(channel) {
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Received message: " + message);
                }
            };

            channel.basicConsume(queueName, true, consumer);

            Scanner sc = new Scanner(System.in);
            sc.next();

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
