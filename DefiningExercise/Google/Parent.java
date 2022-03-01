package src.DefiningExercise.Google;

public class Parent {


    private String parentName;
    private String parentBirthDay;

    public Parent(String parentName, String parentBirthDay) {
        this.parentName = parentName;
        this.parentBirthDay = parentBirthDay;
    }

    @Override
    public String toString(){

        return parentName +" " + parentBirthDay;
    }
}
