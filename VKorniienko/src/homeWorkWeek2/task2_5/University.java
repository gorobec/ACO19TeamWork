package homeWorkWeek2.task2_5;

/**
 * Created by volodymyrkorniienko on 12.04.17.
 */
public class University {

    private String name;
    private Group[] groups;

    public University(String name, int countOfGroups) {
        this.name = name;
        this.groups = new Group[countOfGroups];
    }

    public boolean addGroupToUniversity(Group group){
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == null || groups[i].getGroupNumber().equals(group.getGroupNumber())) {
                    groups[i] = group;
                    return true;
            }
        }
        return false;
    }

    public boolean showAllInformation() {
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == null) return false;
            System.out.println(groups[i].getGroupNumber());
        }
        return true;
    }
}
