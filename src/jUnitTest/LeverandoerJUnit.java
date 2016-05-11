package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLLeverandoerDAO;
import daointerfaces01917.DALException;
import dto01917.LeverandoerDTO;

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
		LeverandoerDTO lev = new LeverandoerDTO(20,"Kakis",1.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		assertTrue(
				"The leverandoer with rv_id is Kaks: ",
				levDAO.getLeverandoer(20, "Kakis").getLeverandoerNavn().equals("Kakis") &&
				levDAO.getLeverandoer(20, "Kakis").getRaavareId()==20 &&
				levDAO.getLeverandoer(20, "Kakis").getMaengde()==1.0
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
		LeverandoerDTO lev = new LeverandoerDTO(14,"Kokis",1.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		assertTrue(
				"The leverandoer with rv_id is Kokis: ",
				levDAO.getLeverandoer(14, "Kokis").getLeverandoerNavn().equals("Kokis") &&
				levDAO.getLeverandoer(14, "Kokis").getRaavareId()==14 &&
				levDAO.getLeverandoer(14, "Kokis").getMaengde()==1.0
		);
		
	}

	@Test
	public void testUpdateLeverandoer() throws DALException {
		LeverandoerDTO lev = new LeverandoerDTO(16,"Kukus",8.0);
		LeverandoerDTO lev1 = new LeverandoerDTO(16,"Kukus",9.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		levDAO.updateLeverandoer(lev1);
		assertTrue(
				"The leverandoer Kikis, has been updated.",
				levDAO.getLeverandoer(16, "Kukus").getLeverandoerNavn().equals("Kukus") &&
				levDAO.getLeverandoer(16, "Kukus").getRaavareId()==16 &&
				levDAO.getLeverandoer(16, "Kukus").getMaengde()==9.0
		);
		
	}

}
