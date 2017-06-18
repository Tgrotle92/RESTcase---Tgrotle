package com.rest;

/*Mock class */
public class Brevtjeneste {
	private boolean contractSent = false;
	
	//Accepts contract number in order to send out a contract. Returns true to ContractService.
	public boolean sendContractToCustomer(int inContractNumber, String inTypeOfContract){
		this.contractSent = true;
		return contractSent;
	}
	
	public boolean getContractSent(){
		return contractSent;
	}
}
