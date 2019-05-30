package src.src.main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceEx {
    public static void main(String[] args) {


        List<Car> cars = Arrays.asList(new Car("Skoda", 1357), new Car("Toyota", 3456), new Car("Jaguar", 3478));

        Optional<Car> car = cars.stream()
                .reduce((c1, c2) -> c1.getPrice() > c2.getPrice() ? c1 : c2);

        car.ifPresent(System.out::println);
    }

}
