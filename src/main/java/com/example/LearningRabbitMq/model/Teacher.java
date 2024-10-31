package com.example.LearningRabbitMq.model;

import lombok.*;

@Builder(toBuilder = true)
public class Teacher {
    private String empId;
    private String name;
    private String address;
    private String spacilization;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpacilization() {
        return spacilization;
    }

    public void setSpacilization(String spacilization) {
        this.spacilization = spacilization;
    }

    public Teacher(String empId, String name, String address, String spacilization) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.spacilization = spacilization;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", spacilization='" + spacilization + '\'' +
                '}';
    }
}
