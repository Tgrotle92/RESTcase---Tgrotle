package com.rest;
import java.util.Random;

import com.rest.Customer;

/*Mock class*/
public class Fagsystem{
	private Customer customer = new Customer();
	private int contractNumber = 0;
	private boolean contractSent = false;
	
	public int createCustomer(String inName, int inAge, int inNationalId, String inAddress, int inZipCode, 
			int inMobile, String inEMail){
		customer .setAge(inAge);
		customer .setName(inName);
		customer .setNationalId(inNationalId);
		customer .setAddress(inAddress);
		customer .setZipCode(inZipCode);
		customer .setMobile(inMobile);
		customer .seteMail(inEMail);
		return customer .getCustomerNumber();
	}
	
	//Creating and returning contract number to ContractService.java
	public int createContract(int inCustomerNumber){
		this.contractNumber = inCustomerNumber *26;
		return contractNumber;
	}
	
	public boolean updateContractSent(boolean sent){
		this.contractSent = sent;
		return contractSent;
	}
	
	public boolean getContractSent(){
		return contractSent;
	}
}
