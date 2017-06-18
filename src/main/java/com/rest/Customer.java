package com.rest;

import java.util.Random;

/*Mock class, creating random generated customer number for testing. */
public class Customer {
	private String name = "", address = "", eMail = "";
	private int customerNumber = 0, age = 0, nationalId = 0, zipCode = 0, mobile = 0;
	
	public Customer(){
		this.name = "";
		this.age = 0;
		this.nationalId = 0;
		this.address = "";
		this.zipCode = 0;
		this.mobile = 0;
		this.eMail = "";
		Random randomGenerator = new Random();
		this.customerNumber = randomGenerator.nextInt(1000);
	}
	
	public Customer(String inName, int inAge, int inNationalId, String inAddress, int inZipCode, int inMobile, String inEMail){
		this.name = inName;
		this.age = inAge;
		this.nationalId = inNationalId;
		this.address = inAddress;
		this.zipCode = inZipCode;
		this.mobile = inMobile;
		this.eMail = inEMail;
		Random randomGenerator = new Random();
		this.customerNumber = randomGenerator.nextInt(1000);
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getNationalId() {
		return nationalId;
	}

	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public void setName(String inName){
		this.name = inName;
	}
	
	public void setAge(int inAge){
		this.age = inAge;
	}
	
	public int getCustomerNumber(){
		return customerNumber;
	}
}
