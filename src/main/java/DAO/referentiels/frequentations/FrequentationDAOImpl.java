package DAO.referentiels.frequentations;
import DataBase.Database;
import Entites.referentiels.frequentations.Frequentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrequentationDAOImpl<Frequentation> implements FrequentationDAO{

    public void mockFrequentation() throws Exception {
        Connection connect;
        PreparedStatement st;
        ResultSet rs;

        for (int i=0; i<= 10000; i++) {

            connect = Database.getConnection();

            try {
                String sql = "INSERT INTO FrequentationMagasin (idFrequentation, idPortique, idClient, entryDate) values ((FLOOR(RAND()*25)), (FLOOR(RAND()*25)), (FLOOR(RAND()*25)), null);";
                System.out.println(sql);
                st = connect.prepareStatement(sql);
                st.executeUpdate();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }

}

