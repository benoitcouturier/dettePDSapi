package DAO.portail.gererSonCompteClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DataBase.Database;
import Entites.portail.gererSonCompteClient.Customer_account;
import Entites.portail.gererSonCompteClient.NotifCustomer;
import Entites.referentiels.magasins.Emplacement;
import Entites.referentiels.magasins.TypeMagasin;

public class NotifClientDAOImpl implements NotifClientDAO<Customer_account>{

	@Override
	public void create(Customer_account object) throws Exception {
		// TODO Auto-generated method stub
		
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
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		Customer_account ca = new Customer_account();
		boolean multipleField = false;
		int compteur = 1;
		
		try {
			connect = Database.getConnection();
			String sql = "Select * from NotifCustomer where ";
			ps = connect.prepareStatement(sql);
			
			if (!object.getCustomer_sex().isEmpty()){
				if (multipleField = true) {
					sql += "and ";
				}
				sql += "customer_sex = ?";
				ps.setString(compteur++,object.getCustomer_sex());
				multipleField = true;
			}
			
			if (object.getCustomer_location() != 0){
				if (multipleField = true) {
					sql += "and ";
				}
				sql += "customer_location = ?";
				ps.setInt(compteur++,object.getCustomer_location());
				multipleField = true;
			}
			
			if (object.getCustomer_notification() != 0){
				if (multipleField = true) {
					sql += " and ";
				}
				sql += "customer_notification = ?";
				ps.setInt(compteur++,object.getCustomer_notification());
				multipleField = true;
			}
			
			
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ca.setCustomer_sex(rs.getString("customer_sex"));
				ca.setCustomer_notification(rs.getInt("customer_notification"));
				ca.setCustomer_location(rs.getInt("customer_location"));
			}

		} catch (SQLException erreur) {
			erreur.printStackTrace();
		}
		return ca;
	}

	@Override
	public ArrayList<Customer_account> read() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Customer_account> notif_cust = new ArrayList<Customer_account>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Customer_account";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				NotifCustomer nc = new NotifCustomer();
				nc.setCustomer_sex(rs.getString("customer_sex"));
				nc.setCustomer_notification(rs.getInt("customer_notification"));
				nc.setCustomer_location(rs.getInt("customer_location"));
				//notif_cust.add(nc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notif_cust;
	}

	@Override
	public ArrayList<Customer_account> getEmplacementsDisponibles() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
