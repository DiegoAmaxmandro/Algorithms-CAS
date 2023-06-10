# Algorithms-CAS
This is the code a used to answer my Terminal Assignment-based Assessment for the Software Development discipline.

## Project Background:
A hypothetical Irish climate change advocacy group wants to analyse the carbon footprint (CFP) of higher education students in Ireland. The group collected data about all higher education students concerning their transport usage to travel to/from their respective universities. So far, the group has managed to collect 10,000 CFP records containing 8-digit StudentCode (integer), studentName (string), ModeOfTransport (Bus, Train, Car, Motor Bike, Bike, E-scooter, Walk), distance in KM (integer) and Emission in KG (float). The data is already sorted by studentCode in ascending order.
Assuming that you are part of development team, your responsibility includes analysis of the data and writing program fragments that will manage information related to the CFP. Now you are assigned to implement and generate report for the following sprints before 02-08-2022 @23:59. A supplementary Java code that will read and store the dataset in an array of CFP, and the dataset will be provided for you on the Moodle page.

## Part 1: Sorting and Searching: Algorithm Analysis
1. Write a Java method(s) that sort the CFP information using a Merge-sort algorithm. The CFP should be sorted by its studentName in ascending order. (30 Marks)
  Input: 10,000 unsorted CFP records,
  Output: 10,000 CFP records sorted in ascending order by studentName.

2. Write a program that tracks the time of your sorting algorithms in Q1 by running your program and tracking the average elapsed time. Your experiment should take an input of 10, 100, 1000, 10000 records for the sorting algorithm. Use the following template to track the time and generate a graph of the growth of the algorithm. 

3. Write an implementation of a binary search using Java method(s) that search a record by the
StudentCode field.
  Input: StudentCode
  Output: the CFP record/s corresponding to the StudentCode.

## Part 2: Defensive Programming and Exception Handling (New: Implement this section only for a data entry for new CFP details)
1. Transportation mode should always be one of the values (Bus, Train, Car, Motor Bike, Bike, Walk), Write a Java setter method (setModeOfTransport) that checks the value of the ModeOfTransport and throws a custom exception with a message ‘Unsupported Mode of Transport. Please correct the transportation mode by choosing from (Bus, Train, Car, Motor Bike, Bike, E-scooter, Walk)’.

2. Write a Java method that checks the correct values of the distance field. The minimum distance in KM is 1 and the maximum is 500. (15 Marks)
  Example Invalid input: distance = 0.25 (distance below trackable limit)
  Example Invalid input: distance = 12570 (Invalid distance limit for Ireland)
