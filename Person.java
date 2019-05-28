public class Person {
    private final String name;
    private final int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(final String theName,final int theAge){
        this.name=theName;
        this.age=theAge;
    }

    public int ageDifference(final Person p){
        return age-p.age;
    }
    public String toString(){
        return String.format("%s-%d",name,age);
    }
}
