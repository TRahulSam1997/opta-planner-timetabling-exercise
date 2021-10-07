package org.acme.timetabling.domain;

public class Lesson {

    private Long id;

    private String subject;
    private String teacher;
    private String studentGroup;

    private TimeSlot timeSlot;
    private Room room;

    public Lesson() {

    }

    public Lesson(String subject, String teacher, String studentGroup) {
        this.subject = subject;
        this.teacher = teacher;
        this.studentGroup = studentGroup;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "subject='" + subject + "(" + id + ")" + '\'' +
                '}';
    }


}