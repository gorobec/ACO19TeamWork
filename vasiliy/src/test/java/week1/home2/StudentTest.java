package week1.home2;

import org.junit.*;

public class StudentTest {

    @Test
    public void findSubject1(){
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        SubjectInfo subjectEng = new SubjectInfo("Eng", 40);

        Student student = new Student("StudentName1", "Address1");

        student.addSubject(subjectMath);
        student.addSubject(subjectPhys);
        student.addSubject(subjectEng);

        int expected = 1;
        int actual = student.findSubject(subjectPhys);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findSubject2(){
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        SubjectInfo subjectEng = new SubjectInfo("Eng", 40);

        Student student = new Student("StudentName1", "Address1");

        student.addSubject(subjectMath);
        student.addSubject(subjectPhys);

        int expected = -1;
        int actual = student.findSubject(subjectEng);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addSubject1(){
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);

        Student student = new Student("StudentName1", "Address1");

        boolean expected = true;
        boolean actual = student.addSubject(subjectMath);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addSubject2(){
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Student student = new Student("StudentName1", "Address1");
        student.addSubject(subjectMath);

        boolean expected = false;
        boolean actual = student.addSubject(subjectMath);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void study1() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Student student = new Student("StudentName1", "Address1");
        student.addSubject(subjectMath);

        boolean expected = true;
        boolean actual = student.study(subjectMath, 30);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void study2() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        Student student = new Student("StudentName1", "Address1");
        student.addSubject(subjectMath);

        boolean expected = false;
        boolean actual = student.study(subjectPhys, 10);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void passExam1() throws Exception {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Student student = new Student("StudentName1", "Address1");
        student.addSubject(subjectMath);

        boolean expected = true;
        boolean actual = student.passExam(subjectMath, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void passExam2() throws Exception {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        Student student = new Student("StudentName1", "Address1");
        student.addSubject(subjectMath);

        boolean expected = false;
        boolean actual = student.passExam(subjectPhys, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void passExam3() throws Exception {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        Student student = new Student("StudentName1", "Address1");
        student.addSubject(subjectMath);

        boolean expected = false;
        boolean actual = student.passExam(subjectPhys, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastSubject1() throws Exception {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        Student student = new Student("StudentName1", "Address1");
        student.addSubject(subjectMath);

        boolean expected = true;
        boolean actual = student.removeLastSubject();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastSubject2() throws Exception {
        Student student = new Student("StudentName1", "Address1");

        boolean expected = false;
        boolean actual = student.removeLastSubject();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageMark1() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        SubjectInfo subjectEng = new SubjectInfo("Eng", 40);

        Student student = new Student("StudentName1", "Address1");

        student.addSubject(subjectMath);
        student.addSubject(subjectPhys);
        student.addSubject(subjectEng);

        student.passExam(subjectMath, 4);
        student.passExam(subjectPhys, 5);
        student.passExam(subjectEng, 3);

        double expected = 4;
        double actual = student.getAverageMark();
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void getAverageMark2() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);

        Student student = new Student("StudentName1", "Address1");

        student.addSubject(subjectMath);
        student.addSubject(subjectPhys);

        student.passExam(subjectMath, 4);
        student.passExam(subjectPhys, 5);

        double expected = 4.5;
        double actual = student.getAverageMark();
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void getAverageMark3() {
        SubjectInfo subjectMath = new SubjectInfo("Math", 60);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        SubjectInfo subjectEng = new SubjectInfo("Eng", 40);

        Student student = new Student("StudentName1", "Address1");

        student.addSubject(subjectMath);
        student.addSubject(subjectPhys);
        student.addSubject(subjectEng);

        student.passExam(subjectMath, 4);
        student.passExam(subjectPhys, 5);

        double expected = 4.5;
        double actual = student.getAverageMark();
        Assert.assertEquals(expected, actual, 0.0001);
    }
}