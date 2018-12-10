package trueTest.TU.Magasins;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.junit.Test;

import RestGT.referentiels.magasins.MagasinControlleur;


public class MagasinTest {

	
	@Test
	public void test() {

		Response r;

		MagasinControlleur magCon = new MagasinControlleur();
		r = magCon.rechercherMagasin(1);
		assertEquals(200,r.getStatus());
		r = magCon.rechercherMagasin(11000);
		assertEquals(500,r.getStatus());
		
	}
}
