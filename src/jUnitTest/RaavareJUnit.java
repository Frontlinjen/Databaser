package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import dto01917.RaavareDTO;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import daoimpl01917.MySQLRaavareDAO;

public class RaavareJUnit {
	
	//RaavareDTO Test
	
	@Test
	public void getRaavare(){
		RaavareDTO raavare = new RaavareDTO(2, "tomat");
		assertTrue("The raavare: apple, has ID: 8", raavare.getRaavareNavn()=="apple" && raavare.getRaavareId()==8);
	}

	//RaavareDAO Test
	@Test
	public void testGetRaavare() throws DALException{
		MySQLRaavareDAO raavare = new MySQLRaavareDAO();
		raavare.createRaavare(new RaavareDTO(2, "tomat"));
		System.out.println(raavare.getRaavareList());
		raavare.getRaavare(2);
		assertTrue("The raavare with ID 2 is: ", raavare.getRaavare(2).getRaavareId()==2 && raavare.getRaavare(2).getRaavareNavn()=="tomat");
		
	}
}
