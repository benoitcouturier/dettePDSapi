package trueTest.TU.Magasins;

import java.util.ArrayList;

import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;

public class MagasinDAOStub implements MagasinsDAO<Magasin> {

	@Override
	public boolean existType(int id) throws Exception {
		
		if(id<5) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Magasin> rechercheType(Magasin m)  throws Exception  {
		// TODO Auto-generated method stub
		if(m.getIdType()==9) {
			throw new Exception();
		}
		if(m.getIdType()>6) {
			ArrayList<Magasin> array = new ArrayList<Magasin>();
			array.add(new Magasin());
			return array;
		}
		return new ArrayList<Magasin>();
	}

	@Override
	public ArrayList<Magasin> rechercheNom(Magasin m) throws Exception {
		// TODO Auto-generated method stub
		if(m.getNom().equalsIgnoreCase("oui")) {
			ArrayList<Magasin> array = new ArrayList<Magasin>();
			array.add(new Magasin());
			return array;
		}
		if(m.getNom().equalsIgnoreCase("exception")) {
			throw new Exception();
		}
		return new ArrayList<Magasin>();
	}

	@Override
	public void create(Magasin object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Magasin> read() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	public Magasin selectMax() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
