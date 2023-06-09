package ca_Alg;

/**
 * @author diegolemos
 *
 */
public class CAPart1 {

	// CA Part 1
	// Question 3: Method for implementation of Binary Search:

	// I set the method as static so I don't need to instantiate this class inside
	// the main,
	// the return as CFP, and the parameters as a CFP array to get the CFP's data
	// and the student code that we are looking for.
	public static CFP binarySearch(CFP[] cfp, int StudCode) {

		boolean found = false; // This variable was declared so when the student code is found it became true
								// breaking the loop e displaying the matching student.
		int start = 0; // This variable points to the beginning of the array.
		int end = cfp.length - 1; // This variable points to the ending of the array.
		int midd = 1;// This variable points to the middle of the array, which the program uses to
						// compare with the entered student code.

		while (start <= end) {// Here is the parameters set to loop though the array, considering that always
								// will be less or equals to to the end.
			midd = (int) ((start + end) / 2); // Here we have the variable that always points to the middle of the
												// array, after it has been re-divided with a new start and end. And
												// that will be compared with the student code entered.
			if (cfp[midd].getStudentCode() == StudCode) {// Comparison between the student in the middle with the
															// student code entered.
				found = true;// If it is found, the variable found became true and break the loop and display
								// the student details on the return function.
				break;
			} else if (cfp[midd].getStudentCode() < StudCode) {
				start = midd + 1; // If it was not found on the first if statement, and the middle is less then
									// the input, the programmer gets a new begin on the array to loop though, that
									// will be the position after the middle.
			} else {
				end = midd - 1;// In this case the opposite happens, the end becomes the position before the
								// middle.
			}
		}
		if (found == true) {
			System.out.println("Here are the details of the student you are looking for: \n");

		}

		return cfp[midd];// Returns the students details found.
	}

	// =========================================================================================================

	// Question 1: Methods for implementation of Merge Sort:

	public static void studNameMergeSort(CFP[] studName, int length) {// The CFP array and the length to be sorted is
																		// set as parameters.

		int studNameLength = studName.length; // Variable to get the length of the array.

		if (studNameLength < 2) {// In case of this statement is true the program doesn't need to Merge Sort.
			return;
		}

		int middIndex = studNameLength / 2;/// Here is the variable that always points to the middle of the array, after
											/// it has been re-divided with a new start and new end.
		CFP[] leftHalfSide = new CFP[middIndex];// A new array to get the data of the left half of the array before.
		CFP[] rightHalfSide = new CFP[studNameLength - middIndex];/// A new array to get the data of the right half of
																	/// the array before. In this case I passed though
																	/// in the array
		// the studNameLength less middIndex because if the input array came in with a
		// odd number of elements the variable middIndex that is a integer probably wont
		// get hold of the exactly half of numbers,
		// so we need in the right all the remaining elements.

		for (int i = 0; i < middIndex; i++) {// Here the program loops through the arrays populating the left half new
												// array.
			leftHalfSide[i] = studName[i];
		}

		for (int i = middIndex; i < studNameLength; i++) {// Here the program loops through the arrays star ting on the
															// middle position to populating the right half new array.
			rightHalfSide[i - middIndex] = studName[i];
		}

		studNameMergeSort(leftHalfSide, 0);// It keeps doing the same process recursively.
		studNameMergeSort(rightHalfSide, 0);

		mergeStudents(studName, leftHalfSide, rightHalfSide);// So at the end we need reassemble the array sorted, for
																// this we use the method mergeStudents.
	}

	public static void mergeStudents(CFP[] studName, CFP[] leftHalfSide, CFP[] rightHalfSide) {// The parameters are
																								// basic the array that
																								// we already have
																								// before, so it can get
																								// back the data sorted.
		int leftSizeArray = leftHalfSide.length;// Variable to get the length of the array.
		int rightSizeArray = rightHalfSide.length;

		// Declare here tree iterator variables, one to go through the leftHalf array,
		// other to go through the rightHalf array and the last one to go though the
		// studName array.
		int i = 0;
		int x = 0;
		int z = 0;

		// Now the program loops though both arrays left and right, until there is no
		// more elements on those, then it compares the elements to see which is the
		// smallest
		// and then the smallest element goes to the studName array.
		while (i < leftSizeArray && x < rightSizeArray) {
			if (leftHalfSide[i].compareTo(rightHalfSide[x]) < 0) {
				studName[z] = leftHalfSide[i];
				i++;
			} else {
				studName[z] = rightHalfSide[x];
				x++;
			}
			z++;
		}

		// Those two loops below works as a backup for the loop above, in case one of
		// those arrays, left and right gets empty,
		// and that trigger the parameters, but one of the can still have remaining
		// elements, so the next loops go though which of them.
		while (i < leftSizeArray) {
			studName[z] = leftHalfSide[i];
			i++;
			z++;
		}

		while (x < rightSizeArray) {
			studName[z] = rightHalfSide[x];
			;
			x++;
			z++;
		}
	}

	// I created this method to help me with the output the merge sort method, so I
	// can print an amount of items that is possible to view on console.
	public static void printStudNameArray(CFP[] studName, int length) {
		for (int i = 0; i < length; i++) {
			System.out.println(studName[i]);
		}
	}
	// =========================================================================================================

	// Question 2: Method for implementation of Tracking time:

	public static long trakingTime(CFP[] studeName, int cfpData, int times) {// Here we have as parameters the CFP data
																				// in an array, and the quantity we want
																				// to track the time on.

		int resulElapsedTime = 0; // A variable to get the total time elapsed during the process.

		for (int i = 0; i < times; i++) {

			CFP[] cfpTimeTrack = copyStudenName(studeName, cfpData);// Instantiate the copy of the array with the size
																	// inputed.

			long start_time = System.nanoTime();// A variable to get hold of the time in the computer at the beginning
												// of the running of the merge sort method.
			studNameMergeSort(cfpTimeTrack, cfpTimeTrack.length);// Using the merge sort on the copy of the array.
			long end_time = System.nanoTime();// This gets hold of the ending time.
			long elapsed_time = end_time - start_time;// Calculating of the times that it took to merge the array.
			resulElapsedTime += elapsed_time;
		}
		System.out.println("The Average Cost of Merge Sorting for " + cfpData + " students run " + times + " times "
				+ " in nanoseconds is: ");
		return resulElapsedTime / times; // Returning the total time.
	}

	// This method creates a copy of the array, looping through and getting hold of
	// the data according whit the size inputed.
	public static CFP[] copyStudenName(CFP[] studenName, int size) {

		CFP[] copStudenName = new CFP[size];

		for (int i = 0; i < size; i++) {

			copStudenName[i] = studenName[i];
		}
		return copStudenName;
	}

}// Class