package DAO.referentiels.profilsConsommateur;
import Entites.referentiels.profilsConsommateur.Profil;

import java.sql.*;
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
    return null;
    }

    @Override
    public void delete(Profil object) throws Exception {

    }

    @Override
    public void update(Profil object, int id) throws Exception {

    }

    @Override
    public Profil find(Profil object) throws Exception {
        return null;
    }
}
