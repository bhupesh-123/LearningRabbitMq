package com.example.LearningRabbitMq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration("teacherConfig")
@ConfigurationProperties(prefix = "rabbit.mqproperties")
public class TeacherConfig {
    @NestedConfigurationProperty
    private RabbitMqBinding requested;

    public RabbitMqBinding getRequested() {
        return requested;
    }

    public void setRequested(RabbitMqBinding requested) {
        this.requested = requested;
    }

    public TeacherConfig(RabbitMqBinding requested) {
        this.requested = requested;
    }

    public TeacherConfig() {
    }
}
