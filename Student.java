package project1;

import java.sql.*;
import java.sql.DriverManager;

public class Student {
	private int rollno;
	private String StudentName;
	private String FatherName;
	private String Surname;
	private int clas;
	private String Address;
	private int paidFees;
	private String religion;

	public Student(int rollno, String studentName, String fatherName , String surname, int class1, String address,
	int paidFees, String r){
		super();
		this.rollno = rollno;
		StudentName = studentName;
		FatherName = fatherName;
		Surname = surname;
		clas = class1;
		Address = address;
		this.paidFees = paidFees;
		this.religion=r;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getclass() {
		return clas;
	}

	public void setClass(int class1) {
		clas = class1;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(int paidFees) {
		this.paidFees = paidFees;
	}
    public String getReligion() {
		return religion;
	}

	public void setReligion(String r) {
		this.religion = r;
	}
	
	public void Register() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    		Connection con = DriverManager.getConnection("jdbc:ucanaccess://StudentDB.accdb");
    		Statement stm=con.createStatement();
    		String query = "INSERT INTO Table1(RollNo, StudentName, FatherName, Surname, Adress, Class, Religion, PaidFees) "
    				+ "VALUES("+rollno+", '"+StudentName+"', '"+FatherName+"','"+Surname+"', '"+Address+"', "+clas+", '"+religion+"', "+paidFees+");";
    		System.out.println("Executing: "+query);
    		stm.executeUpdate(query);
    		con.close();		  		
			
		}
		catch(Exception e) {
			System.out.println("Error while registering....: "+e.getMessage());
		}
	}

}
