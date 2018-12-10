package DAO.portail.gererSonCompteClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DataBase.Database;
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
			String sql = "INSERT INTO Customer_account VALUES(NULL,?,?,?,?,?,?,?,?,1,1,1)";
			state = conn.prepareStatement(sql);
			state.setInt(i++,object.getCustomer_phone());
			state.setInt(i++, object.getCustomer_age());
			state.setString(i++, object.getCustomer_sex());
			state.setString(i++, object.getCustomer_state());
			state.setString(i++, object.getCustomer_city());
			state.setString(i++, object.getCustomer_adress());
			state.setString(i++, object.getCustomer_email());
			state.setString(i++, object.getCustomer_preferences());
			
			state.executeUpdate();
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
