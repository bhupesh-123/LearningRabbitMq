package com.example.LearningRabbitMq.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rabbit.mqproperties")
public class MqProperties {
    private RabbitMqBinding student;
    private RabbitMqBinding teacher;

    public MqProperties() {
    }

    public MqProperties(RabbitMqBinding student, RabbitMqBinding teacher) {
        this.student = student;
        this.teacher = teacher;
    }

    public RabbitMqBinding getStudent() {
        return student;
    }

    public void setStudent(RabbitMqBinding student) {
        this.student = student;
    }

    public RabbitMqBinding getTeacher() {
        return teacher;
    }

    public void setTeacher(RabbitMqBinding teacher) {
        this.teacher = teacher;
    }
}
