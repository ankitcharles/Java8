import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;
public class UsingComparator {
    public static void main(String[] args) {
        // create a person list
        final List<Person> personList= Arrays.asList(new Person("John",20),new Person("Sarah",21)
                ,new Person("Jane",21),new Person("Greg",41));

     // sort persons based on their ages using lambda expression
   /*List<Person> ascendingAgeWithLambdaExpression=personList.stream()
            .sorted((p1,p2) -> p1.ageDifference(p2))
            .collect(Collectors.toList());
   // sort persons in descending order using lambda expression
        List<Person> descendingAgeWithLambdaExpr=personList.stream()
                                                           .sorted((p1,p2)->p2.ageDifference(p1))
                                                           .collect(Collectors.toList());
        printPeople("Sorted Persons by their ages in descending order",descendingAgeWithLambdaExpr);

    // sort persons in ascending order by their ages using method reference
        List<Person> ascendingAgeWihMethodReference=personList.stream()
                                            .sorted(Person::ageDifference)
                                            .collect(Collectors.toList());

     // print sorted list of people
     printPeople("Sorted in ascending order by age using lambda expression:", ascendingAgeWithLambdaExpression);
     printPeople("Sorted in ascending order by age using method reference:", ascendingAgeWihMethodReference); */

   // Using reversed() method to sort list in ascending and descending order
        Comparator<Person> compareAscending=(p1,p2)->p1.ageDifference(p2);
        Comparator<Person> compareDescending=compareAscending.reversed();


    }

    // method to print persons
    private static void printPeople(String message,final List<Person> people){
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
