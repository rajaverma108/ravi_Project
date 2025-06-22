package InterviewQuestions.DSABasics;

public class ArraySorting {
    public static void main(String[] args) {
        sortingArrayIntoNaturalOrder();
        sortingArrayIntoReverseOrder();
    }

    private static void sortingArrayIntoReverseOrder() {
        int[] arr = new int[]{3, 4, 5, 2, 6, 8, 7, 1};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print(arr[i]+ " ");
        }
    }

    private static void sortingArrayIntoNaturalOrder() {
        int[] arr = new int[]{3, 4, 5, 2, 6, 8, 7, 1};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
