Drop table Emplacements;
Drop table TypeMagasin;
Drop table Magasins;
Drop table EmplacementsMagasins;

CREATE TABLE Emplacements (
id INT PRIMARY KEY AUTO_INCREMENT,
superficie INT,
aile VARCHAR(50),
importance INT
);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES 
(213,"Purus Gravida Ltd",5),
(351,"Lorem Donec Elementum Corp.",6),
(315,"Ac Turpis Corporation",8),
(227,"Leo Corporation",1),
(345,"Dapibus Ligula Industries",8),
(259,"Ipsum Leo Elementum Ltd",10),
(236,"Laoreet Ltd",3),
(143,"Dis Parturient Limited",9),
(163,"Nulla Tempor Institute",7),
(184,"Quisque Fringilla Foundation",6);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES 
(108,"Placerat Corp.",4),
(113,"Duis Consulting",3),
(118,"Turpis Corporation",2),
(126,"Eleifend Nunc Foundation",6),
(313,"Vel Lectus PC",6),
(176,"Purus Corporation",10),
(188,"Libero Consulting",5),
(221,"Sed Dictum Industries",2),
(248,"Luctus Ut LLP",9),
(373,"Sociis Inc.",6);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES 
(291,"Vestibulum PC",9),
(250,"Sagittis Lobortis Limited",8),
(205,"Lacus Nulla LLC",9),
(394,"Arcu Sed Incorporated",2),
(208,"Quisque Imperdiet Industries",10),
(206,"Nec Tempus Mauris Consulting",3),
(247,"Et Netus Et Corp.",5),
(144,"Dictum Eleifend Company",3),
(318,"Eu Tellus Eu Associates",10),
(181,"Non Dui Nec Corp.",3);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES 
(163,"Sit Amet Consectetuer PC",8),
(162,"Natoque Ltd",3),
(358,"Litora Torquent Inc.",5),
(193,"Et Consulting",3),
(361,"Augue Ut Lacus Institute",9),
(175,"Cursus Foundation",4),
(320,"Eu Lacus Ltd",7),
(367,"Dui Lectus Consulting",5),
(308,"Ligula Aenean Foundation",8),
(272,"Nunc LLC",10);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES 
(266,"Parturient Industries",9),
(118,"Fusce Aliquet Magna Industries",4),
(105,"Sit Amet Risus LLP",8),
(181,"Sem Institute",8),
(382,"Mauris Non Ltd",10),
(359,"Tincidunt Donec Vitae Institute",7),
(376,"Luctus Aliquet Odio LLC",1),
(392,"Nec LLC",4),
(203,"Ante Lectus Incorporated",7),
(214,"Augue Eu Tempor LLC",3);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(157,"Commodo Auctor Velit LLC",1),
(353,"Arcu Ac Institute",5),
(188,"Adipiscing Lacus Corporation",9),
(215,"Interdum Sed Consulting",6),
(280,"Integer Foundation",9),
(228,"A Feugiat Tellus Consulting",5),
(262,"Sem Limited",9),
(162,"Proin Ltd",7),
(271,"Turpis Aliquam Company",8),
(274,"Non Lacinia Foundation",10);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES 
(162,"Cras Pellentesque PC",4),
(312,"Velit Corporation",2),
(272,"Cum Sociis Corporation",1),
(156,"Massa Company",2),
(173,"Feugiat Nec Diam Limited",1),
(309,"Ullamcorper Inc.",8),
(371,"Sapien Cursus LLC",5),
(268,"Arcu Limited",4),
(327,"Duis Limited",7),
(187,"Blandit LLP",3);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(388,"Metus Aenean Ltd",10),
(242,"Et Inc.",5),
(298,"Fringilla Purus Corp.",6),
(179,"Aliquet Corp.",8),
(299,"Commodo Ipsum Foundation",10),
(135,"Adipiscing Ltd",2),
(189,"Arcu Sed Consulting",9),
(373,"Nec Ante Limited",9),
(397,"Aliquam LLP",7),
(190,"Quisque Varius Inc.",9);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(170,"Id Ante PC",9),
(214,"Phasellus Incorporated",2),
(155,"Fusce Mollis Corporation",1),
(377,"Nec Urna Corp.",6),
(130,"Ut Eros Non PC",1),
(273,"Blandit Nam Nulla Ltd",5),
(292,"Eu Metus Foundation",10),
(300,"Tellus Incorporated",8),
(212,"Sodales Mauris Blandit PC",10),
(383,"Erat Eget Ipsum LLP",3);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(364,"Donec Fringilla Donec PC",2),
(353,"A Aliquet Vel Corporation",2),
(279,"Velit LLP",5),
(393,"Erat Etiam Inc.",7),
(158,"Quisque Varius Industries",3),
(216,"Ornare Company",9),
(337,"Mauris Non Dui Foundation",1),
(378,"Sed Leo Industries",1),
(142,"Mattis Ornare LLC",3),
(137,"Nulla Tincidunt Neque Ltd",4);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(157,"Commodo Auctor Velit LLC",1),
(353,"Arcu Ac Institute",5),
(188,"Adipiscing Lacus Corporation",9),
(215,"Interdum Sed Consulting",6),
(280,"Integer Foundation",9),
(228,"A Feugiat Tellus Consulting",5),
(262,"Sem Limited",9),
(162,"Proin Ltd",7),
(271,"Turpis Aliquam Company",8),
(274,"Non Lacinia Foundation",10);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES 
(162,"Cras Pellentesque PC",4),
(312,"Velit Corporation",2),
(272,"Cum Sociis Corporation",1),
(156,"Massa Company",2),
(173,"Feugiat Nec Diam Limited",1),
(309,"Ullamcorper Inc.",8),
(371,"Sapien Cursus LLC",5),
(268,"Arcu Limited",4),
(327,"Duis Limited",7),
(187,"Blandit LLP",3);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(388,"Metus Aenean Ltd",10),
(242,"Et Inc.",5),
(298,"Fringilla Purus Corp.",6),
(179,"Aliquet Corp.",8),
(299,"Commodo Ipsum Foundation",10),
(135,"Adipiscing Ltd",2),
(189,"Arcu Sed Consulting",9),
(373,"Nec Ante Limited",9),
(397,"Aliquam LLP",7),
(190,"Quisque Varius Inc.",9);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(170,"Id Ante PC",9),
(214,"Phasellus Incorporated",2),
(155,"Fusce Mollis Corporation",1),
(377,"Nec Urna Corp.",6),
(130,"Ut Eros Non PC",1),
(273,"Blandit Nam Nulla Ltd",5),
(292,"Eu Metus Foundation",10),
(300,"Tellus Incorporated",8),
(212,"Sodales Mauris Blandit PC",10),
(383,"Erat Eget Ipsum LLP",3);

INSERT INTO `Emplacements` (`superficie`,`aile`,`importance`) VALUES
(364,"Donec Fringilla Donec PC",2),
(353,"A Aliquet Vel Corporation",2),
(279,"Velit LLP",5),
(393,"Erat Etiam Inc.",7),
(158,"Quisque Varius Industries",3),
(216,"Ornare Company",9),
(337,"Mauris Non Dui Foundation",1),
(378,"Sed Leo Industries",1),
(142,"Mattis Ornare LLC",3),
(137,"Nulla Tincidunt Neque Ltd",4);

CREATE TABLE TypeMagasin (
id INT PRIMARY KEY AUTO_INCREMENT,
type varchar(50)
);

CREATE TABLE Magasins (
INT id PRIMARY KEY AUTO_INCREMENT,
nom VARCHAR(50),
description VARCHAR(250),
idEmplacement int,
idType int,
FOREIGN KEY (idType) REFERENCES TypeMagasin(id)
);

CREATE TABLE EmplacementMagasin (
id INT PRIMARY KEY AUTO_INCREMENT,
idEmplacement INT,
FOREIGN KEY (idEmplacement) REFERENCES Emplacements(id)
);

