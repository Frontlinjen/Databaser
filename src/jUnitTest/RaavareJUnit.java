package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daointerfaces01917.DALException;
import dto01917.RaavareDTO;
import daoimpl01917.MySQLRaavareDAO;

public class RaavareJUnit {
	
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
	
	@Test //RaavareDTO Test
	public void getRaavare(){
		RaavareDTO raavare = new RaavareDTO(8, "apple");
		assertTrue("The raavare: apple, has ID: 8", raavare.getRaavareNavn().equals("apple") && raavare.getRaavareId()==8);
	}

	@Test //RaavareDAO Test
	public void testGetRaavare() throws DALException{
		RaavareDTO raavareDTO = new RaavareDTO(2, "tomat");
		MySQLRaavareDAO raavareDAO = new MySQLRaavareDAO();
		raavareDAO.updateRaavare(raavareDTO);
		assertTrue("The raavare with ID 2 is: ", raavareDAO.getRaavare(2).getRaavareId()==2 && raavareDAO.getRaavare(2).getRaavareNavn().equals("tomat"));
		
	}
	
	@Test
	public void testGetRaavareList() throws DALException{
		MySQLRaavareDAO raavareDAO = new MySQLRaavareDAO();
		assertFalse("Fail, the list is not empty: ", raavareDAO.getRaavareList()==null);
//		System.out.println(raavareDAO.getRaavareList());
	}
	
	@Test
	public void testUpdateRaavare() throws DALException{
		MySQLRaavareDAO raavareDAO = new MySQLRaavareDAO();
		RaavareDTO raavare = new RaavareDTO(1, "ikke dej");
		raavareDAO.getRaavare(1);
//		System.out.println(raavareDAO.getRaavare(1));
		raavareDAO.updateRaavare(raavare);
		assertFalse("Fail, the name is no longer tomat on ID 1 ", raavareDAO.getRaavare(1).getRaavareNavn().equals("dej"));
	}
	
	@Test
	public void testCreateRaavare() throws DALException{
		RaavareDTO raavare = new RaavareDTO(6, "fisk");
		MySQLRaavareDAO raavareDAO = new MySQLRaavareDAO();
		raavareDAO.createRaavare(raavare);
		assertTrue("Succes the raavare Fisk with ID 6 has been created ", raavareDAO.getRaavare(6).getRaavareId()==6 && raavareDAO.getRaavare(6).getRaavareNavn().equals("fisk"));
	}
	
	
}
