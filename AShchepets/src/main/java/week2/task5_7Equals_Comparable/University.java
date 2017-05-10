package week2.task5_7Equals_Comparable;

import java.util.Arrays;

/**
 * Created by SmooZzzie on 24.04.2017.
 */
public class University implements Cloneable{

    private static final int DEFAULT_GROUPS_QUANTITY = 10;

    private String universityName;
    private Group[] listOfGroups;
    private int actualGroupQuantity;

    public University() {
        this.universityName = "testUniversityName";
        this.listOfGroups = new Group[DEFAULT_GROUPS_QUANTITY];
    }

    public University(String universityName) {
        this.universityName = universityName;
        this.listOfGroups = new Group[DEFAULT_GROUPS_QUANTITY];
    }

    public University(String universityName, int quantityOfGroups) {
        this.universityName = universityName;
        this.listOfGroups = new Group[quantityOfGroups];
    }

    public Group[] getListOfGroups() {
        return listOfGroups;
    }

    public int getActualGroupQuantity() {
        return actualGroupQuantity;
    }

    public void setActualGroupQuantity(int actualGroupQuantity) {
        this.actualGroupQuantity = actualGroupQuantity;
    }

    public boolean addGroup(Group newGroup) {

        if (newGroup == null || contains(newGroup) || actualGroupQuantity >= listOfGroups.length) {
            return false;
        }


        listOfGroups[actualGroupQuantity++] = newGroup;
        return true;
    }

    private boolean contains(Group newGroup) {

        for (int i = 0; i < actualGroupQuantity; i++) {
            if (listOfGroups[i].equals(newGroup)) {
                return true;
            }
        }

        return false;
    }

    //added for week4 CloneTask
    @Override
    protected University clone() throws CloneNotSupportedException {
        University clone = (University) super.clone();

        clone.listOfGroups = cloneListOfGroups(listOfGroups);
        return clone;
    }

    private Group[] cloneListOfGroups(Group[] listOfGroups) throws CloneNotSupportedException {

        Group[] clone = this.listOfGroups.clone();

        for (int i = 0; i < listOfGroups.length; i++) {
            clone[i] = clone[i].cloneGroup(clone[i]);
        }

        return clone;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", listOfGroups=" + Arrays.toString(listOfGroups) +
                '}';
    }
}
