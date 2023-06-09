/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_Alg;

class CFP implements Comparable<Object> {

	private int StudentCode;
	private String StudentName;
	private String ModeOfTransport;
	private int Distance;
	private float Emission;

	// constructor
	public CFP(int studentCode, String studentName, String modeOfTransport, int distance, float emission) {
		setStudentCode(studentCode);
		setStudentName(studentName);
		setModeOfTransport(modeOfTransport);
		setDistance(distance);
		setEmission(emission);

	}
	
	

	public int getStudentCode() {
		return StudentCode;
	}

	private void setStudentCode(int StudentCode) {
		this.StudentCode = StudentCode;

	}

	public String getStudentName() {
		return StudentName;
	}

	private void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}

	public String getModeOfTransport() {
		return ModeOfTransport;
	}

	private void setModeOfTransport(String ModeOfTransport) {
		this.ModeOfTransport = ModeOfTransport;
	}

	private void setDistance(int Distance) {
		this.Distance = Distance;
	}

	public int getDistance() {
		return Distance;
	}

	private void setEmission(float Emission) {
		this.Emission = Emission;
	}

	public float getEmission() {
		return Emission;
	}

	// so the CFP objects can be compared when sorting/searching
	// NOTE: this will only allow comparisons based on the StudentName
	@Override
	public int compareTo(Object obj) {
		CFP prod = (CFP) obj;
		return StudentName.compareTo(prod.getStudentName());
	}

	// return a String containing the CFP details
	@Override
	public String toString() {
		return "Student Code: " + StudentCode + " Student Name: " + StudentName + " Transportation: " + ModeOfTransport + " Distance: " + Distance + " Emission: " + Emission;
	}



	

}
