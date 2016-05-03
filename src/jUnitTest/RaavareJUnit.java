package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import dto01917.RaavareDTO;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import daoimpl01917.MySQLRaavareDAO;

public class RaavareJUnit {
	
	//RaavareDTO Test
	@Before
	 public void initialize() {
		try {
			new Connector();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getRaavare(){
		RaavareDTO raavare = new RaavareDTO(8, "apple");
		assertTrue("The raavare: apple, has ID: 8", raavare.getRaavareNavn().equals("apple") && raavare.getRaavareId()==8);
	}

	//RaavareDAO Test
	@Test
	public void testGetRaavare() throws DALException{
		RaavareDTO raavareDTO = new RaavareDTO(7, "tomat");
		MySQLRaavareDAO raavareDAO = new MySQLRaavareDAO();
		raavareDAO.updateRaavare(raavareDTO);
		assertTrue("The raavare with ID 2 is: ", raavareDAO.getRaavare(2).getRaavareId()==2 && raavareDAO.getRaavare(2).getRaavareNavn().equals("tomat"));
		
	}
}
