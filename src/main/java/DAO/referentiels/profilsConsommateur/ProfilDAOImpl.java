package DAO.referentiels.profilsConsommateur;
import DataBase.Database;
import Entites.portail.gererSonCompteClient.Customer_account;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.profilsConsommateur.Profil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfilDAOImpl implements ProfilDAO<Profil> {
    @Override
    public void create(Profil profil) throws Exception {

        Connection connect;
        PreparedStatement st;

        try {

            connect= Database.getConnection();
            String sql = "INSERT INTO profil_type VALUES(NULL,?,?,?,?,?)";
            st = connect.prepareStatement(sql);
            st.setString(1,profil.getProfilT_name());
            st.setString(2, profil.getProduct_Type());
            st.setInt(3, profil.getAgeClient());
            st.setString(4, profil.getSexClient());
            st.setInt(5, profil.getPurchaseVolume());
            st.executeUpdate();


        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Profil> read() throws Exception {


        Connection connect;
        PreparedStatement st;

        try {

            connect= Database.getConnection();
            String sql = "SELECT* FROM profil_type";
            st = connect.prepareStatement(sql);
            st.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Profil profil) throws Exception {

    }

    // update le profil du customer_account
    // id = id du customer account
    @Override
    public void update(Profil profil, int id) throws Exception {
    	Connection connect;
		PreparedStatement st;
		ResultSet rs;
		for (int i=0; i < 100; i++) {
			try {
				connect= Database.getConnection();
				String sql= "Update Customer_account set idProfil ="+profil.getNumProfil()+" where ID ="+id+" ; ";
				System.out.println(sql);
				st = connect.prepareStatement(sql);
				st.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}	
		}
    }

    @Override
    public Profil find(Profil profil) throws Exception {

        Connection connect;
        PreparedStatement st;
        ResultSet rs;

        try {

            connect= Database.getConnection();
            String sql= "SELECT* FROM profil_type WHERE nomProfil=?";
            st = connect.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                profil.setProfilT_id(rs.getInt("numProfil"));
                profil.setProfilT_name(rs.getString("nomProfil"));
                profil.setProduct_Type(rs.getString("typeProduit"));
                profil.setAgeClient(rs.getInt("ageClient"));
                profil.setSexClient(rs.getString("sexeClient"));
                profil.setPurchaseVolume(rs.getInt("volumeAchat"));
            }
            st.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

	@Override
	public void mockAchats() throws Exception {
		Connection connect;
		PreparedStatement st;
		ResultSet rs;
		for (int i=0; i < 200; i++) {
			try {
				connect= Database.getConnection();
				String sql= "Insert into CommandLine (idCommand,idProduct,qty) values ((FLOOR(RAND()*5)+1),(FLOOR(RAND()*5)+1),FLOOR(RAND()*10)+1); ";
				System.out.println(sql);
				st = connect.prepareStatement(sql);
				st.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}	
		}
	}

	@Override
	public void updateProfilClient(int idProfil, int idClient) throws Exception {
		Connection connect;
		PreparedStatement st;
		ResultSet rs;
		try {
			connect= Database.getConnection();
			String sql= "Update Customer_account set id_profil="+idProfil+" where ID="+idClient+" ";
			System.out.println(sql);
			st = connect.prepareStatement(sql);
			st.executeUpdate();
			connect.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}	
	}

	@Override
	public ArrayList<Customer_account> getProfilNull() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Customer_account> customer = new ArrayList<Customer_account>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select ID, id_profil,customer_sex from Customer_account where id_profil is null";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer_account c = new Customer_account();
				
				c.setId_customer(rs.getInt("ID"));
				c.setCustomer_sex(rs.getString("customer_sex"));
				c.setId_profil(rs.getInt("id_profil"));

				customer.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public ArrayList<Customer_account> getClientProfil() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Customer_account> customer = new ArrayList<Customer_account>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select ID, id_profil,customer_sex from Customer_account";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer_account c = new Customer_account();
				
				c.setId_customer(rs.getInt("ID"));
				c.setCustomer_sex(rs.getString("customer_sex"));
				c.setId_profil(rs.getInt("id_profil"));

				customer.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}
