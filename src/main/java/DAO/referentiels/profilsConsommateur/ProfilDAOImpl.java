package DAO.referentiels.profilsConsommateur;
import DataBase.Database;
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
            String sql = "INSERT INTO Profil_type VALUES(?,?,?,?,?,?)";
            st = connect.prepareStatement(sql);
            st.setInt(1,profil.getProfilT_id());
            st.setString(2,profil.getProfilT_name());
            st.setString(3, profil.getProduct_Type());
            st.setInt(4, profil.getAgeClient());
            st.setString(5, profil.getSexClient());
            st.setInt(6, profil.getVolumeAchat());
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
