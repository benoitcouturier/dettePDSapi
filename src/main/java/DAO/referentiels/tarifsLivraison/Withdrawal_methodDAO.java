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

public class Withdrawal_methodDAO implements CrudDAO <Withdrawal_method> {
public Connection connect;
	
	public void create (Withdrawal_method wm){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "INSERT INTO Withdrawal_method VALUES (DEFAULT,?,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,wm.getWM_name());
			ps.setInt(i++,wm.getWM_distance());
			ps.setInt(i++,wm.getWM_price());
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
			String sql = "SELECT * FROM Withdrawal_method where WM_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i, wm.getWM_id());
			rs = ps.executeQuery(sql);

			if(rs.first()) {

				wm.setWM_distance(rs.getInt("WP_distance"));
				wm.setWM_price(rs.getInt("WP_price"));
				wm.setWM_name(rs.getString("WM_name"));
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
			String sql = "UPDATE Withdrawal_method SET WM_name = ?, WM_distance = ?, WM_price = ? WHERE WM_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,wm.getWM_name());
			ps.setInt(i++,wm.getWM_distance());
			ps.setInt(i++,wm.getWM_price());
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
			String sql = "SELECT * FROM Withdrawal_method";
			rs = st.executeQuery(sql);

			while(rs.next()) {
				
				Withdrawal_method wm = new Withdrawal_method();
				wm.setWM_id(rs.getInt("WM_id"));
				wm.setWM_distance(rs.getInt("WM_distance"));
				wm.setWM_price(rs.getInt("WM_price"));
				wm.setWM_name(rs.getString("WM_name"));
				
				liste.add(wm);  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
