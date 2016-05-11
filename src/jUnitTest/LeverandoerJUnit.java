package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLLeverandoerDAO;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.LeverandoerDTO;
import dto01917.RaavareDTO;

public class LeverandoerJUnit {
	
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
	public void testGetLeverandoer() throws DALException {
		RaavareDTO ra = new RaavareDTO(9,"banan");
		MySQLRaavareDAO rD = new MySQLRaavareDAO();
		rD.createRaavare(ra);
		
		LeverandoerDTO lev = new LeverandoerDTO(9,"Akis",1.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		assertTrue(
				"The leverandoer with rv_id 8 is Aksi: ",
				levDAO.getLeverandoer(9, "Akis").getLeverandoerNavn().equals("Akis") &&
				levDAO.getLeverandoer(9, "Akis").getRaavareId()==9 &&
				levDAO.getLeverandoer(9, "Akis").getMaengde()==1.0
		);
	}

	@Test
	public void testGetLeverandoerList() throws DALException {
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		assertFalse(
				"Fail, the list is not empty: ", 
				levDAO.getLeverandoerList()==null
		);
	}

	@Test
	public void testCreateLeverandoer() throws DALException {
		LeverandoerDTO lev = new LeverandoerDTO(6,"Kokis",1.0);
		RaavareDTO ra = new RaavareDTO(6,"fisk");
		MySQLRaavareDAO rD = new MySQLRaavareDAO();
		rD.createRaavare(ra);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		assertTrue(
				"The leverandoer with rv_id is Kokis: ",
				levDAO.getLeverandoer(6, "Kokis").getLeverandoerNavn().equals("Kokis") &&
				levDAO.getLeverandoer(6, "Kokis").getRaavareId()==6 &&
				levDAO.getLeverandoer(6, "Kokis").getMaengde()==1.0
		);
		
	}

	@Test
	public void testUpdateLeverandoer() throws DALException {
		RaavareDTO ra = new RaavareDTO(8,"pære");
		MySQLRaavareDAO rD = new MySQLRaavareDAO();
		rD.createRaavare(ra);
		LeverandoerDTO lev = new LeverandoerDTO(8,"Kukus",8.0);
		LeverandoerDTO lev1 = new LeverandoerDTO(8,"Kukus",9.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		levDAO.updateLeverandoer(lev1);
		assertTrue(
				"The leverandoer Kukus, has been updated.",
				levDAO.getLeverandoer(8, "Kukus").getLeverandoerNavn().equals("Kukus") &&
				levDAO.getLeverandoer(8, "Kukus").getRaavareId()==8 &&
				levDAO.getLeverandoer(8, "Kukus").getMaengde()==9.0
		);
		
	}

}
