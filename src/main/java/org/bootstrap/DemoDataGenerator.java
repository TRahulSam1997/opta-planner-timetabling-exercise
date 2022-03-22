package org.bootstrap;

import io.quarkus.runtime.StartupEvent;
import org.acme.timetabling.domain.Lesson;
import org.acme.timetabling.domain.Room;
import org.acme.timetabling.domain.TimeSlot;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DemoDataGenerator {

    @Transactional
    public void generateDemoDate(@Observes StartupEvent startupEvent) {
        List<TimeSlot> timeSlotList = new ArrayList<>(10);
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));

        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeSlotList.add(new TimeSlot(DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));

        TimeSlot.persist(timeSlotList);

        List<Room> roomList = new ArrayList<>(3);
        roomList.add(new Room("Room A"));
        roomList.add(new Room("Room B"));
        roomList.add(new Room("Room C"));

        Room.persist(roomList);

        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(new Lesson("Math", "A. Turing", "9th grade"));
        lessonList.add(new Lesson("Math", "A. Turing", "9th grade"));
        lessonList.add(new Lesson("Physics", "M. Curie", "9th grade"));
        lessonList.add(new Lesson("Chemistry", "M. Curie", "9th grade"));
        lessonList.add(new Lesson("Biology", "C. Darwin", "9th grade"));
        lessonList.add(new Lesson("History", "I. Jones", "9th grade"));
        lessonList.add(new Lesson("English", "I. Jones", "9th grade"));
        lessonList.add(new Lesson("English", "I. Jones", "9th grade"));
        lessonList.add(new Lesson("Spanish", "P. Cruz", "9th grade"));
        lessonList.add(new Lesson("Spanish", "P. Cruz", "9th grade"));

        lessonList.add(new Lesson("Math", "A. Turing", "10th grade"));
        lessonList.add(new Lesson("Math", "A. Turing", "10th grade"));
        lessonList.add(new Lesson("Math", "A. Turing", "10th grade"));
        lessonList.add(new Lesson("Physics", "M. Curie", "10th grade"));
        lessonList.add(new Lesson("Chemistry", "M. Curie", "10th grade"));
        lessonList.add(new Lesson("French", "M. Curie", "10th grade"));
        lessonList.add(new Lesson("Geography", "C. Darwin", "10th grade"));
        lessonList.add(new Lesson("History", "I. Jones", "10th grade"));
        lessonList.add(new Lesson("English", "P. Cruz", "10th grade"));
        lessonList.add(new Lesson("Spanish", "P. Cruz", "10th grade"));

        Lesson.persist(lessonList);
    }
}
