package model;

import java.time.Duration;
import java.time.LocalDate;

public class Worker {

    private String name;
    private LocalDate birthday;
    private char gender;
    private String phone;
    private String position;
    private String department;
    private String bossName;
    private LocalDate start;
    private double salary;
    private boolean active;
    private long dateDiff;


    public Worker(String name, LocalDate birthday, char gender, String phone, String position, String department, String bossName, LocalDate start, double salary) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.position = position;
        this.department = department;
        this.bossName = bossName;
        this.start = start;
        this.salary = salary;
        this.active = true;
        this.dateDiff = calculateDateDiff(start);
    }

    private long calculateDateDiff(LocalDate date) {
        return Duration.between(LocalDate.now().atStartOfDay(), date.atStartOfDay()).toDays();
    }

    public long getDateDiff() {
        return dateDiff;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.dateDiff = calculateDateDiff(start);
        this.start = start;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", bossName='" + bossName + '\'' +
                ", start=" + start +
                ", salary=" + salary +
                ", active=" + active +
                ", dateDiff=" + dateDiff +
                '}';
    }
}

