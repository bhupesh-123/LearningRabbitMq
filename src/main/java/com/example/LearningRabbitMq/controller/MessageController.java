package com.example.LearningRabbitMq.controller;

import com.example.LearningRabbitMq.model.Student;
import com.example.LearningRabbitMq.model.Teacher;
import com.example.LearningRabbitMq.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }

    @PostMapping("/student")
    public ResponseEntity<String> sendStudent(@RequestBody Student student) {
        producer.sendStudent(student);
        return ResponseEntity.ok("Message sent: " + student);
    }
    @PostMapping("/teacher")
    public ResponseEntity<String> sendTeacher(@RequestBody Teacher teacher) {
        producer.sendTeacher(teacher);
        return ResponseEntity.ok("Message sent: " + teacher);
    }
}
