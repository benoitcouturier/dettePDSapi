package DAO.referentiels.tarifsLivraison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.CrudDAO;
import DataBase.Database;
import Entites.referentiels.tarifsLivraison.Withdrawal_method;
import Entites.referentiels.tarifsLivraison.Withdrawal_price;

public class Withdrawal_methodDAO implements CrudDAO <Withdrawal_method> {
public Connection connect;
	
	public void create (Withdrawal_method wm){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "INSERT INTO Withdrawal_method VALUES (DEFAULT,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,wm.getWM_name());
			ps.setInt(i++,wm.getWP().getWP_id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Withdrawal_method find(Withdrawal_method wm){

		PreparedStatement ps ;
		ResultSet rs = null;
		
		try {
			int i = 1;
			
			connect = Database.getConnection();
			String sql = "SELECT * FROM Withdrawal_method WM, Withdrawal_price WP where WM.WP_id = WP.WP.WP_id and WM.WM_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i, wm.getWM_id());
			rs = ps.executeQuery(sql);

			if(rs.first()) {
				Withdrawal_price wp = new Withdrawal_price();
				wp.setWP_id(rs.getInt("WP_id"));
				wp.setWP_distance(rs.getInt("WP_distance"));
				wp.setWP_price(rs.getInt("WP_price"));
				
				wm.setWM_name(rs.getString("WM_name"));
				wm.setWP(wp);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wm;
	}
	
	public void update (Withdrawal_method wm, int j){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "UPDATE Withdrawal_method SET WM_name = ? WHERE WM_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,wm.getWM_name());
			ps.setInt(i++,j);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete (Withdrawal_method wm){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "DELETE FROM Withdrawal_method WHERE WM_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i,wm.getWM_id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Withdrawal_method> read(){

		ArrayList<Withdrawal_method> liste = new ArrayList<>();

		Statement st = null;
		ResultSet rs = null;

		try {

			connect = Database.getConnection();

			st = this.connect.createStatement();
			String sql = "SELECT * FROM Withdrawal_price";
			rs = st.executeQuery(sql);

			while(rs.next()) {
				Withdrawal_price wp = new Withdrawal_price();
				Withdrawal_method wm = new Withdrawal_method();
				wp.setWP_id(rs.getInt("WP_id"));
				wp.setWP_distance(rs.getInt("WP_distance"));
				wp.setWP_price(rs.getInt("WP_price"));
				
				wm.setWM_name(rs.getString("WM_name"));
				wm.setWP(wp);
				
				liste.add(wm);  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
