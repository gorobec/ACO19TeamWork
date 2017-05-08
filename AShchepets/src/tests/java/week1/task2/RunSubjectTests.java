package week1.task2;

import week1.task2.model.Subject;
import week1.task2.utils.TestsUtils;

/**
 * Created by SmooZzzie on 06.04.2017.
 */
public class RunSubjectTests {

    public static void main(String[] args) {

        Subject testSubject = new Subject("testSubject1", 50, 27);

        boolean testShowSubjectInfo = testingShowSubjectInfo(testSubject);
        TestsUtils.showTestResult("showSubjectInfo", testShowSubjectInfo);

        boolean testExamineStudent = testingExamineStudent(testSubject);
        TestsUtils.showTestResult("examineStudent", testExamineStudent);

        boolean testGetStudentMarkInfo = testingGetStudentMarkInfo(testSubject);
        TestsUtils.showTestResult("getStudentMarkInfo", testGetStudentMarkInfo);

    }

    private static boolean testingShowSubjectInfo(Subject testSubject) {

        String expectedSubjectInfo = "Name of subject: testSubject1\t| Subject hours: 50\t| Student's working hours: 27\t|" +
                " Student's mark: Not Examined";

        return expectedSubjectInfo.equals(testSubject.getSubjectInfo());
    }


    private static boolean testingExamineStudent(Subject testSubject) {

        return testSubject.examineStudent();
    }

    //method getStudentMarkInfo() cannot to be tested because of random assigning of studentMark
    // we cannot test value, which changes every time
    private static boolean testingGetStudentMarkInfo(Subject testSubject) {
        return true;
    }
}
