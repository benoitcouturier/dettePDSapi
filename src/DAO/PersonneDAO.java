package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DataBase.Database;
import Entites.Personne;


public class PersonneDAO {

	public Connection connect;
	public ArrayList<Personne> getAllPersonnes(){

		ArrayList<Personne> liste = new ArrayList<>();


		Statement st = null;
		ResultSet rs = null;

		try {

			connect = Database.getConnection();

			st = this.connect.createStatement();
			String sql = "SELECT * FROM Personne";
			rs = st.executeQuery(sql);

			while(rs.next()) {
				liste.add(new Personne(rs.getString("name"),rs.getString("firstname"),rs.getInt("age"),rs.getInt("ID")));  
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public void add(Personne personne){
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "INSERT INTO Personne VALUES (?,?,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,personne.getName());
			ps.setString(i++,personne.getFirstname());
			ps.setInt(i++,personne.getAge());
			ps.setInt(i++,personne.getPersonneId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
