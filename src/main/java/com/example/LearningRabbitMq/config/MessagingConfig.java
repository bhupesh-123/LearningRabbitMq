package com.example.LearningRabbitMq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    private final MqProperties mqProperties;

    public MessagingConfig(MqProperties mqProperties) {
        this.mqProperties = mqProperties;
    }

    @Bean
    @Qualifier("studentQueue")
    public Queue studentQueue(){
               return  new Queue(mqProperties.getStudent().getQueue());
    }

    @Bean
    @Qualifier("studentExchange")
    public DirectExchange studentExchange(){
        return  new DirectExchange(mqProperties.getStudent().getExchange());

    }

    @Bean
    public Binding studentBinding(@Qualifier("studentQueue") Queue queue,@Qualifier("studentExchange") DirectExchange directExchange){
      return   BindingBuilder.bind(queue).to(directExchange).with(mqProperties.getStudent().getRoutingKey());
    }

    @Bean
    @Qualifier("teacherQueue")
    public Queue teacherQueue(){
        return  new Queue(mqProperties.getTeacher().getQueue());
    }

    @Bean
    @Qualifier("teacherExchange")
    public DirectExchange teacherExchange(){
        return  new DirectExchange(mqProperties.getTeacher().getExchange());
    }

    @Bean
    public Binding teacherBinding(@Qualifier("teacherQueue") Queue queue,@Qualifier("teacherExchange") DirectExchange directExchange){
        return  BindingBuilder.bind(queue).to(directExchange).with(mqProperties.getTeacher().getRoutingKey());

    }

    @Bean
    public Jackson2JsonMessageConverter jacksonConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter jacksonConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jacksonConverter);
        return template;
    }

}
