package com.example.LearningRabbitMq.consumer;

import com.example.LearningRabbitMq.config.RabbitMQConfig;
import com.example.LearningRabbitMq.model.Student;
import com.example.LearningRabbitMq.model.Teacher;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @RabbitListener(queues = "studentQueue")
    public  void receiveStudent(Student student){
        System.out.println("Received student message: " + student);


    }

    @RabbitListener(queues = "teacherQueue")
    public  void receiveTeacher(Teacher teacher){
        System.out.println("Received teacher message: " + teacher);


    }
}
