package week1.classwork.task.candidateTask.model;


import week1.classwork.task.candidateTask.utils.CandidateUtils;

/**
 * Created by SmooZzzie on 02.04.2017.
 */
public class CandidateContainer {

    private final int DEFAULT_CONTAINER_SIZE = 10;

    private Candidate[] container = new Candidate[DEFAULT_CONTAINER_SIZE];


    private int lastIndexOfContainer = 0;
    private int startPointer = 0;


    public Candidate[] getContainer() {
        return container;
    }

    public boolean add(Candidate newCandidate) {

        if (newCandidate == null) {
            System.out.println("Please fill in all fields!");
            return false;
        } else {
            if (contains(newCandidate)) {
                System.out.println("This candidate already existing in our database!");
                return false;
            }
        }

        if (lastIndexOfContainer == container.length) {
            container = CandidateUtils.externCandidateContainer(container);
            recordingIntoCell(newCandidate);
            return true;
        } else {
            recordingIntoCell(newCandidate);
            return true;
        }


    }

    public int searchByName(String searchingName) {

        int indexOfFoundElement = 0;

        for (int i = startPointer; i < lastIndexOfContainer; i++) {
            startPointer = i + 1;
            if ((container[i].getName()).equals(searchingName)) {
                indexOfFoundElement = i;
                return indexOfFoundElement;
            }
        }

        return -1;
    }


    public int searchBySecondName(String searchingSecondName) {

        int indexOfFoundElement = 0;

        for (int i = 0; i < lastIndexOfContainer; i++) {
            if ((container[i].getSecondName()).equals(searchingSecondName)) {
                indexOfFoundElement = i;
                return indexOfFoundElement;
            }
        }

        return -1;
    }

    public int searchByPhone(String searchingPhone) {

        int indexOfFoundElement = 0;

        for (int i = startPointer; i < lastIndexOfContainer; i++) {
            startPointer = i + 1;
            if ((container[i].getPhone()).equals(searchingPhone)) {
                indexOfFoundElement = i;
                return indexOfFoundElement;
            }
        }

        return -1;
    }


    public int searchByAddress(String searchingAddress) {

        int indexOfFoundElement = 0;

        for (int i = 0; i < lastIndexOfContainer; i++) {
            if ((container[i].getAddress()).equals(searchingAddress)) {
                indexOfFoundElement = i;
                return indexOfFoundElement;
            }
        }

        return -1;
    }

    public int searchByBirthYear(int searchingYear) {

        int indexOfFoundElement = 0;

        for (int i = startPointer; i < container.length; i++) {
            startPointer = i + 1;
            if (container[i].getBirthYear() == searchingYear) {
                indexOfFoundElement = i;
                return indexOfFoundElement;
            }
        }

        return -1;
    }


    public boolean deleteByName(String deletingName) {


        for (int i = 0; startPointer < lastIndexOfContainer; i++) {

            int indexOfDeletingElement = searchByName(deletingName);

            if (processOfDeleting(indexOfDeletingElement) == false) {
                return false;
            }
        }

        startPointer = 0;
        return true;
    }

    public boolean deleteByYear(int deletingYear) {


        for (int i = 0; startPointer < lastIndexOfContainer; i++) {

            int indexOfDeletingElement = searchByBirthYear(deletingYear);

            if (processOfDeleting(indexOfDeletingElement) == false) {
                return false;
            }

        }

        startPointer = 0;
        return true;
    }

    private boolean processOfDeleting(int indexOfDeletingElement) {

        if (indexOfDeletingElement == -1 && startPointer >= lastIndexOfContainer - 1) {
            return true;
        } else {
            if (indexOfDeletingElement == -1 && startPointer == 0) {
                return false;
            }
            container[indexOfDeletingElement] = null;
            offsetAfterDeleting(indexOfDeletingElement);
            lastIndexOfContainer--;
        }
        return true;
    }

    public boolean deleteByPhone(String deletingPhone) {


        for (int i = 0; startPointer < lastIndexOfContainer; i++) {

            int indexOfDeletingElement = searchByPhone(deletingPhone);

            if (processOfDeleting(indexOfDeletingElement) == false) {
                return false;
            }
        }

        startPointer = 0;
        return true;
    }

    public String showAll() {

        String resultString = "";

        for (int i = 0; i < lastIndexOfContainer; i++) {
            resultString += container[i].showInfo();
        }
        return resultString;
    }

    public boolean contains(Candidate searchingCandidate) {

        int counterOfIndex = 0;
        while (container[counterOfIndex] != null) {
            if ((container[counterOfIndex].getName()).equals(searchingCandidate.getName())
                    && (container[counterOfIndex].getSecondName()).equals(searchingCandidate.getSecondName())) {
                return true;
            }
            counterOfIndex++;
        }

        return false;
    }

    public void recordingIntoCell(Candidate newCandidate) {
        container[lastIndexOfContainer] = newCandidate;
        lastIndexOfContainer++;
    }

    public void offsetAfterDeleting(int deletedIndex) {


        for (int i = deletedIndex; i < lastIndexOfContainer - 1; i++) {
            container[i] = container[i + 1];
            if (i == lastIndexOfContainer - 2) {
                container[i + 1] = null;
                startPointer--;
            }
        }

    }

    public String filterByName(String filterName) {

        String resultString = "Filtered by the name: " + filterName + "\n";


        for (int i = 0; startPointer < lastIndexOfContainer; i++) {
            resultString += container[searchByName(filterName)].showInfo();
        }

        startPointer = 0;

        return resultString;
    }


    public String filterByYear(int filterYear) {

        String resultString = "Filtered by the year: " + filterYear + "\n";


        for (int i = 0; startPointer < lastIndexOfContainer; i++) {
            resultString += container[searchByBirthYear(filterYear)].showInfo();
        }

        startPointer = 0;

        return resultString;

    }
}
