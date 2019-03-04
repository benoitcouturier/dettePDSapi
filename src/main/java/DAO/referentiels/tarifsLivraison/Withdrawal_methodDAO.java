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
			String sql = "INSERT INTO Withdrawal_method VALUES (DEFAULT,?,?,?,?,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,wm.getWM_name());
			ps.setFloat(i++,wm.getWM_price());
			ps.setInt(i++, wm.getWM_distance_min());
			ps.setInt(i++, wm.getWM_distance_max());
			ps.setInt(i++, wm.getWM_estimated_delivery_min());
			ps.setInt(i++, wm.getWM_estimated_delivery_max());
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

				ps.setString(i++,wm.getWM_name());
				ps.setFloat(i++,wm.getWM_price());
				ps.setInt(i++, wm.getWM_distance_min());
				ps.setInt(i++, wm.getWM_distance_max());
				ps.setInt(i++, wm.getWM_estimated_delivery_min());
				ps.setInt(i++, wm.getWM_estimated_delivery_max());
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wm;
	}
	
	public ArrayList<Withdrawal_method> find(String vm_name){

		PreparedStatement ps ;
		ResultSet rs = null;
		ArrayList <Withdrawal_method> Withdrawal_methods = new ArrayList<Withdrawal_method>();
		
		try {
			int i = 1;
			
			connect = Database.getConnection();
			String sql = "SELECT * FROM Withdrawal_method where WM_name = ?";
			ps = connect.prepareStatement(sql);
			ps.setString(i, vm_name);
			rs = ps.executeQuery(sql);

			while(rs.next()) {
				Withdrawal_method wm = new Withdrawal_method(rs.getInt("WM_id"), rs.getString("WM_name"), rs.getFloat("WM_price"), rs.getInt("WM_distance_min"),rs.getInt("WM_distance_max"),rs.getInt("WM_estimated_delivery_min"), rs.getInt("WM_estimated_delivery_max"));
				Withdrawal_methods.add(wm);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Withdrawal_methods;
	}
	
	public ArrayList<String> findNames(){

		PreparedStatement ps ;
		ResultSet rs = null;
		ArrayList <String> WM_names = new ArrayList<String>();
		
		try {
			
			connect = Database.getConnection();
			String sql = "SELECT DISTINCT WM_name FROM Withdrawal_method";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery(sql);

			while(rs.next()) {
				String name = rs.getString("WM_name");
				WM_names.add(name);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return WM_names;
	}
	
	
	
	public void update (Withdrawal_method wm, int j){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "UPDATE Withdrawal_method SET WM_name = ?, WM_price_ = ?, WM_distance_min = ? WM_distance_max = ?, WM_estimated_delivery_min = ?, WM_estimated_delivery_max = ? WHERE WM_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,wm.getWM_name());
			ps.setFloat(i++,wm.getWM_price());
			ps.setInt(i++, wm.getWM_distance_min());
			ps.setInt(i++, wm.getWM_distance_max());
			ps.setInt(i++, wm.getWM_estimated_delivery_min());
			ps.setInt(i++, wm.getWM_estimated_delivery_max());
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
				wm.setWM_name(rs.getString("WM_name"));
				wm.setWM_price(rs.getFloat("WM_price"));
				wm.setWM_distance_min(rs.getInt("WM_distance_min"));
				wm.setWM_distance_max(rs.getInt("WM_distance_max"));
				wm.setWM_estimated_delivery_min(rs.getInt("WM_estimated_delivery_min"));
				wm.setWM_estimated_delivery_max(rs.getInt("WM_estimated_delivery_max"));
				
				liste.add(wm);  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
