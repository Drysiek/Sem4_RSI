package com.example.zad4p2;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ProducerImage implements AutoCloseable {
    ConnectionFactory factory = new ConnectionFactory();
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    public ProducerImage() throws IOException, TimeoutException {
    }

    public byte[] getImage(String msg) throws IOException, TimeoutException, ExecutionException, InterruptedException {
        factory.setHost("localhost");

        String correlationID = UUID.randomUUID().toString();
        String replyQName = channel.queueDeclare().getQueue();

        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .correlationId(correlationID)
                .replyTo(replyQName)
                .build();

        channel.basicPublish("", "Kolejka", props, msg.getBytes(StandardCharsets.UTF_8));

        CompletableFuture<byte[]> response = new CompletableFuture<>();

        String tag = channel.basicConsume(replyQName, true, (consumerTag, receivedMessage) -> {
            if (receivedMessage.getProperties().getCorrelationId().equals(correlationID)) {
                System.out.println("Received response");
                response.complete(receivedMessage.getBody());
            }
        }, consumerTag -> {});

        byte[] result = response.get();
        channel.basicCancel(tag);
        return result;
    }

    @Override
    public void close() throws Exception {
        channel.close();
        connection.close();
    }
}
