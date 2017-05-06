package design_patterns.adapter;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class PoliceDepartment {

    private List<Policeman> policemen = new LinkedList<>();

    public boolean addPoliceman(Policeman policeman){
        return policemen.add(policeman);
    }

    public void startWorkingDay(){
        for (Policeman policeman : policemen) {
            policeman.makeLaw();
        }
    }

}
