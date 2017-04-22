package week1.home2;

import java.util.Comparator;

public class Run {
    public static void main(String[] args) {
        SubjectInfo subjectMath = new SubjectInfo("Math", 30);
        SubjectInfo subjectPhys = new SubjectInfo("Phys", 50);
        SubjectInfo subjectEng = new SubjectInfo("Eng", 40);

        SubjectInfo.printSubjectInformation();

        Student student = new Student("StudentName1", "Address1");

        student.addSubject(subjectEng);
        student.addSubject(subjectMath);
        student.addSubject(subjectPhys);
        System.out.println(student.addSubject(subjectMath));
        student.study(subjectMath, 8);
        student.passExam(subjectMath, 4);
        student.passExam(subjectPhys, 5);
        student.passExam(subjectEng, 3);
        System.out.println(student.getMark(subjectMath));
        System.out.println(student.getMark(subjectEng));

        System.out.println(student.getAllSubjects());

        student.sort();
        System.out.println(student.getAllSubjects());

        Comparator comparator = new TotalHoursComparator();
        student.sort(comparator);
        System.out.println(student.getAllSubjects());

        System.out.println(student.getAverageMark());

        System.out.println(student.removeLastSubject());

        System.out.println(student.getAverageMark());
    }
}