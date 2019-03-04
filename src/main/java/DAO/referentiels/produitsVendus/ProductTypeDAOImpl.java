package DAO.referentiels.produitsVendus;

import DataBase.Database;
import Entites.referentiels.produitsVendus.ProductType;

import java.sql.*;
import java.util.ArrayList;

public class ProductTypeDAOImpl implements ProductTypeDAO<ProductType> {

	@Override
	public void create(ProductType object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ProductType> read() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<ProductType> tp = new ArrayList<ProductType>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Product_type";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductType prodt = new ProductType();
				prodt.setProdt_id(rs.getInt("prodt_id"));
				prodt.setProdt_name(rs.getString("prodt_name"));
				tp.add(prodt);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tp;
	}

	@Override
	public void delete(ProductType object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProductType object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductType find(ProductType object) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ProductType prodt = new ProductType();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Product_type where prodt_id= ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i++, object.getProdt_id());
			rs = ps.executeQuery();
			while(rs.next()) {
				
				prodt.setProdt_id(rs.getInt("prodt_id"));
				prodt.setProdt_name(rs.getString("prodt_name"));
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodt;
	}

}
