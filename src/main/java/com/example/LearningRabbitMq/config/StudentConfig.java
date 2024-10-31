package com.example.LearningRabbitMq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration("studentConfig")
@ConfigurationProperties(prefix = "rabbit.mqproperties")
public class StudentConfig {
    @NestedConfigurationProperty
    private RabbitMqBinding requested;

    public RabbitMqBinding getRequested() {
        return requested;
    }

    public void setRequested(RabbitMqBinding requested) {
        this.requested = requested;
    }

    public StudentConfig() {
    }
    public StudentConfig(RabbitMqBinding requested) {
        this.requested=requested;
    }


}
