package DAO.referentiels.magasins;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "INSERT INTO Magasins VALUES (?,?,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,object.getNom());
			ps.setString(i++,object.getDescription());
			ps.setInt(i++,object.getIdEmplacement());
			ps.setInt(i++,object.getIdType());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Magasin> read() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
