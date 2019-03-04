package DAO.referentiels.profilsConsommateur;
import DataBase.Database;
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

    @Override
    public void update(Profil profil, int id) throws Exception {

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
	public void mockUser() throws Exception {
		Connection connect;
        PreparedStatement st;
        ResultSet rs;

        for(int i =0; i< 100; i++) {
            try {

                connect= Database.getConnection();
                String sql= "Insert into Client values (NULL,'client_"+i+"');";
                st = connect.prepareStatement(sql);
                st.executeUpdate();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
	}

}
