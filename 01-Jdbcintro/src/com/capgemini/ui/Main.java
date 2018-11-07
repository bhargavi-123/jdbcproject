package com.capgemini.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.business.Customer;
import com.capgemini.db.CustomerDAO;
import com.capgemini.db.CustomerDAOImpl;

public class Main {
	public static void add() {
		
	}
	public static void update() {
		
	}
	public static void display() throws ClassNotFoundException, SQLException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		List<Customer> customers = customerDAO.getAllCustomers(); 
		System.out.println(customers);
		
	}
	public static void remove() throws ClassNotFoundException, SQLException {
		int inp_id = 0;
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter id to remove: ");
	    inp_id = scanner.nextInt();
	    
	    
	    
	    
	    CustomerDAO customerDAO = new CustomerDAOImpl();
	    boolean result = customerDAO.removeCustomer(inp_id);
	    if(result == true) {
	    	System.out.println("record deleted Succesfully");
	    }
	    else {
	    	System.out.println("not deleted");
	    }
	       
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Customer application");
		System.out.println("....................");
		System.out.println("1. Add New Customer");
		System.out.println("2. update Customer");
		System.out.println("3. Display All Customers");
		System.out.println("4. Delete Customer ");
		System.out.println("5. Exit");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				add();
			
				break;
			case 2:
				update();
				break;	

			case 3:
				display();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("Thank you");
				break;	
		}
	}

}
