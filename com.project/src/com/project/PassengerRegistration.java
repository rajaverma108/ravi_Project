package com.project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PassengerRegistration {

	private static String heading[] = { "Passenger ID", "Passenger Name", "Email", "Address", "Contact Number" };

	public static void main(String[] args) throws IOException {

		Scanner obj = new Scanner(System.in);
		System.out.println("How Many passengers you would like to add:");
		int n = obj.nextInt();
		Passenger[] passenger = new Passenger[n];

		addPassenger(obj, n, passenger);
		try {
			writeToXL(passenger);
		} catch (Exception e) {
			System.out.println("Passenger Report Generation failed");
		}

	}

	private static void writeToXL(Passenger[] passenger) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");

		// Logic to make heading i.e Row 1

		XSSFRow headingrow = sheet.createRow(0);
		for (int i = 0; i < heading.length; i++) {
			XSSFCell cell = headingrow.createCell(i);
			cell.setCellValue(heading[i]);
		}

		List<Passenger> pp = Arrays.asList(passenger);
		int rowcount = 1;
		for (Passenger passenger2 : pp) {
			XSSFRow row = sheet.createRow(rowcount);
			insertToXL(passenger2, row); // inserting data into Sheet
			rowcount++;
		}

		FileOutputStream output = new FileOutputStream(new File(
				"C:\\Users\\rajav\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\com.project\\src\\tcs\\passenger\\report\\PassengerReport.xls"));
		workbook.write(output);
		output.close();
		workbook.close();
		System.out.println("Passenger report is generated!!!!!!");
	}

	private static void insertToXL(Passenger passenger2, XSSFRow row) {
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(passenger2.getPassengerID());

		cell = row.createCell(1);
		cell.setCellValue(passenger2.getPassengerName());

		cell = row.createCell(2);
		cell.setCellValue(passenger2.getEmail());

		cell = row.createCell(3);
		cell.setCellValue(passenger2.getAddress());

		cell = row.createCell(4);
		cell.setCellValue(passenger2.getContactNumber());
	}

	private static void addPassenger(Scanner obj, int n, Passenger[] passenger) {

		for (int i = 0; i < n; i++) {
			System.out.print("Enter Passanger Id:-");
			String PassengerID = obj.next();
			System.out.print("Enter Passanger Name:-");
			String PassengerName = obj.next();
			obj.next();
			System.out.print("Enter Passanger Email:-");
			String Email = obj.next();
			System.out.print("Enter Passanger Password:-");
			String Password = obj.next();
			System.out.print("Enter Passanger Address:-");
			String Address = obj.next();
			System.out.print("Enter Passanger Contact Number:-");
			String ContactNumber = obj.next();

			List<String> errormassage = validateInputParameter(PassengerID, PassengerName, Email, Password, Address,
					ContactNumber);
			if (errormassage.size() == 0) {
				passenger[i] = new Passenger(PassengerID, PassengerName, Email, Password, Address, ContactNumber);
			} else {
				for (int j = 0; j < errormassage.size(); j++) {
					System.err.println(errormassage.get(j));
				}
			}

		}

	}

	private static List<String> validateInputParameter(String passengerID, String passengerName, String email,
			String password, String address, String contactNumber) {
		List<String> temp = new ArrayList<>();
		if ((passengerID.length() <= 1 || passengerID.length() > 7 || passengerID == null)) {
			temp.add("*Passenger Id is invalid");
		}

		if (contactNumber(contactNumber) || contactNumber.length() != 10) {
			temp.add("*ContactNumber is invalid");
		}
		if (passengerName.length() >= 50) {
			temp.add("*Name is too long");
		}
		if (address.length() >= 100) {
			temp.add("*Invalid address");
		}
		if (!passwordCheck(password)) {

			temp.add("*Invalid password");
		}
		return temp;
	}

	private static boolean contactNumber(String number) {
		String regex = "^(?=.*[0-9])";
		Pattern p = Pattern.compile(regex);
		if (number == null) {
			return false;
		}
		Matcher m = p.matcher(number);
		return m.matches();
	}

	private static boolean passwordCheck(String password) {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,30}$";

		Pattern p = Pattern.compile(regex);

		if (password == null) {
			return false;
		}
		Matcher m = p.matcher(password);
		return m.matches();
	}

}
