package DAO.referentiels.produitsVendus;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.referentiels.produitsVendus.ProductDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DataBase.Database;
import Entites.referentiels.produitsVendus.Product;

public class test{
	
	public void create(String pname, double price, int pqte, int sid, int psid, int ptid) {
        PreparedStatement myStmt=null;
        try {
        //connect to the bdd
        Connection myConn = Database.getConnection();
        myStmt = myConn.prepareStatement("insert into product (product_id,product_name,product_price,product_quantity,store_id,prods_id,prodt_id) values (DEFAULT,?,?,?,?,?,?)");
        //request
        myStmt.setString(1, pname);
        myStmt.setDouble(2, price);
        myStmt.setInt(3, pqte);
        myStmt.setInt(4, sid);
        myStmt.setInt(5, psid);
        myStmt.setInt(6, ptid);
        myStmt.executeUpdate();

    }catch(SQLException e){
    	e.printStackTrace();
    }
}
    
		public List<Product> read() throws SQLException {
		        //list of product
		        List<Product> listProduct = new ArrayList<>();
		        //connect to the bdd 
		        Connection myConn = Database.getConnection();
		         //request
		        Statement myStmt = myConn.createStatement();
		        //result of request
		        ResultSet myRs = myStmt.executeQuery("select * from product where prods_id=1");
		        //loop for add product
		        while (myRs.next()) {
		            int id = myRs.getInt("product_id");
		            String name = myRs.getString("product_name");
		            Float price = myRs.getFloat("product_price");
		            int qte = myRs.getInt("product_quantity");
		            int sid = myRs.getInt("store_id");
		            int psid = myRs.getInt("prods_id");
		            int ptid = myRs.getInt("prodt_id");

		           // Product P = new Product(id, name, price, qte, sid, psid, ptid);

		           // listProduct.add(P);
		}
		        // return list of product
		        return listProduct;
		        

		    }


		    public void update(int pid,String pname, double price, int pqte, int sid, int psid, int ptid){
		        // prepare request
		        PreparedStatement myStmt=null;
		        //connect to the bdd
		        try {
		        Connection myConn = Database.getConnection();
		        //request
		        myStmt = myConn.prepareStatement("update product set product_name=? ,product_price=?, product_quantity=?, store_id=?, prods_id=?, prodt_id=?  where product_id=? ");
		        //value entered in the order of '?' in the request
		        myStmt.setString(1, pname);
		        myStmt.setDouble(2, price);
		        myStmt.setInt(3, pqte);
		        myStmt.setInt(4, sid);
		        myStmt.setInt(5, psid);
		        myStmt.setInt(6, ptid);
		        myStmt.setInt(7, pid);
		        myStmt.executeUpdate();
		        }catch(SQLException e){
			    	e.printStackTrace();
			    }

		    }
		    
		    public void delete(int pid) {
		        PreparedStatement myStmt=null;
		        //connect to the bdd
		        try {
		        Connection myConn = Database.getConnection();
		        myStmt = myConn.prepareStatement("delete From product where product_id=?");
		        //request
		        myStmt.setInt(1, pid);

		        myStmt.executeUpdate();
			    }catch(SQLException e){
			    	e.printStackTrace();
			    }
		    }

		    
}
