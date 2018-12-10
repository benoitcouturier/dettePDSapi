package DAO.referentiels.tarifsLivraison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.CrudDAO;
import Entites.referentiels.tarifsLivraison.Withdrawal_price;


public class Withdrawal_priceDAO implements CrudDAO <Withdrawal_price> {

	public Connection connect;
	
	public void create (Withdrawal_price wp){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "INSERT INTO Withdrawal_price VALUES (DEFAULT,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setInt(i++,wp.getWP_distance());
			ps.setInt(i++,wp.getWP_price());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Withdrawal_price find (Withdrawal_price wp){

		PreparedStatement ps ;
		ResultSet rs = null;

		try {
			int i = 1;
			
			connect = Database.getConnection();
			String sql = "SELECT * FROM Withdrawal_price where WP_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i++, wp.getWP_id());
			rs = ps.executeQuery(sql);

			if(rs.first()) {
				wp.setWP_distance(rs.getInt("WP_distance"));
				wp.setWP_price(rs.getInt("WP_price"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wp;
	}
	
	public void update (Withdrawal_price wp, int j){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "UPDATE Withdrawal_price SET WP_distance = ?, WP_price = ? WHERE WP_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i++,wp.getWP_distance());
			ps.setInt(i++,wp.getWP_price());
			ps.setInt(i++,j);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete (Withdrawal_price wp){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "DELETE FROM Withdrawal_price WHERE WP_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i,wp.getWP_id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Withdrawal_price> read(){

		ArrayList<Withdrawal_price> liste = new ArrayList<>();

		Statement st = null;
		ResultSet rs = null;

		try {

			connect = Database.getConnection();

			st = this.connect.createStatement();
			String sql = "SELECT * FROM Withdrawal_price";
			rs = st.executeQuery(sql);

			while(rs.next()) {
				liste.add(new Withdrawal_price(rs.getInt("WP_id"),rs.getInt("WP_distance"),rs.getInt("WP_price")));  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
