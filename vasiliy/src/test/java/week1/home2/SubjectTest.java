package week1.home2;

import org.junit.Assert;
import org.junit.Test;

public class SubjectTest {

    @Test
    public void increaseWorkingHours1() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Subject subject = new Subject(subjectMath);

        boolean expected = true;
        boolean actual = subject.increaseWorkingHours(30);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void increaseWorkingHours2() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Subject subject = new Subject(subjectMath);

        boolean expected = false;
        boolean actual = subject.increaseWorkingHours(70);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void increaseWorkingHours3() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Subject subject = new Subject(subjectMath);
        subject.increaseWorkingHours(50);

        boolean expected = false;
        boolean actual = subject.increaseWorkingHours(20);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setMark1() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Subject subject = new Subject(subjectMath);

        boolean expected = true;
        boolean actual = subject.setMark(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setMark2() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Subject subject = new Subject(subjectMath);

        boolean expected = false;
        boolean actual = subject.setMark(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setMark3() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Subject subject = new Subject(subjectMath);

        boolean expected = false;
        boolean actual = subject.setMark(10);
        Assert.assertEquals(expected, actual);
    }
}