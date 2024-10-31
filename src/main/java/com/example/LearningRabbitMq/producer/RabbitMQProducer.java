package com.example.LearningRabbitMq.producer;

import com.example.LearningRabbitMq.config.RabbitMQConfig;
import com.example.LearningRabbitMq.config.StudentConfig;
import com.example.LearningRabbitMq.config.TeacherConfig;
import com.example.LearningRabbitMq.model.Student;
import com.example.LearningRabbitMq.model.Teacher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;
    private  final StudentConfig studentConfig;
    private  final TeacherConfig teacherConfig;

    private  final String studentExchange="studentExchange";
    private  final String studentQueue="studentQueue";
    private  final String studentRoutingKey="studentRoutingKey";

    private  final String teacherQueue="teacherQueue";
    private  final String teacherExchange="teacherExchange";
    private  final String teacherRoutingKey="teacherRoutingKey";


    public RabbitMQProducer(RabbitTemplate rabbitTemplate,StudentConfig studentConfig,TeacherConfig teacherConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.studentConfig=studentConfig;
        this.teacherConfig=teacherConfig;
    }

    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
    }

    public void sendStudent(Student student){
        System.out.println("sending student Data : "+student);
        rabbitTemplate.convertAndSend(studentExchange,studentRoutingKey,student);
    }

    public  void sendTeacher(Teacher teacher){
        System.out.println("sending teacher Data : "+teacher);
        rabbitTemplate.convertAndSend(teacherExchange,teacherRoutingKey,teacher);

    }
}
