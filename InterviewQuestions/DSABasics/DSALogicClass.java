package InterviewQuestions.DSABasics;

import java.util.Scanner;

class DSALogicClass {

    public static void LeanerSearchProgram() {
        int input, search, arr[];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        input = sc.nextInt();
        arr = new int[input];
        System.out.println("Enter " + input + " integers");
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();

        }
        System.out.println("Enter value to find : ");
        search = sc.nextInt();
        for (int i = 0; i < input; i++) {
            if (arr[i] == search) {
                System.out.println(search + " Number is Present at location " + (i + 1) + ".");
                break;
            }
            if (i == input) {
                System.out.println(search + "is not present in array ");
            }
        }
    }

    public static void BubbleSortProgram() {
        int n, c, d, swap;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of integers to sort");
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("array "+arr.toString());
        System.out.println("Enter " + n + " integers");
        for (c = 0; c < n; c++)
            arr[c] = sc.nextInt();
        for (c = 0; c < (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (arr[d] > arr[d + 1]) {
                    swap = arr[d];
                    arr[d] = arr[d + 1];
                    arr[d + 1] = swap;
                }
            }
        }
        System.out.println("Sorted list of numbers : ");
        for (c = 0; c < n; c++) {
            System.out.println(arr[c]);
        }
    }
}
