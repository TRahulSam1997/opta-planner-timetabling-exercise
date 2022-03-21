package org.acme.timetabling.rest;

import org.acme.timetabling.domain.Lesson;
import org.acme.timetabling.domain.Room;
import org.acme.timetabling.domain.TimeSlot;
import org.acme.timetabling.domain.TimeTable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;

@Path("/timeTable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeTableResource {

    @GET
    public TimeTable getTimeTable() {
        TimeSlot timeslot = new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30));
        Room room = new Room("Room A");
        Lesson lesson = new Lesson("Math", "A. Turing", "9th Grade");
        return new TimeTable(Collections.singletonList(timeslot), Collections.singletonList(room),
                Collections.singletonList(lesson));
    }
}
