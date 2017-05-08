package week1.classwork.task.candidateTask.utils;

import week1.classwork.task.candidateTask.model.Candidate;

/**
 * Created by SmooZzzie on 05.04.2017.
 */
public class CandidateUtils {

    public static Candidate[] externCandidateContainer (Candidate[] container) {

        Candidate[] externedContainer = new Candidate[container.length*2];

        for (int i = 0; i < container.length; i++) {
            externedContainer[i] = container[i];
        }

        return externedContainer;
    }

}
