package src.src.main;

import src.src.main.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;
import java.util.Comparator;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class UsingComparator {
    public static void main(String[] args) throws IOException {
        // create a person list
        final List<Person> personList= Arrays.asList(new Person("John",20),new Person("Sarah",21)
                ,new Person("Jane",21),new Person("Greg",41));

     // sort persons based on their ages using lambda expression
   List<src.src.main.Person> ascendingAgeWithLambdaExpression=personList.stream()
            .sorted((p1,p2) -> p1.ageDifference(p2))
            .collect(toList());
   // sort persons in descending order using lambda expression
        List<src.src.main.Person> descendingAgeWithLambdaExpr=personList.stream()
                                                           .sorted((p1,p2)->p2.ageDifference(p1))
                                                           .collect(toList());
        printPeople("Sorted Persons by their ages in descending order",descendingAgeWithLambdaExpr);

    // sort persons in ascending order by their ages using method reference
        List<src.src.main.Person> ascendingAgeWihMethodReference=personList.stream()
                                            .sorted(src.src.main.Person::ageDifference)
                                            .collect(toList());

     // print sorted list of people
     printPeople("Sorted in ascending order by age using lambda expression:", ascendingAgeWithLambdaExpression);
     printPeople("Sorted in ascending order by age using method reference:", ascendingAgeWihMethodReference);

   // Using reversed() method to sort list in ascending and descending order
        Comparator<Person> compareAscending=(p1,p2)->p1.ageDifference(p2);
        Comparator<Person> compareDescending=compareAscending.reversed();

        //print in ascending order
        printPeople("Sort in ascending order:",personList.stream().sorted(compareAscending).collect(toList()));

        //print in descending order
        printPeople("Sort in descending order:",personList.stream().sorted(compareDescending).collect(toList()));

        //use of comparing method to sort based on age and name
        final Function<Person,String> byName = person -> person.getName();
        printPeople("Sort by name using comparing method:", personList.stream().sorted(comparing(byName)).collect(toList()));

        //group people by their age
        Map<Integer,List<Person>> peopleByAge= personList.stream()
                                                         .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Group By Age:" +peopleByAge);

        //list all the files in current directory
       // Files.list(Paths.get(".")).forEach(System.out::println);

        // list all the sub-directories
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

    }

    // method to print persons
    private static void printPeople(String message,final List<Person> people){
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
