package com.ea.miushop_cart.configuration;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

import java.util.Arrays;
import java.util.List;

@Configuration
//@ComponentScan("com.ea.miushop")
//@IntegrationComponentScan("com.ea.miushop.integration")
//@EnableIntegration
public class AmqpConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    //Binding queues to exchanges

    @Bean
    public Queue sendOrderQueue() {
        return new Queue("sendOrder", true,false,false);
    }

    @Bean
    TopicExchange orderExchange() {
        return new TopicExchange("miuShopOrderDirectExchange");
    }

    @Bean
    List<Binding> bindings() {

        return Arrays.asList(BindingBuilder.bind(sendOrderQueue())
                .to(orderExchange()).with("make.order.#"));
    }


    //PurchaseOrder producer

    @Bean
    public RabbitTemplate makeOrderTemplate() {
        RabbitTemplate makeOrderTemplate= new RabbitTemplate(connectionFactory());
        makeOrderTemplate.setRoutingKey("make.order");
        makeOrderTemplate.setExchange("miuShopOrderDirectExchange");
        makeOrderTemplate.setReplyTimeout(2000);
        return makeOrderTemplate;
    }

}
