package org.acme.timetabling.domain;

import java.util.List;

public class TimeTable {

    private List<TimeSlot> timeSlotList;
    private List<Room> roomList;
    private List<Lesson> lessonList;

    public TimeTable() {

    }

    public TimeTable(List<TimeSlot> timeSlotList, List<Room> roomList, List<Lesson> lessonList) {
        this.timeSlotList = timeSlotList;
        this.roomList = roomList;
        this.lessonList = lessonList;
    }

    public List<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }
}
