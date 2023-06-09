package ca_Alg;

/**
 * @author diegolemos
 *
 */
import java.util.Scanner;
import java.util.ArrayList;

public class CAPart2 {
	// Declare variables to create a new student.
	public static String name;
	public static String transport;
	public static int distance;
	public static float emission;

	// Method to apply the exception handling.
	public static void addStudent(ArrayList<CFP> cfp) throws IlligalModeOfTransportException, IlligalRangeOfDistance { 

		Scanner enter = new Scanner(System.in);// Declare Scanner object

		// Inside of the try I have the part where the program gets the information to add new student.

		System.out.println("Please enter the student name:");
		name = enter.nextLine();// Get new student name.

		do {// do while to loop over the right options of transportation.
			System.out.println("Please enter the student mode of transport: ");
			transport = enter.nextLine();
			try {
				// This method checks the mode of transportation and throws an argument message.
				setModeOfTransport();

			} catch (IlligalModeOfTransportException t) {// Catch and throw the error according to the exception
															// customized.
				System.out.println(t);
			}
		} while (validModeOfTransport(transport) != true);

		do {// do while to loop over the right options of distance.
			System.out.println("Please enter the trevelled distance: ");
			distance = (int) enter.nextFloat();// In this case I choose to get nextFloat to accept numbers under 1 an
												// cast as a integer as the variable was before.
			try {
				// This method checks the distances and throws an argument message in case of
				// wrong entry.
				checkDistanceValue();

			} catch (IlligalRangeOfDistance d) {// Catch and throw the error according to the exception customized.
				System.out.println(d);
			}
		} while (validDistance(distance) != true);
		System.out.println("Please enter the emission: ");
		emission = enter.nextFloat();

		// Data to add the new student to the list
		CFP newStudent = new CFP(cfp.size() + 1, name, transport, distance, emission);
		cfp.add(newStudent);

		System.out.println(cfp.get(cfp.size() - 1));// Print the new student on the list.

		enter.close();// Closing the scanner.

	}

	// Methods to validate the mode of transport.
	public static boolean validModeOfTransport(String input) {
		if (!input.equalsIgnoreCase("Bus") && !input.equalsIgnoreCase("Train") && !input.equalsIgnoreCase("Car")
				&& !input.equalsIgnoreCase("Motor Bike") && !input.equalsIgnoreCase("Bike")
				&& !input.equalsIgnoreCase("E-scooter") && !input.equalsIgnoreCase("Walk")) {
			return false;
		} else {
			return true;
		}
	}

	public static void setModeOfTransport() throws IlligalModeOfTransportException {
		if (validModeOfTransport(transport) == false) {
			throw new IlligalModeOfTransportException("Unsupported Mode of Transport. \n "
					+ "Please correct the transportation mode by choosing from (Bus, Train, Car, Motor Bike, Bike, E-scooter, Walk)\n"
					+ "Please try again \n");
		}

	}

	// Methods to validate the distance value.
	public static boolean validDistance(int distance) {
		if (distance < 1) {
			return false;
		} else if (distance > 500) {
			return false;
		}
		return true;

	}

	public static void checkDistanceValue() throws IlligalRangeOfDistance {
		if (validDistance(distance) == false && distance < 1) {
			throw new IlligalRangeOfDistance("Distance below trackable limit \n" + "Please try again \n");
		} else if (validDistance(distance) == false && distance > 500) {
			throw new IlligalRangeOfDistance("Invalid distance limit for Ireland \n " + "Please try again \n");
		}
	}

	public static int size(CFP[] cfp, int StudCode) {// Method to get the size of the arraylist.
		int size = 0;

		for (int i = 0; i < cfp.length; i++) {
			if (cfp[i].getStudentCode() == StudCode) {
			}
			size++;
		}

		return size;
	}

}// Class
