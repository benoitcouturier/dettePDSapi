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
			String sql = "Drop table EmplacementsMagasins IF EXISTS;\r\n" +
					"Drop table Emplacements IF EXISTS;\r\n" + 
					"Drop table Magasins IF EXISTS;\r\n" + 
					"Drop table TypeMagasin IF EXISTS;\r\n" + 
					
					 
					"\r\n" + 
					"CREATE TABLE Emplacements (\r\n" + 
					"id INT PRIMARY KEY AUTO_INCREMENT,\r\n" + 
					"superficie INT,\r\n" + 
					"aile VARCHAR(50),\r\n" + 
					"importance INT\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES \r\n" + 
					"(213,\"Purus Gravida Ltd\",5),\r\n" + 
					"(351,\"Lorem Donec Elementum Corp.\",6),\r\n" + 
					"(315,\"Ac Turpis Corporation\",8),\r\n" + 
					"(227,\"Leo Corporation\",1),\r\n" + 
					"(345,\"Dapibus Ligula Industries\",8),\r\n" + 
					"(259,\"Ipsum Leo Elementum Ltd\",10),\r\n" + 
					"(236,\"Laoreet Ltd\",3),\r\n" + 
					"(143,\"Dis Parturient Limited\",9),\r\n" + 
					"(163,\"Nulla Tempor Institute\",7),\r\n" + 
					"(184,\"Quisque Fringilla Foundation\",6);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES \r\n" + 
					"(108,\"Placerat Corp.\",4),\r\n" + 
					"(113,\"Duis Consulting\",3),\r\n" + 
					"(118,\"Turpis Corporation\",2),\r\n" + 
					"(126,\"Eleifend Nunc Foundation\",6),\r\n" + 
					"(313,\"Vel Lectus PC\",6),\r\n" + 
					"(176,\"Purus Corporation\",10),\r\n" + 
					"(188,\"Libero Consulting\",5),\r\n" + 
					"(221,\"Sed Dictum Industries\",2),\r\n" + 
					"(248,\"Luctus Ut LLP\",9),\r\n" + 
					"(373,\"Sociis Inc.\",6);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES \r\n" + 
					"(291,\"Vestibulum PC\",9),\r\n" + 
					"(250,\"Sagittis Lobortis Limited\",8),\r\n" + 
					"(205,\"Lacus Nulla LLC\",9),\r\n" + 
					"(394,\"Arcu Sed Incorporated\",2),\r\n" + 
					"(208,\"Quisque Imperdiet Industries\",10),\r\n" + 
					"(206,\"Nec Tempus Mauris Consulting\",3),\r\n" + 
					"(247,\"Et Netus Et Corp.\",5),\r\n" + 
					"(144,\"Dictum Eleifend Company\",3),\r\n" + 
					"(318,\"Eu Tellus Eu Associates\",10),\r\n" + 
					"(181,\"Non Dui Nec Corp.\",3);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES \r\n" + 
					"(163,\"Sit Amet Consectetuer PC\",8),\r\n" + 
					"(162,\"Natoque Ltd\",3),\r\n" + 
					"(358,\"Litora Torquent Inc.\",5),\r\n" + 
					"(193,\"Et Consulting\",3),\r\n" + 
					"(361,\"Augue Ut Lacus Institute\",9),\r\n" + 
					"(175,\"Cursus Foundation\",4),\r\n" + 
					"(320,\"Eu Lacus Ltd\",7),\r\n" + 
					"(367,\"Dui Lectus Consulting\",5),\r\n" + 
					"(308,\"Ligula Aenean Foundation\",8),\r\n" + 
					"(272,\"Nunc LLC\",10);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES \r\n" + 
					"(266,\"Parturient Industries\",9),\r\n" + 
					"(118,\"Fusce Aliquet Magna Industries\",4),\r\n" + 
					"(105,\"Sit Amet Risus LLP\",8),\r\n" + 
					"(181,\"Sem Institute\",8),\r\n" + 
					"(382,\"Mauris Non Ltd\",10),\r\n" + 
					"(359,\"Tincidunt Donec Vitae Institute\",7),\r\n" + 
					"(376,\"Luctus Aliquet Odio LLC\",1),\r\n" + 
					"(392,\"Nec LLC\",4),\r\n" + 
					"(203,\"Ante Lectus Incorporated\",7),\r\n" + 
					"(214,\"Augue Eu Tempor LLC\",3);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(157,\"Commodo Auctor Velit LLC\",1),\r\n" + 
					"(353,\"Arcu Ac Institute\",5),\r\n" + 
					"(188,\"Adipiscing Lacus Corporation\",9),\r\n" + 
					"(215,\"Interdum Sed Consulting\",6),\r\n" + 
					"(280,\"Integer Foundation\",9),\r\n" + 
					"(228,\"A Feugiat Tellus Consulting\",5),\r\n" + 
					"(262,\"Sem Limited\",9),\r\n" + 
					"(162,\"Proin Ltd\",7),\r\n" + 
					"(271,\"Turpis Aliquam Company\",8),\r\n" + 
					"(274,\"Non Lacinia Foundation\",10);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES \r\n" + 
					"(162,\"Cras Pellentesque PC\",4),\r\n" + 
					"(312,\"Velit Corporation\",2),\r\n" + 
					"(272,\"Cum Sociis Corporation\",1),\r\n" + 
					"(156,\"Massa Company\",2),\r\n" + 
					"(173,\"Feugiat Nec Diam Limited\",1),\r\n" + 
					"(309,\"Ullamcorper Inc.\",8),\r\n" + 
					"(371,\"Sapien Cursus LLC\",5),\r\n" + 
					"(268,\"Arcu Limited\",4),\r\n" + 
					"(327,\"Duis Limited\",7),\r\n" + 
					"(187,\"Blandit LLP\",3);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(388,\"Metus Aenean Ltd\",10),\r\n" + 
					"(242,\"Et Inc.\",5),\r\n" + 
					"(298,\"Fringilla Purus Corp.\",6),\r\n" + 
					"(179,\"Aliquet Corp.\",8),\r\n" + 
					"(299,\"Commodo Ipsum Foundation\",10),\r\n" + 
					"(135,\"Adipiscing Ltd\",2),\r\n" + 
					"(189,\"Arcu Sed Consulting\",9),\r\n" + 
					"(373,\"Nec Ante Limited\",9),\r\n" + 
					"(397,\"Aliquam LLP\",7),\r\n" + 
					"(190,\"Quisque Varius Inc.\",9);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(170,\"Id Ante PC\",9),\r\n" + 
					"(214,\"Phasellus Incorporated\",2),\r\n" + 
					"(155,\"Fusce Mollis Corporation\",1),\r\n" + 
					"(377,\"Nec Urna Corp.\",6),\r\n" + 
					"(130,\"Ut Eros Non PC\",1),\r\n" + 
					"(273,\"Blandit Nam Nulla Ltd\",5),\r\n" + 
					"(292,\"Eu Metus Foundation\",10),\r\n" + 
					"(300,\"Tellus Incorporated\",8),\r\n" + 
					"(212,\"Sodales Mauris Blandit PC\",10),\r\n" + 
					"(383,\"Erat Eget Ipsum LLP\",3);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(364,\"Donec Fringilla Donec PC\",2),\r\n" + 
					"(353,\"A Aliquet Vel Corporation\",2),\r\n" + 
					"(279,\"Velit LLP\",5),\r\n" + 
					"(393,\"Erat Etiam Inc.\",7),\r\n" + 
					"(158,\"Quisque Varius Industries\",3),\r\n" + 
					"(216,\"Ornare Company\",9),\r\n" + 
					"(337,\"Mauris Non Dui Foundation\",1),\r\n" + 
					"(378,\"Sed Leo Industries\",1),\r\n" + 
					"(142,\"Mattis Ornare LLC\",3),\r\n" + 
					"(137,\"Nulla Tincidunt Neque Ltd\",4);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(157,\"Commodo Auctor Velit LLC\",1),\r\n" + 
					"(353,\"Arcu Ac Institute\",5),\r\n" + 
					"(188,\"Adipiscing Lacus Corporation\",9),\r\n" + 
					"(215,\"Interdum Sed Consulting\",6),\r\n" + 
					"(280,\"Integer Foundation\",9),\r\n" + 
					"(228,\"A Feugiat Tellus Consulting\",5),\r\n" + 
					"(262,\"Sem Limited\",9),\r\n" + 
					"(162,\"Proin Ltd\",7),\r\n" + 
					"(271,\"Turpis Aliquam Company\",8),\r\n" + 
					"(274,\"Non Lacinia Foundation\",10);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES \r\n" + 
					"(162,\"Cras Pellentesque PC\",4),\r\n" + 
					"(312,\"Velit Corporation\",2),\r\n" + 
					"(272,\"Cum Sociis Corporation\",1),\r\n" + 
					"(156,\"Massa Company\",2),\r\n" + 
					"(173,\"Feugiat Nec Diam Limited\",1),\r\n" + 
					"(309,\"Ullamcorper Inc.\",8),\r\n" + 
					"(371,\"Sapien Cursus LLC\",5),\r\n" + 
					"(268,\"Arcu Limited\",4),\r\n" + 
					"(327,\"Duis Limited\",7),\r\n" + 
					"(187,\"Blandit LLP\",3);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(388,\"Metus Aenean Ltd\",10),\r\n" + 
					"(242,\"Et Inc.\",5),\r\n" + 
					"(298,\"Fringilla Purus Corp.\",6),\r\n" + 
					"(179,\"Aliquet Corp.\",8),\r\n" + 
					"(299,\"Commodo Ipsum Foundation\",10),\r\n" + 
					"(135,\"Adipiscing Ltd\",2),\r\n" + 
					"(189,\"Arcu Sed Consulting\",9),\r\n" + 
					"(373,\"Nec Ante Limited\",9),\r\n" + 
					"(397,\"Aliquam LLP\",7),\r\n" + 
					"(190,\"Quisque Varius Inc.\",9);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(170,\"Id Ante PC\",9),\r\n" + 
					"(214,\"Phasellus Incorporated\",2),\r\n" + 
					"(155,\"Fusce Mollis Corporation\",1),\r\n" + 
					"(377,\"Nec Urna Corp.\",6),\r\n" + 
					"(130,\"Ut Eros Non PC\",1),\r\n" + 
					"(273,\"Blandit Nam Nulla Ltd\",5),\r\n" + 
					"(292,\"Eu Metus Foundation\",10),\r\n" + 
					"(300,\"Tellus Incorporated\",8),\r\n" + 
					"(212,\"Sodales Mauris Blandit PC\",10),\r\n" + 
					"(383,\"Erat Eget Ipsum LLP\",3);\r\n" + 
					"\r\n" + 
					"INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES\r\n" + 
					"(364,\"Donec Fringilla Donec PC\",2),\r\n" + 
					"(353,\"A Aliquet Vel Corporation\",2),\r\n" + 
					"(279,\"Velit LLP\",5),\r\n" + 
					"(393,\"Erat Etiam Inc.\",7),\r\n" + 
					"(158,\"Quisque Varius Industries\",3),\r\n" + 
					"(216,\"Ornare Company\",9),\r\n" + 
					"(337,\"Mauris Non Dui Foundation\",1),\r\n" + 
					"(378,\"Sed Leo Industries\",1),\r\n" + 
					"(142,\"Mattis Ornare LLC\",3),\r\n" + 
					"(137,\"Nulla Tincidunt Neque Ltd\",4);\r\n" + 
					"\r\n" + 
					"CREATE TABLE TypeMagasin (\r\n" + 
					"id INT PRIMARY KEY AUTO_INCREMENT,\r\n" + 
					"type varchar(50)\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"CREATE TABLE Magasins (\r\n" + 
					"INT id PRIMARY KEY AUTO_INCREMENT,\r\n" + 
					"nom VARCHAR(50),\r\n" + 
					"description VARCHAR(250),\r\n" + 
					"idEmplacement int,\r\n" + 
					"idType int,\r\n" + 
					"FOREIGN KEY (idType) REFERENCES TypeMagasin(id)\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"CREATE TABLE EmplacementMagasin (\r\n" + 
					"id INT PRIMARY KEY AUTO_INCREMENT,\r\n" + 
					"idEmplacement INT,\r\n" + 
					"FOREIGN KEY (idEmplacement) REFERENCES Emplacements(id)\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"";
			
			ps = connect.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
