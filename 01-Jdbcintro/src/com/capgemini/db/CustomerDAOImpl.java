package com.capgemini.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.business.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCustomer(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionManager.createConnection();
		String SQL = "delete from  Customer where c_id = ?";
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1, customerId);
		int r = statement.executeUpdate();
		if(r > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionManager.createConnection();
		String SQL = "Select * from Customer";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(SQL);
		List<Customer> customers = new ArrayList<>();
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String city = rs.getString(3);
			double outStandingAmount = rs.getDouble(4);
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setCity(city);
			customer.setOutStandingAmount(outStandingAmount);
			customers.add(customer);	
		}
		statement.close();
		rs.close();
		ConnectionManager.closeConnection(connection);
		return customers;
	}

}
