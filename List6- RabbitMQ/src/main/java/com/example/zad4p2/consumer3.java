package com.example.zad4p2;

import com.rabbitmq.client.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class consumer3 {
    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare("Kolejka", false, false, false, null);

            DefaultConsumer consumer = new DefaultConsumer(channel) {
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String msg = new String(body, StandardCharsets.UTF_8);
//                    System.out.println("Received request for image: " + msg);
                    File imageFile = new File("C:\\Users\\505ry\\OneDrive\\Pulpit\\zad4p2\\src\\main\\java\\com\\example\\zad4p2\\images\\"+msg+".png");
                    byte[] imageBytes = Files.readAllBytes(imageFile.toPath());

                    channel.basicPublish("", properties.getReplyTo(), properties, imageBytes);
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            };

            channel.basicConsume("Kolejka", false, consumer);

        } catch (Exception e ) {
            System.err.println(e.toString());
        }
    }
}
