package week1.task2;

import week1.task2.model.Student;
import week1.task2.model.Subject;
import week1.task2.utils.TestsUtils;


/**
 * Created by SmooZzzie on 06.04.2017.
 */
public class RunStudentTests {

    public static void main(String[] args) {

        Student testStudent1 = new Student("testName1", "testAddress1", false, 5);

        boolean resultTestToStudy = testingToStudy(testStudent1);
        TestsUtils.showTestResult("toStudy", resultTestToStudy);

        boolean resultTestAddSubject = testingAddSubject(testStudent1);
        TestsUtils.showTestResult("addSubject", resultTestAddSubject);

        boolean resultOTestDeleteLastSubj = testingDeleteLastSubject(testStudent1);
        TestsUtils.showTestResult("deleteLastSubject",resultOTestDeleteLastSubj);

        testingShowAllSubjectsInfo(testStudent1);

        boolean resultOTestGetAverageMark = testingGetAverageMark(testStudent1);
        TestsUtils.showTestResult("getAverageMark",resultOTestGetAverageMark);

    }

    private static boolean testingGetAverageMark(Student testStudent1) {

        for (int i = 0; i < testStudent1.getLastElementOfSubjects(); i++) {
            testStudent1.getContainerOfSubjects()[i].examineStudent();
        }

        double expectedAverageMark = 0;
        for (int i = 0; i < testStudent1.getLastElementOfSubjects(); i++) {
            expectedAverageMark += testStudent1.getContainerOfSubjects()[i].getStudentSubjectMark();
        }
        expectedAverageMark /= testStudent1.getLastElementOfSubjects();

        double actualAverageMark = testStudent1.getAverageMark();

        return expectedAverageMark == actualAverageMark;
    }


    private static boolean testingToStudy(Student testStudent1) {

        boolean expectedValueOfIsStudy = true;
        testStudent1.toStudy();

        return expectedValueOfIsStudy == testStudent1.isStudying();
    }


    private static boolean testingAddSubject(Student testStudent1) {

        Subject testSubject1 = new Subject("testSubject1", 50, 14);

        return testStudent1.addSubject(testSubject1);
    }

    private static boolean testingDeleteLastSubject(Student testStudent1) {

        return testStudent1.deleteLastSubject();
    }


    private static void testingShowAllSubjectsInfo(Student testStudent1) {
        Subject testSubject1 = new Subject("testSubject1", 50, 14);
        Subject testSubject2 = new Subject("testSubject2", 50, 10);
        Subject testSubject3 = new Subject("testSubject3", 50, 9);

        testStudent1.addSubject(testSubject1);
        testStudent1.addSubject(testSubject2);
        testStudent1.addSubject(testSubject3);

        System.out.println("***Result of testing showAllSubjectsInfo() Method***\n");
        testStudent1.showAllSubjectsInfo();
    }

}
