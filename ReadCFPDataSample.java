package ca_Alg;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCFPDataSample {

	public static void main(String[] args) throws Exception {
		// Getting hold of the CFP.csv data
		String dir = System.getProperty("user.home");
		System.out.println(dir);
		Scanner sc = new Scanner(new File("/Users/diegolemos/CFP_DATA.csv"));

		// Creating a ArrayList with the CFP data
		ArrayList<CFP> StudentList = new ArrayList<CFP>();

		// Printing the header in CFP.csv file
		System.out.println(sc.nextLine());

		int i = 0;
		String st = "";
		while (sc.hasNextLine()) {

			st = sc.nextLine();
			st = st.replace("\"", "");
			String[] data = st.split(",");
			System.out.println(st);
			if (data[3] == "") {
				data[3] = "0";
			}
			StudentList.add(new CFP(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]),
					Float.parseFloat(data[4])));

			i++;
		}

		sc.close();// Closing the first scanner.

		// Creating a ArrayList with the CFP data
		CFP[] cfp = new CFP[10000];
		for (int x = 0; x < cfp.length; x++) {
			cfp[x] = StudentList.get(x);
		}

		Scanner enter = new Scanner(System.in);

//        ****************** CA PART 1 ****************************
		System.out.println("****************** CA PART 1 ****************************");

// *************** Question 3: Method for implementation of Binary Search *****************************
		System.out.println("*************** Question 3: Method for implementation of Binary Search ************************");
		boolean binary = false;
		String tryAgain = "";
		do {
		System.out.println("Please enter the student's code you are looking for.");
		int code = enter.nextInt();
		
			if (code > 0 && code <= cfp.length) {

				System.out.println(CAPart1.binarySearch(cfp, code));
				binary = true;
			} else {
				System.out.println("Sorry,this student is not in our database \n");
				System.out.println("Would you like to try again? yes or no");
				tryAgain = enter.next().toLowerCase();
				if(tryAgain.equals("yes")){
					binary = false;
				}else {
					binary = true;
				}
				
			}
		} while (binary != true);
		System.out.println();// This is just to jump one line.

// *************** Question 1: Methods for implementation of Merge Sort *******************************

		System.out.println(
				"*************** Question 1: Methods for implementation of Merge Sort *******************************");

		System.out.println("Data before Merge Sort: \n");
		CAPart1.printStudNameArray(cfp, 5);

		CAPart1.studNameMergeSort(cfp, 5);

		System.out.println("Data after Merge Sort: \n");

		CAPart1.printStudNameArray(cfp, 5);

//************** Question 2: Method for implementation of Tracking time ********************************
		System.out.println(
				"************** Question 2: Method for implementation of Tracking time **********************");
		System.out.println(CAPart1.trakingTime(cfp, 10, 5));
		System.out.println(CAPart1.trakingTime(cfp, 100, 5));
		System.out.println(CAPart1.trakingTime(cfp, 1000, 5));
		System.out.println(CAPart1.trakingTime(cfp, 10000, 5));

//         ****************** CA PART 2 ****************************

// ********************Question 1 and 2 **************************************
		// Testing the method addStudent
		System.out.println(
		"*************** Question 1 and 2: Methods for implementation of addStudent with Exceptional Handling *******************************");
		
		CAPart2.addStudent(StudentList);
		
		enter.close();// Closing the second scanner.

	}// Main

}// Class
