package src.DefiningExercise.Google;

public class Children {

    private String childName;
    private String childBirthDay;


    public String getChildName() {
        return childName;
    }

    public String getChildBirthDay() {
        return childBirthDay;
    }



    public Children( String childName, String childBirthDay) {
        this.childName = childName;
        this.childBirthDay = childBirthDay;
    }

    @Override
    public String toString(){

        return childName +" " + childBirthDay;
    }
}
