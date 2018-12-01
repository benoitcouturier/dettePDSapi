package DAO.referentiels.magasins;

import java.io.BufferedReader;
import java.io.FileReader;
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
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "INSERT INTO Magasins VALUES (?,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,object.getNom());
			ps.setString(i++,object.getDescription());
			ps.setInt(i++,object.getIdType());
			ps.executeUpdate();

			object.setId(0);
			i=1;
			sql = "INSERT INTO EmplacementMagasin VALUES (?,?)";
			ps2 = connect.prepareStatement(sql);
			ps2.setInt(i++, this.find(object).getId());
			ps2.setInt(i++, object.getIdEmplacement());
		} catch (SQLException e) {
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
		// TODO Auto-generated method stub

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
		
		if(object.getId()!=0) {
			try {
				int i =1;
				connect = Database.getConnection();
				String sql = "Select * from Magasins where is = ?";
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
		}else {
			try {
				int i =1;
				connect = Database.getConnection();
				String sql = "Select * from Magasins where nom = ?";
				ps = connect.prepareStatement(sql);
				ps.setString(i++, object.getNom());
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
		}
		
		
		
		return m;
	}


}
