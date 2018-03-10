import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class GroupByExamples {

    public static void main(String... args) {
        List<Person> persons = populatePersonsList();

        StopWatch stopWatch = startTimeWatching();
        groupPersonsByAge(persons);
        stopWatchAndPrintDuration(stopWatch);

        stopWatch = startTimeWatching();
        groupPersonsByAgeUsingParallelStreams(persons);
        stopWatchAndPrintDuration(stopWatch);
    }

    private static List<Person> populatePersonsList() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(20, "John"));
        persons.add(new Person(32, "Zied"));
        persons.add(new Person(54, "Jean"));
        persons.add(new Person(33, "Sonia"));
        persons.add(new Person(1, "Adam"));
        persons.add(new Person(32, "John"));
        persons.add(new Person(54, "Boris"));
        return persons;
    }

    private static void groupPersonsByAge(List<Person> persons) {
        Map<Integer, Long> personsOlderThan30 = persons.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors
                        .groupingBy(
                                Person::getAge,         // Key extractor
                                Collectors.counting()   // Downstream collector
                        ));
        personsOlderThan30.forEach((key, value) ->
                System.out.println(
                        String.format("There is(are) %s person(s) aged %s years.", value, key)));
    }

    private static void groupPersonsByAgeUsingParallelStreams(List<Person> persons) {
        Map<Integer, Long> personsOlderThan20 = persons.stream().parallel()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors
                        .groupingBy(
                                Person::getAge,         // Key extractor
                                Collectors.counting()   // Downstream collector
                        ));
        personsOlderThan20.forEach((key, value) ->
                System.out.println(
                        String.format("There is(are) %s person(s) aged %s years.", value, key)));
    }

    private static StopWatch startTimeWatching() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    private static void stopWatchAndPrintDuration(StopWatch stopWatch) {
        stopWatch.stop();
        System.out.println(String.format("Computation took %s ms.\n",
                stopWatch.getTime(TimeUnit.MILLISECONDS)));
    }
}
