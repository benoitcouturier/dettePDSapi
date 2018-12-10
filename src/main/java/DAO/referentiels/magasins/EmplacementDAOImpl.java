package DAO.referentiels.magasins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entites.referentiels.magasins.Emplacement;


public class EmplacementDAOImpl implements EmplacementDAO<Emplacement> {

	@Override
	public void create(Emplacement object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Emplacement> read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Emplacement object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Emplacement object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Emplacement find(Emplacement object) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		Emplacement e = new Emplacement();
		try {
			connect = Database.getConnection();
			String sql = "Select * from Emplacements where id =?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, object.getId());
			rs = ps.executeQuery();
			while(rs.next()) {
				e.setAile(rs.getString("aile"));
				e.setId(rs.getInt("id"));
				e.setImportance(rs.getInt("Importance"));
				e.setSuperficie(rs.getInt("superficie"));
			}

		} catch (SQLException erreur) {
			erreur.printStackTrace();
		}
		return e;
	}

	@Override
	public ArrayList<Emplacement> getEmplacementsDisponibles() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Emplacement> emplacements = new ArrayList<Emplacement>();
		try {
			connect = Database.getConnection();
			String sql = "Select * from Emplacements where id not in (Select idEmplacement from EmplacementMagasin);";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Emplacement e = new Emplacement();
				e.setAile(rs.getString("aile"));
				e.setId(rs.getInt("id"));
				e.setImportance(rs.getInt("Importance"));
				e.setSuperficie(rs.getInt("superficie"));
				emplacements.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emplacements;
	}




}
