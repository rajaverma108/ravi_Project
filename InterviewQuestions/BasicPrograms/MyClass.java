package InterviewQuestions.BasicPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class MyClass {


    public static int countOrdersDeliveredInAWeek(PackersAndMovers[] arr, String str) {
        long count = Arrays.stream(arr).filter(packersAndMovers -> {
                    Integer orderDate = Integer.parseInt(packersAndMovers.getOrderDate().substring(0, 2));
                    Integer deliverdDate = Integer.parseInt(packersAndMovers.getDeliveryDate().substring(0, 2));
                    if (deliverdDate - orderDate <= 7 && packersAndMovers.getFromCity().equalsIgnoreCase(str)) {
                        return true;
                    }
                    return false;
                }
        ).peek(t -> System.out.println("filter : " + t)).count();
        return (int) count;
                //Long.valueOf(count).intValue();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PackersAndMovers[] arr = new PackersAndMovers[n];
        for (int i = 0; i < n; i++) {
            System.out.println("invoiceNo");
            int invoiceNo = sc.nextInt();
            sc.nextLine();
            System.out.println("fromCity");// Consume newline
            String fromCity = sc.nextLine();
            System.out.println("toCity");
            String toCity = sc.nextLine();
            System.out.println("orderDate");
            String orderDate = sc.nextLine();
            System.out.println("deliveryDate");
            String deliveryDate = sc.nextLine();
            System.out.println("price");
            double price = sc.nextDouble();
            arr[i] = new PackersAndMovers(invoiceNo, fromCity, toCity, orderDate, deliveryDate, price);
        }
        sc.nextLine();
        System.out.println("cityToCheck");
        String cityToCheck = sc.nextLine();
//        PackersAndMovers[] arr = new PackersAndMovers[]{new PackersAndMovers(1001, "Indore", "Bhopal", "20-06-2023", "28-06-2023", 700),
//                new PackersAndMovers(1002, "Indore", "ujjain", "20-06-2023", "28-06-2023", 700)};

        getResult(arr, cityToCheck);
    }

    private static int getResult(PackersAndMovers[] arr, String cityToCheck) {
        int result = countOrdersDeliveredInAWeek(arr, cityToCheck);
        if (result > 0) {
            System.out.println(result);
        } else {
            System.out.println("No PackersAndMovers delivered within a week from the given city.");
        }
        return result;
    }
}
