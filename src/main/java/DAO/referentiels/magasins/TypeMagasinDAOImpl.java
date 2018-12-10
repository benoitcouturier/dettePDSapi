package DAO.referentiels.magasins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entites.referentiels.magasins.TypeMagasin;

public class TypeMagasinDAOImpl implements TypeMagasinDAO<TypeMagasin> {

	@Override
	public void create(TypeMagasin object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TypeMagasin> read() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<TypeMagasin> typeMagasins = new ArrayList<TypeMagasin>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from TypeMagasin";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TypeMagasin t = new TypeMagasin();
				t.setId(rs.getInt("id"));
				t.setType(rs.getString("type"));
				typeMagasins.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typeMagasins;
	}

	@Override
	public void delete(TypeMagasin object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TypeMagasin object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeMagasin find(TypeMagasin object) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		TypeMagasin t = new TypeMagasin();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from TypeMagasin where id= ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i++, object.getId());
			rs = ps.executeQuery();
			while(rs.next()) {
				
				t.setId(rs.getInt("id"));
				t.setType(rs.getString("type"));
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

}
