package week1.classwork;


import week1.classwork.task.candidateTask.model.Candidate;
import week1.classwork.task.candidateTask.model.CandidateContainer;

/**
 * Created by SmooZzzie on 02.04.2017.
 */
public class RunTests {

    public static void main(String[] args) {


        CandidateContainer testContainerOfCandidates = new CandidateContainer();

        testAddMethod(testContainerOfCandidates);

        testFilterByMethod(testContainerOfCandidates);

        testDeleteMethod(testContainerOfCandidates);

        System.out.println(testShowAllMethod(testContainerOfCandidates));


    }

    private static void testFilterByMethod(CandidateContainer testContainerOfCandidates) {

        boolean resultOfTestFilterByName = testingFilterByName(testContainerOfCandidates);


        boolean resultOfTestFilterByYear = testingFilterByYear(testContainerOfCandidates);
                testContainerOfCandidates.filterByYear(2002);


        System.out.println(String.format("***Result of testing FilterBy Methods***\n" +
                "Filter by name: %b\nFilter by year: %b",resultOfTestFilterByName, resultOfTestFilterByYear));

    }



    private static boolean testingFilterByName(CandidateContainer testContainerOfCandidates) {

        String expectedResult = "Filtered by the name: Vova\n"
                + testContainerOfCandidates.getContainer()[2].showInfo() + testContainerOfCandidates.getContainer()[5].showInfo();
        String actualResult =  testContainerOfCandidates.filterByName("Vova");

        return (expectedResult.equals(actualResult));
    }

    private static boolean testingFilterByYear(CandidateContainer testContainerOfCandidates) {

        String expectedResult = "Filtered by the year: 2002\n"
                + testContainerOfCandidates.getContainer()[1].showInfo() + testContainerOfCandidates.getContainer()[5].showInfo();
        String actualResult = testContainerOfCandidates.filterByYear(2002);

        return (expectedResult.equals(actualResult));
    }

    private static void testDeleteMethod(CandidateContainer testContainerOfCandidates) {

        boolean deletingByYear = testContainerOfCandidates.deleteByYear(2002);
        boolean deletingByPhone = testContainerOfCandidates.deleteByPhone("+380672839876");
        boolean deletingByName = testContainerOfCandidates.deleteByName("Vova");

        System.out.println(String.format("***Result of testing Deleting Methods***\nDeleting by year: %b\n" +
                "Deleting by phone: %b\nDeleting by name: %b",deletingByYear,deletingByPhone,deletingByName));
    }

    private static String testShowAllMethod(CandidateContainer testContainerOfCandidates) {

        String expectedResultString = "name: Andriy\t| second name: Tyriy\t| phone: +380232562229\t| address: kiev, qweqwe str., 55\t| birth year: 1999\t|\n" +
                "name: Vadim\t| second name: Myrashko\t| phone: +380232562220\t| address: kiev, qweqwe str., 70\t| birth year: 1970\t|\n";

        return (expectedResultString.equals(testContainerOfCandidates.showAll())) ? "\n***Result of testing ShowAll Method***\n true\n"
                : "***Result of testing ShowAll Method***\n false\n";
    }

    public static void testAddMethod(CandidateContainer testContainerOfCandidates) {


        Candidate firstTestCandidate =
                new Candidate("Artem", "Shchepets", "+380672839876", "kiev, qweqwe str., 22", 1998, 1);
        Candidate secondTestCandidate =
                new Candidate("Ivan", "Dryghalo", "+380672429876", "kiev, qweqwe str., 54", 2002, 2);
        Candidate thirdTestCandidate =
                new Candidate(
                        "Vova", "Novak", "+380232562222", "kiev, qweqwe str., 21", 1977, 3);
        Candidate fourthTestCandidate =
                new Candidate(
                        "Andriy", "Tyriy", "+380232562229", "kiev, qweqwe str., 55", 1999, 4);
        Candidate fifthTestCandidate =
                new Candidate("Vadim", "Myrashko", "+380232562220", "kiev, qweqwe str., 70", 1970, 5);
        Candidate sixthTestCandidate =
                new Candidate("Vova", "Dryghalo", "+380672429876", "kiev, qweqwe str., 54", 2002, 6);


        boolean firstAdd = testContainerOfCandidates.add(firstTestCandidate);
        boolean secondAdd = testContainerOfCandidates.add(secondTestCandidate);
        boolean thirdAdd = testContainerOfCandidates.add(thirdTestCandidate);
        boolean fourthAdd = testContainerOfCandidates.add(fourthTestCandidate);
        boolean fifthAdd = testContainerOfCandidates.add(fifthTestCandidate);
        boolean sixthAdd = testContainerOfCandidates.add(sixthTestCandidate);

        System.out.println("***Result of testing Add Method***\n" +
                "First addition: " + firstAdd + "\nSecond addition: " + secondAdd
                + "\nThird addition: " + thirdAdd + "\nFourth addition: " + fourthAdd + "\nFifth addition: " + fifthAdd +
                "\nSixth addition: " + sixthAdd + "\n");


    }


}