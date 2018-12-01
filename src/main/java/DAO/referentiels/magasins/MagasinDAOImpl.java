package DAO.referentiels.magasins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entites.referentiels.magasins.Magasin;
import DAO.referentiels.magasins.MagasinsDAO;
import DataBase.Database;

public class MagasinDAOImpl implements MagasinsDAO<Magasin> {

	@Override
	public void create(Magasin object) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		PreparedStatement ps2 ;

		int i =1;
		connect = Database.getConnection();
		String sql = "INSERT INTO Magasins VALUES (NULL,?,?,?)";
		ps = connect.prepareStatement(sql);
		ps.setString(i++,object.getNom());
		ps.setString(i++,object.getDescription());
		ps.setInt(i++,object.getIdType());
		ps.executeUpdate();
		connect.close();

		try {
			connect = Database.getConnection();
			object.setId(0);
			System.out.println("This.selectMax : " + this.selectMax().getId());
			i=1;
			String sql2 = "INSERT INTO EmplacementMagasin VALUES (NULL,?,?)";
			ps2 = connect.prepareStatement(sql2);
			ps2.setInt(i++, object.getIdEmplacement());
			ps2.setInt(i++, this.selectMax().getId());
			ps2.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public ArrayList<Magasin> read() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Magasin> magasins = new ArrayList<Magasin>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Magasins";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Magasin m = new Magasin();
				m.setDescription(rs.getString("description"));
				m.setId(rs.getInt("id"));
				m.setIdType(rs.getInt("idType"));
				m.setNom(rs.getString("nom"));

				magasins.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magasins;
	}

	@Override
	public void delete(Magasin object) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		PreparedStatement ps2 ;

		int i =1;
		connect = Database.getConnection();
		String sql = "Delete from EmplacementMagasin where idMagasin=?";
		ps = connect.prepareStatement(sql);
		ps.setInt(i++,object.getId());
		ps.executeUpdate();
		connect.close();

		try {
			connect = Database.getConnection();
			i=1;
			String sql2 = "Delete from Magasins where id=?";
			ps2 = connect.prepareStatement(sql2);
			ps2.setInt(i++, object.getId());
			ps2.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Magasin object, int id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Magasin find(Magasin object) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		Magasin m = new Magasin();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Magasins where id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i++, object.getId());
			rs = ps.executeQuery();
			while(rs.next()) {
				m.setDescription(rs.getString("description"));
				m.setId(rs.getInt("id"));
				m.setIdType(rs.getInt("idType"));
				m.setNom(rs.getString("nom"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	@Override
	public Magasin selectMax() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		Magasin m = new Magasin();
		try {
			connect = Database.getConnection();
			String sql = "Select Max(id) as Max from Magasins";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				m.setId(rs.getInt("Max"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}


}
