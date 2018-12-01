package DAO.referentiels.magasins;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entites.referentiels.magasins.Magasin;
import DAO.referentiels.magasins.MagasinsDAO;
import DataBase.Database;

public class MagasinDAOImpl implements MagasinsDAO<Magasin> {

	@Override
	public void create(Magasin object) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "INSERT INTO Magasins VALUES (?,?,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(i++,object.getNom());
			ps.setString(i++,object.getDescription());
			ps.setInt(i++,object.getIdEmplacement());
			ps.setInt(i++,object.getIdType());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Magasin> read() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Magasin> magasins = new ArrayList<Magasin>();
		try {
			int i =1;
			connect = Database.getConnection();
			String sql = "Select * from Magasins";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Magasin m = new Magasin();
				m.setDescription(rs.getString("description"));
				m.setId(rs.getInt("id"));
				m.setIdEmplacement(rs.getInt("idEmplacement"));
				m.setIdType(rs.getInt("idType"));
				m.setNom(rs.getString("nom"));

				magasins.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magasins;
	}

	@Override
	public void delete(Magasin object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Magasin object, int id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Magasin find(Magasin object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creationUC() throws Exception {
		Connection connect;
		PreparedStatement ps ;
		try {
			int i =1;
			connect = Database.getConnection();
			String sql =
					"CREATE TABLE Emplacements (\n" + 
					"id INT PRIMARY KEY AUTO_INCREMENT,\n" + 
					"superficie INT,\n" + 
					"aile VARCHAR(50),\n" + 
					"importance INT\n" + 
					");\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES \n" + 
					"(213,'Purus Gravida Ltd',5),\n" + 
					"(351,'Lorem Donec Elementum Corp.',6),\n" + 
					"(315,'Ac Turpis Corporation',8),\n" + 
					"(227,'Leo Corporation',1),\n" + 
					"(345,'Dapibus Ligula Industries',8),\n" + 
					"(259,'Ipsum Leo Elementum Ltd',10),\n" + 
					"(236,'Laoreet Ltd',3),\n" + 
					"(143,'Dis Parturient Limited',9),\n" + 
					"(163,'Nulla Tempor Institute',7),\n" + 
					"(184,'Quisque Fringilla Foundation',6);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES \n" + 
					"(108,'Placerat Corp.',4),\n" + 
					"(113,'Duis Consulting',3),\n" + 
					"(118,'Turpis Corporation',2),\n" + 
					"(126,'Eleifend Nunc Foundation',6),\n" + 
					"(313,'Vel Lectus PC',6),\n" + 
					"(176,'Purus Corporation',10),\n" + 
					"(188,'Libero Consulting',5),\n" + 
					"(221,'Sed Dictum Industries',2),\n" + 
					"(248,'Luctus Ut LLP',9),\n" + 
					"(373,'Sociis Inc.',6);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES \n" + 
					"(291,'Vestibulum PC',9),\n" + 
					"(250,'Sagittis Lobortis Limited',8),\n" + 
					"(205,'Lacus Nulla LLC',9),\n" + 
					"(394,'Arcu Sed Incorporated',2),\n" + 
					"(208,'Quisque Imperdiet Industries',10),\n" + 
					"(206,'Nec Tempus Mauris Consulting',3),\n" + 
					"(247,'Et Netus Et Corp.',5),\n" + 
					"(144,'Dictum Eleifend Company',3),\n" + 
					"(318,'Eu Tellus Eu Associates',10),\n" + 
					"(181,'Non Dui Nec Corp.',3);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES \n" + 
					"(163,'Sit Amet Consectetuer PC',8),\n" + 
					"(162,'Natoque Ltd',3),\n" + 
					"(358,'Litora Torquent Inc.',5),\n" + 
					"(193,'Et Consulting',3),\n" + 
					"(361,'Augue Ut Lacus Institute',9),\n" + 
					"(175,'Cursus Foundation',4),\n" + 
					"(320,'Eu Lacus Ltd',7),\n" + 
					"(367,'Dui Lectus Consulting',5),\n" + 
					"(308,'Ligula Aenean Foundation',8),\n" + 
					"(272,'Nunc LLC',10);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES \n" + 
					"(266,'Parturient Industries',9),\n" + 
					"(118,'Fusce Aliquet Magna Industries',4),\n" + 
					"(105,'Sit Amet Risus LLP',8),\n" + 
					"(181,'Sem Institute',8),\n" + 
					"(382,'Mauris Non Ltd',10),\n" + 
					"(359,'Tincidunt Donec Vitae Institute',7),\n" + 
					"(376,'Luctus Aliquet Odio LLC',1),\n" + 
					"(392,'Nec LLC',4),\n" + 
					"(203,'Ante Lectus Incorporated',7),\n" + 
					"(214,'Augue Eu Tempor LLC',3);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(157,'Commodo Auctor Velit LLC',1),\n" + 
					"(353,'Arcu Ac Institute',5),\n" + 
					"(188,'Adipiscing Lacus Corporation',9),\n" + 
					"(215,'Interdum Sed Consulting',6),\n" + 
					"(280,'Integer Foundation',9),\n" + 
					"(228,'A Feugiat Tellus Consulting',5),\n" + 
					"(262,'Sem Limited',9),\n" + 
					"(162,'Proin Ltd',7),\n" + 
					"(271,'Turpis Aliquam Company',8),\n" + 
					"(274,'Non Lacinia Foundation',10);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES \n" + 
					"(162,'Cras Pellentesque PC',4),\n" + 
					"(312,'Velit Corporation',2),\n" + 
					"(272,'Cum Sociis Corporation',1),\n" + 
					"(156,'Massa Company',2),\n" + 
					"(173,'Feugiat Nec Diam Limited',1),\n" + 
					"(309,'Ullamcorper Inc.',8),\n" + 
					"(371,'Sapien Cursus LLC',5),\n" + 
					"(268,'Arcu Limited',4),\n" + 
					"(327,'Duis Limited',7),\n" + 
					"(187,'Blandit LLP',3);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(388,'Metus Aenean Ltd',10),\n" + 
					"(242,'Et Inc.',5),\n" + 
					"(298,'Fringilla Purus Corp.',6),\n" + 
					"(179,'Aliquet Corp.',8),\n" + 
					"(299,'Commodo Ipsum Foundation',10),\n" + 
					"(135,'Adipiscing Ltd',2),\n" + 
					"(189,'Arcu Sed Consulting',9),\n" + 
					"(373,'Nec Ante Limited',9),\n" + 
					"(397,'Aliquam LLP',7),\n" + 
					"(190,'Quisque Varius Inc.',9);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(170,'Id Ante PC',9),\n" + 
					"(214,'Phasellus Incorporated',2),\n" + 
					"(155,'Fusce Mollis Corporation',1),\n" + 
					"(377,'Nec Urna Corp.',6),\n" + 
					"(130,'Ut Eros Non PC',1),\n" + 
					"(273,'Blandit Nam Nulla Ltd',5),\n" + 
					"(292,'Eu Metus Foundation',10),\n" + 
					"(300,'Tellus Incorporated',8),\n" + 
					"(212,'Sodales Mauris Blandit PC',10),\n" + 
					"(383,'Erat Eget Ipsum LLP',3);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(364,'Donec Fringilla Donec PC',2),\n" + 
					"(353,'A Aliquet Vel Corporation',2),\n" + 
					"(279,'Velit LLP',5),\n" + 
					"(393,'Erat Etiam Inc.',7),\n" + 
					"(158,'Quisque Varius Industries',3),\n" + 
					"(216,'Ornare Company',9),\n" + 
					"(337,'Mauris Non Dui Foundation',1),\n" + 
					"(378,'Sed Leo Industries',1),\n" + 
					"(142,'Mattis Ornare LLC',3),\n" + 
					"(137,'Nulla Tincidunt Neque Ltd',4);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(157,'Commodo Auctor Velit LLC',1),\n" + 
					"(353,'Arcu Ac Institute',5),\n" + 
					"(188,'Adipiscing Lacus Corporation',9),\n" + 
					"(215,'Interdum Sed Consulting',6),\n" + 
					"(280,'Integer Foundation',9),\n" + 
					"(228,'A Feugiat Tellus Consulting',5),\n" + 
					"(262,'Sem Limited',9),\n" + 
					"(162,'Proin Ltd',7),\n" + 
					"(271,'Turpis Aliquam Company',8),\n" + 
					"(274,'Non Lacinia Foundation',10);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES \n" + 
					"(162,'Cras Pellentesque PC',4),\n" + 
					"(312,'Velit Corporation',2),\n" + 
					"(272,'Cum Sociis Corporation',1),\n" + 
					"(156,'Massa Company',2),\n" + 
					"(173,'Feugiat Nec Diam Limited',1),\n" + 
					"(309,'Ullamcorper Inc.',8),\n" + 
					"(371,'Sapien Cursus LLC',5),\n" + 
					"(268,'Arcu Limited',4),\n" + 
					"(327,'Duis Limited',7),\n" + 
					"(187,'Blandit LLP',3);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(388,'Metus Aenean Ltd',10),\n" + 
					"(242,'Et Inc.',5),\n" + 
					"(298,'Fringilla Purus Corp.',6),\n" + 
					"(179,'Aliquet Corp.',8),\n" + 
					"(299,'Commodo Ipsum Foundation',10),\n" + 
					"(135,'Adipiscing Ltd',2),\n" + 
					"(189,'Arcu Sed Consulting',9),\n" + 
					"(373,'Nec Ante Limited',9),\n" + 
					"(397,'Aliquam LLP',7),\n" + 
					"(190,'Quisque Varius Inc.',9);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(170,'Id Ante PC',9),\n" + 
					"(214,'Phasellus Incorporated',2),\n" + 
					"(155,'Fusce Mollis Corporation',1),\n" + 
					"(377,'Nec Urna Corp.',6),\n" + 
					"(130,'Ut Eros Non PC',1),\n" + 
					"(273,'Blandit Nam Nulla Ltd',5),\n" + 
					"(292,'Eu Metus Foundation',10),\n" + 
					"(300,'Tellus Incorporated',8),\n" + 
					"(212,'Sodales Mauris Blandit PC',10),\n" + 
					"(383,'Erat Eget Ipsum LLP',3);\n" + 
					"\n" + 
					"INSERT INTO Emplacements  VALUES\n" + 
					"(364,'Donec Fringilla Donec PC',2),\n" + 
					"(353,'A Aliquet Vel Corporation',2),\n" + 
					"(279,'Velit LLP',5),\n" + 
					"(393,'Erat Etiam Inc.',7),\n" + 
					"(158,'Quisque Varius Industries',3),\n" + 
					"(216,'Ornare Company',9),\n" + 
					"(337,'Mauris Non Dui Foundation',1),\n" + 
					"(378,'Sed Leo Industries',1),\n" + 
					"(142,'Mattis Ornare LLC',3),\n" + 
					"(137,'Nulla Tincidunt Neque Ltd',4);\n" + 
					"\n" + 
					"CREATE TABLE TypeMagasin (\n" + 
					"id INT PRIMARY KEY AUTO_INCREMENT,\n" + 
					"type varchar(50)\n" + 
					");\n" + 
					"\n" + 
					"CREATE TABLE Magasins (\n" + 
					"INT id PRIMARY KEY AUTO_INCREMENT,\n" + 
					"nom VARCHAR(50),\n" + 
					"description VARCHAR(250),\n" + 
					"idEmplacement int,\n" + 
					"idType int,\n" + 
					"FOREIGN KEY (idType) REFERENCES TypeMagasin(id)\n" + 
					");\n" + 
					"\n" + 
					"CREATE TABLE EmplacementMagasin (\n" + 
					"id INT PRIMARY KEY AUTO_INCREMENT,\n" + 
					"idEmplacement INT,\n" + 
					"FOREIGN KEY (idEmplacement) REFERENCES Emplacements(id)\n" + 
					");\n" + 
					"\n" + 
					"";
			
			ps = connect.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
