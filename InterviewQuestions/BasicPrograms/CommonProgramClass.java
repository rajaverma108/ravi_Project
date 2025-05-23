package InterviewQuestions.BasicPrograms;

import java.math.BigInteger;
import java.util.*;

public class CommonProgramClass {
    static void CheckNumberIsArmStrongOrNot(int n) {
        int sum = 0, temp, remainder, digits = 0;
        temp = n;
        //count number of digits
        while (temp != 0) {
            temp = temp / 10;
            digits++;

        }
        temp = n;
        while (temp != 0) {
            remainder = temp % 10;
            sum = sum + power(remainder, digits);
            temp = temp / 10;
        }
        boolean result = (n == sum) ? true : false;
        System.out.println(result);
    }

    private static int power(int remainder, int digits) {
        int c, p = 1;
        for (c = 1; c <= digits; c++) {
            p = p * remainder;
        }
        return p;
    }

    static int findingFactorialUsingRecursion(Integer input) {
        if (input != 0 && input != null) {
            if (input == 1) {
                return 1;
            } else
                return input * findingFactorialUsingRecursion(input - 1);
        }
        return 0;
    }

    static void mirrorRightAngleTriangleWithOddNumbers(int input) {
        for (int i = 0; i <= input; i++) {
            for (int i1 = 0; i1 <= input - i; i1++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (i % 2 != 0 & j % 2 != 0)
                    System.out.print(" " + j);
            }
            System.out.println();
        }
    }

    public static void floydTriangle(int input) {
        int num = 1;
        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void findingFactorialForLargeNumber(int input) {
        BigInteger inc = new BigInteger("1");
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= input; i++) {
            fact = fact.multiply(inc);
            inc = inc.add(BigInteger.ONE);
        }
        System.out.println(input + "! = " + fact);
    }

    public static void generateRandomNumber() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            //random integer in [0,10]
            System.out.print(random.nextInt(10) + " ");
        }
    }

    public static void performingGarbageCollection() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Free Memory in JVM before Garbage Collection : " + runtime.freeMemory());
        runtime.gc();
        System.out.println("Free Memory in JVM after Garbage Collection : " + runtime.freeMemory());
    }

    public static void frequancyOfNumbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 2, 4, 5);
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer a : integers
        ) {
            if (map.containsKey(a)) {
                map.put(a, true);
            } else {
                map.put(a, false);
            }
        }
        System.out.println(map);
    }

    public static void printingValueWithoutUsingPrintln() {
        if (System.out.printf("printing Value Without Using Println") == null) ;
    }

    public static void printingValueWithoutUsingAnyLoop(int i) {
        if (i <= 10) {
            System.out.println(i);
            i++;
            printingValueWithoutUsingAnyLoop(i);
        }
    }

    public static void checkwhetherNumberISPrimeOrNOt(int i) {
        int temp = 0;
        if (i <= 1 || i == 0) {
            System.out.println("not a prime number");
        }
        for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0) {
                System.out.println("not a prime Number");
                temp = 1;
                break;
            }
        }
        if (temp == 0) {
            System.out.println("is a prime number");
        }

    }

    public static void frequancyOfletters() {
        String str = "Google";
        char[] arr = str.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        System.out.println(map);

    }

    public static void swapingNumbersWithoutUsing3rdVeriable() {
        int x = 4;
        int y = 5;
        x=x+y;
        y=x-y;
        x=x-y;
        System.out.println("value of x = "+x);
        System.out.println("value of y = "+y);
    }    public static void swapingNumbersWithoutUsing3rdVeriableByBitWiseOperator() {
        int x = 4;
        int y = 5;
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println("value of x is changed = "+x);
        System.out.println("value of y is changed = "+y);
    }
}


