package com.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.rest.Fagsystem;
import com.rest.Brevtjeneste;

@Path("/contract")
public class ContractService {
	private boolean contractStatusFromBrevtjeneste = false, contractStatusFromFagsystem = false;
	private int contractNumber = 0, customerNumber = 0;
	private Fagsystem fagSys = new Fagsystem();
	private Brevtjeneste brevSys = new Brevtjeneste();
	
	@POST
	@Path("/create")
	public Response createContract(@FormParam("name") String name, @FormParam("age") int age, 
			@FormParam("nationalId") int nationalId, @FormParam("address") String address,
			@FormParam("zipCode") int zipCode, @FormParam("mobilePhone") int mobilePhone, 
			@FormParam("eMail") String eMail, @FormParam("contract") String contract) {
		
		customerNumber = fagSys.createCustomer(name, age, nationalId, address, zipCode, mobilePhone, eMail);
		contractNumber = fagSys.createContract(customerNumber);
		contractStatusFromBrevtjeneste = brevSys.sendContractToCustomer(contractNumber, contract);
		contractStatusFromFagsystem = fagSys.updateContractSent(contractStatusFromBrevtjeneste);
		
		//Checking if the updated failed in Fagsystem
		if(contractStatusFromBrevtjeneste != contractStatusFromFagsystem){
			//The updated failed, trying again 10 times to update it
			for(int i = 0; i < 10; i++){
				contractStatusFromFagsystem = fagSys.updateContractSent(contractStatusFromBrevtjeneste);
				if(contractStatusFromBrevtjeneste == contractStatusFromFagsystem){
					//Update complete, informing the customer
					return Response.status(200).entity("Contract number is:  " + contractNumber +
							" and your contract status is: Sent.").build();
				}
			}
			//Contact a system admin regarding Fagsystem failing. Informing customer.
			return Response.status(200).entity("Contract number is:  " + contractNumber +
					" and your contract status is: Sent, but not activated. Please contact us here: xxx xx xxx.").build();
		}
		else{
			return Response.status(200).entity("Contract number is:  " + contractNumber +
					" and your contract status is: Sent.").build();
		}
		
	}
}
