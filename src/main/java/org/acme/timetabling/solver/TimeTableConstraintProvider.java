package org.acme.timetabling.solver;

import org.acme.timetabling.domain.Lesson;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                roomConflict(constraintFactory),
                teacherConflict(constraintFactory),
                studentGroupConflict(constraintFactory),
                teacherTimeEfficiency(constraintFactory)
        };

    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getRoom))
                .penalize("Room Conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint teacherConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getTeacher))
                .penalize("Teacher Conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint studentGroupConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTimeSlot), Joiners.equal(Lesson::getStudentGroup))
                .penalize("Student group Conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint teacherTimeEfficiency(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Lesson.class)
                .join(Lesson.class,
                        Joiners.equal(Lesson::getTeacher))
                .reward("Teacher time efficiency", HardSoftScore.ONE_SOFT);
    }
}