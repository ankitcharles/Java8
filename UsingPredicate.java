import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsingPredicate {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian","Nate","Neal","Ajay","Sarah","Scott");
        final List<String> editors = Arrays.asList("Brian","Jackie","John","Mike");
        final List<String> comrades = Arrays.asList("Kate","Ken","Nick","Paula","Zach");

        final Long friendsStartWithN=
                                        friends.stream()
                                                .filter(name -> name.startsWith("N"))
                                                .count();

        final long editorsStartWithN=
                editors.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();
        final long comradesStartWithN=
                comrades.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        System.out.println(editorsStartWithN +" " + comradesStartWithN + " " + friendsStartWithN);

        final Predicate<String> startsWithN1=name -> name.startsWith("N");
        final Predicate<String> startsWithB = name-> name.startsWith("B");

        final long countFriendsWithN = friends.stream()
                                               .filter(startsWithN1)
                                               .count();
        final long  countFriendsStartsWithB= friends.stream()
                                                    .filter(startsWithB).count();

        System.out.println(countFriendsWithN + " " + countFriendsStartsWithB);

        final List<String>startsWithN =
                                        friends.stream()
                                               .filter(name -> name.startsWith("N"))
                                                .collect(Collectors.toList());

        System.out.println(String.format("found %d names", startsWithN.size()));

        final Long countFrriendStartN = friends.stream()
                                   .filter(checkIfStartsWith("N"))
                                    .count();
        final Long countFriendsStartB= friends.stream()
                                               .filter(checkIfStartsWith("B"))
                                                .count();
        System.out.println("friends count with N:" + countFriendsWithN + " " +"count friends with B:" +countFriendsStartB);

        final Function<String,Predicate<String>> startsWithLetter=letter->name->name.startsWith(letter);

        final Long countFriendsWithN1=friends.stream()
                                             .filter(startsWithLetter.apply("N")).count();
        final Long countFrinedsWithB1=friends.stream()
                                             .filter(startsWithLetter.apply("B")).count();
        System.out.println(countFriendsWithN1+ " " + countFrinedsWithB1);


        pickName(friends,"N");
        pickName(friends,"Z");

        // use of mapToInt and sum method
        System.out.println("Total number of characters in the names:" + friends.stream().mapToInt(String::length).sum());
        // String class's join method to print the friends name separated by comma.
        System.out.println(String.join(",",friends));

        /*Above operation could also be achieved using the collect(),which is another format of reduce method and can help us to collect
        values in the target. collect() method does the reduction but delegates actual implementation to a Collector.*/

        System.out.println(friends.stream()
                                   .map(String::toUpperCase)
                                   .collect(Collectors.joining(",")));

    }
    // options in example
    private static void pickName(final List<String> names, final String startingLetter){
        final Optional<String> foundName=names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findAny();
        System.out.println(String.format("A name starting with %s %s", startingLetter,foundName.orElse("No name found")));

    }
    // lexical scoping and closure example
    private static Predicate<String> checkIfStartsWith(final String letter){
        return name -> name.startsWith(letter);
    }


}
