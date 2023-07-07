package InterviewQuestions;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramsWithStreams {
    public static void main(String[] args) {
          fibonacciSearies();
//        stringReversal();
//        separateOddAndEvenNumvers();
//        sumofAlldigitOfANumber();
//        frequancyOfletters();
//        sortingListInReverseOrder();
//        printMultipleof_5();
//        margingTwoUnsortedArrayintoOne();
//        findingMaxandMinFromList();
//        ReverseAnIntegerArray();
//        palindromeWithStream();
//        lastElementOfAnArray();
//        ageOfPersonInYears();
//        frequancyOfEachElementInAnArray();
//        secondLargestNumberInAnArray();
//        commonElementsBWTwoArray();
//        findingDuplicateElementFromAnArray();
//        findingStringWhichStartWithNumber();
//        joinListOfStringsWithPrefixAndSuffixAndDelimiter();
//        anagram(); //If orginal word is made up by re-arrangement


    }

    private static void fibonacciSearies() {
        Stream.iterate(new int[]{0, 1}, value -> new int[]{value[1], value[0] + value[1]})
                .limit(10).map(t -> t[0]).forEach(result -> System.out.print(result + " "));
    }

    private static void findingDuplicateElementFromAnArray() {
        Set set = new HashSet();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 2);
        Set<Integer> collect = integers.stream().filter(integer -> !set.add(integer)).collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void findingStringWhichStartWithNumber() {
        List<String> list = Arrays.asList("1Test", "2Test", "Test");
        list.stream().filter(s -> Character.isDigit(s.charAt(0))).forEach(System.out::println);
    }

    private static void stringReversal() {
        String str = "Test";
        String collect = Arrays.stream(str.split(" ")).map(s -> new StringBuffer(s).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    private static void commonElementsBWTwoArray() {
        List<Integer> list = Arrays.asList(1, 2, 4, 7, 6);
        List<Integer> list1 = Arrays.asList(9, 2, 3, 8, 5);
        list.stream().filter(list1::contains).forEach(System.out::println);

    }

    private static void secondLargestNumberInAnArray() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 1);
        Integer integer = listOfIntegers.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println(integer);
    }

    private static void sumofAlldigitOfANumber() {
        String str = "1234";
        Integer collect = Stream.of(String.valueOf(str).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(collect);

    }

    private static void anagram() {
        String str1 = "Test";
        String str2 = "Tset";
        String collect1 = Stream.of(str1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String collect2 = Stream.of(str2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        boolean result = collect1.equals(collect2) ? true : false;
        System.out.println(result + ": Anagram");

    }

    private static void joinListOfStringsWithPrefixAndSuffixAndDelimiter() {
        List<String> list = Arrays.asList("Ravi", "kant");
        String collect = list.stream().collect(Collectors.joining("-", "Mr.", "verma"));
        System.out.println(collect);

    }

    private static void frequancyOfEachElementInAnArray() {

        List<Integer> integerList = Arrays.asList(1, 4, 3, 55, 3, 5, 2);
        Map<Integer, Long> collect = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    private static void ageOfPersonInYears() {
        LocalDate birthDate = LocalDate.of(1997, 8, 10);
        LocalDate toDay = LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(birthDate, toDay));
    }

    private static void lastElementOfAnArray() {
        List<String> stringList = Arrays.asList("raj", "ravi", "kant", "rajeev");
        String s = stringList.stream().skip(stringList.size() - 1).findFirst().get();
        System.out.println(s);
    }

    private static void palindromeWithStream() {
        String str = "MOM";
        boolean b = IntStream.rangeClosed(0, str.length() / 2)
                .noneMatch(value -> str.charAt(value) != str.charAt(str.length() - value - 1));
        System.out.println(b);
    }

    private static void ReverseAnIntegerArray() {
        int[] a = {1, 2, 3, 4, 5};
        int[] ints = IntStream.rangeClosed(1, a.length).map(operand -> a[a.length - operand]).toArray();
        for (Integer int1 : ints
        ) {
            System.out.println(int1);
        }
    }

    private static void findingMaxandMinFromList() {
        List<Integer> integers = Arrays.asList(2, 2, 3, 4, 5);
        Integer maxinteger = integers.stream().max(Comparator.naturalOrder()).get();
        Integer mininteger = integers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(maxinteger);
        System.out.println(mininteger);
        // Optional<Integer> collect = integers.stream().filter(Integer::max).collect(Collectors.toList());
        // System.out.println(collect.get());
    }

    private static void margingTwoUnsortedArrayintoOne() {
        int[] a = {1, 2, 3, 5, 4};
        int[] b = {7, 8, 9, 5, 3};
        int[] ints = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
        for (int int1 : ints
        ) {
            System.out.print(int1);
        }

    }

    private static void printMultipleof_5() {
        List<Integer> integers = Arrays.asList(1, 2, 12, 15, 5, 25, 50);
        List<Integer> collect = integers.stream().filter(integer -> integer % 5 == 0).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void sortingListInReverseOrder() {
        List<Character> characters = Arrays.asList('a', 'b', 'c', 'd', 'e');
        characters.stream().sorted(Comparator.reverseOrder()).forEach(integer -> System.out.println(integer));

    }

    private static void frequancyOfletters() {
        String str = "ravikant";
        Map<Character, Long> collect =
                str.chars().mapToObj(value -> (char) value)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    private static void separateOddAndEvenNumvers() {
        List<Integer> integers = Arrays.asList(1, 2, 33, 4, 11, 55, 6);
        Map<Boolean, List<Integer>> collect = integers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        System.out.println(collect);
    }
}

