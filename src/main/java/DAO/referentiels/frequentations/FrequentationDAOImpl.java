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

        connect = Database.getConnection();
        for (int i=0; i<= 10000; i++) {

            PreparedStatement st;
            ResultSet rs;


            try {
                String sql = "INSERT INTO FrequentationMagasin (idFrequentation, idMagasin, idClient, dateEntree) values (null, (FLOOR(RAND()*25)), (FLOOR(RAND()*25)), (SELECT FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP() - UNIX_TIMESTAMP('2019-03-15')) + UNIX_TIMESTAMP('2019-03-15'))));";
                System.out.println(sql);
                st = connect.prepareStatement(sql);
                st.executeUpdate();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }

}

