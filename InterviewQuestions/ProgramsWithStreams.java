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
//          fibonacciSearies();
//        stringReversal();
//        comparingTwoArraysOfString();
//        separateOddAndEvenNumbers();
//        sumofAlldigitOfANumber();
//        filterOutTheNarcissisticNUmbers(); // {Ex- 153=( 1*1*1)+(5*5*5)+(3*3*3) again give original number}
//        frequancyOfletters();
//        frequancyOfNumbers();
//        sortingListInReverseOrder();
//        printMultipleof_5();
//        margingTwoUnsortedArrayintoOne();
//        findingMaxandMinFromList();
        findingSecondMaxandMinFromList();
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

    private static void filterOutTheNarcissisticNUmbers() {
        List<String> listOfIntegers = new ArrayList<>(); // for input
//        List<Integer> integerList = IntStream.rangeClosed(301, 400).boxed().collect(Collectors.toList());
        List<String> strings = Arrays.asList("301", "302", "303", "304", "305", "306", "307", "308", "309", "310"
                , "311", "312", "313", "314", "315", "316", "317", "318", "319", "320"
                , "321", "322", "323", "324", "325", "326", "327", "328", "329", "330"
                , "331", "332", "333", "334", "335", "336", "337", "338", "339", "340"
                , "341", "342", "343", "344", "345", "346", "347", "348", "349", "350"
                , "351", "352", "353", "354", "355", "356", "357", "358", "359", "360"
                , "361", "362", "363", "364", "365", "366", "367", "368", "369", "370"
                , "371", "372", "373", "374", "375", "376", "377", "378", "379", "380"
                , "381", "382", "383", "384", "385", "386", "387", "388", "389", "390"
                , "391", "392", "393", "394", "395", "396", "397", "398", "399", "400");
        List<String> collect = strings.stream().filter(s -> {
            if (s != null) {
                Stream.of(String.valueOf(s).split("")).collect(Collectors.summingInt(Integer::parseInt));
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        System.out.println(collect);

    }


    private static void comparingTwoArraysOfString() {
        String[] a1 = {"one", "two", "three"};
        String[] a2 = {"three", "one", "two",};
        boolean result = Arrays.stream(a1).unordered().allMatch(s -> Arrays.stream(a2).anyMatch(s::equals));
        System.out.println(result);
    }

    private static void frequancyOfNumbers() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 1, 3, 4);
        Map<Integer, Long> collect =
                integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequancyOfNumbers : " + collect);
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

    private static void findingSecondMaxandMinFromList() {
        List<Integer> integers = Arrays.asList(2, 2, 3, 4, 5);

        Integer maxinteger = integers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst().get();
        Integer mininteger = integers.stream().distinct().sorted().skip(1).limit(1).findFirst().get();
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

