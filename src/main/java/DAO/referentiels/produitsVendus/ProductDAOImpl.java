package DAO.referentiels.produitsVendus;

import DataBase.Database;
import Entites.referentiels.produitsVendus.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO<Product> {

	@Override
	public void create(Product object) throws Exception {
		PreparedStatement myStmt = null;
			// connect to the bdd
			Connection myConn = Database.getConnection();
			myStmt = myConn.prepareStatement("insert into Product (product_id,product_name,product_price,product_quantity,store_id,prods_id,prodt_id,departement) values (NULL,?,?,?,?,?,?,?)"); // request
			myStmt.setString(1, object.getPname());
			myStmt.setFloat(2, object.getPrice());
			myStmt.setInt(3, object.getPqte());
			myStmt.setInt(4, object.getSid());
			myStmt.setInt(5, object.getPsid());
			myStmt.setInt(6, object.getPtid());
			myStmt.setString(7, object.getDepartement());
			myStmt.executeUpdate();
			myConn.close();
	}

	@Override
	public void delete(Product object) throws Exception {
		PreparedStatement myStmt = null;
		// connect to the bdd
			Connection myConn = Database.getConnection();
			myStmt = myConn.prepareStatement("delete From Product where product_id=?");
			myStmt.setInt(1, object.getPid());
			myStmt.executeUpdate();
			myConn.close();
	}

	@Override
	public void update(Product object, int id) throws Exception {
        // prepare request
        PreparedStatement myStmt=null;
        //connect to the bdd
        Connection myConn = Database.getConnection();
        myStmt = myConn.prepareStatement("update Product set product_name=? ,product_price=?, product_quantity=?, store_id=?, prods_id=?, prodt_id=?, departement=? where product_id=? ");
        //value entered in the order of '?' in the request
        myStmt.setString(1, object.getPname());
        myStmt.setDouble(2, object.getPrice());
        myStmt.setInt(3, object.getPqte());
        myStmt.setInt(4, object.getSid());
        myStmt.setInt(5, object.getPsid());
        myStmt.setInt(6, object.getPtid());
        myStmt.setInt(7, object.getPid());
        myStmt.setString(8, object.getDepartement());
        myStmt.executeUpdate();
        myConn.close();

	}

	@Override
	public Product find(Product object) throws Exception {
			Connection connect;
			PreparedStatement ps ;
			ResultSet myRs;
			Product p = new Product();
			try {
				int i =1;
				connect = Database.getConnection();
				String sql = "Select * from Product where prods_id=1 and id=?";
				ps = connect.prepareStatement(sql);
				ps.setInt(i++, object.getPid());
				myRs = ps.executeQuery();
				while(myRs.next()) {
					p.setPid(myRs.getInt("product_id"));
					p.setPname(myRs.getString("product_name"));
					p.setPqte(myRs.getInt("product_quantity"));
					p.setPrice(myRs.getFloat("product_price"));
					p.setSid(myRs.getInt("store_id"));
					p.setPsid(myRs.getInt("prods_id"));
					p.setPtid(myRs.getInt("prodt_id"));
					p.setDepartement(myRs.getString("departement"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
	}

	@Override
	public ArrayList<Product> read() throws Exception {
        //list of product
        ArrayList<Product> listProduct = new ArrayList<Product>();
        //connect to the bdd 
        Connection myConn = Database.getConnection();
         //request
        Statement myStmt = myConn.createStatement();
        //result of request
        ResultSet myRs = myStmt.executeQuery("select * from Product where prods_id=1");
        //loop for add product
        while (myRs.next()) {
			Product p = new Product();
			p.setPid(myRs.getInt("product_id"));
			p.setPname(myRs.getString("product_name"));
			p.setPqte(myRs.getInt("product_quantity"));
			p.setPrice(myRs.getFloat("product_price"));
			p.setSid(myRs.getInt("store_id"));
			p.setPsid(myRs.getInt("prods_id"));
			p.setPtid(myRs.getInt("prodt_id"));
			p.setDepartement(myRs.getString("departement"));

			listProduct.add(p);
}
        // return list of product
        return listProduct;
	}
	
	@Override
	public ArrayList<Product> findtype(Product object)  {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Product> prod = new ArrayList<Product>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Product where prodt_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(i++, object.getPtid());
			rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("product_id"));
				p.setPname(rs.getString("product_name"));
				p.setPqte(rs.getInt("product_quantity"));
				p.setPrice(rs.getFloat("product_price"));
				p.setSid(rs.getInt("store_id"));
				p.setPsid(rs.getInt("prods_id"));
				p.setPtid(rs.getInt("prodt_id"));
				p.setDepartement(rs.getString("departement"));
				prod.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}
	
	public ArrayList<Product> findname(Product object)  {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Product> prod = new ArrayList<Product>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Product where product_name like ?";
			ps = connect.prepareStatement(sql);
			ps.setString(i++, (object.getPname()+"%"));
			rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setPname(rs.getString("product_name"));
				prod.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}
	
	@Override
	public boolean issettype(int id) {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		Boolean b = false;
		try {
			connect = Database.getConnection();
			String sql = "Select * from Product_type where prodt_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()) {
				b = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

}
