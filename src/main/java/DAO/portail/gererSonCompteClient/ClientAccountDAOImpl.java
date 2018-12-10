package DAO.portail.gererSonCompteClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Entites.portail.gererSonCompteClient.Customer_account;

public class ClientAccountDAOImpl implements ClientAccountDAO<Customer_account> {


	@Override
	public void create(Customer_account object) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn;
		PreparedStatement state;
		
		try{
			int i =1;
			conn = Database.getConnection();
			String sql = "INSERT INTO customer_account VALUES(?,?,?,?,?,?,?,?)";
			state = conn.prepareStatement(sql);
			state.setInt(i++,object.getCustomer_phone());
			state.setString(i++, object.getAdress());
			state.setString(i++, object.getCity());
			state.setString(i++, object.getState());
			state.setString(i++, object.getEmail());
			state.setString(i++, object.getSex());
			state.setInt(i++, object.getAge());
		} catch(SQLException e){
			e.printStackTrace();
		}

		
	}

	@Override
	public void delete(Customer_account object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer_account object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer_account find(Customer_account object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<Customer_account> read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
