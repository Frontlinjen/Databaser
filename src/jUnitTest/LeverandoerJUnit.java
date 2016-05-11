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
		LeverandoerDTO lev = new LeverandoerDTO(8,"Kikis",1.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		assertTrue(
				"The leverandoer with rv_id is Kikis: ",
				levDAO.getLeverandoer(8, "Kikis").getLeverandoerNavn().equals("Kikis") &&
				levDAO.getLeverandoer(8, "Kikis").getRaavareId()==8 &&
				levDAO.getLeverandoer(8, "Kikis").getMaengde()==1.0
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
		LeverandoerDTO lev = new LeverandoerDTO(10,"Kikis",1.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.createLeverandoer(lev);
		assertTrue(
				"The leverandoer with rv_id is Kikis: ",
				levDAO.getLeverandoer(10, "Kikis").getLeverandoerNavn().equals("Kikis") &&
				levDAO.getLeverandoer(10, "Kikis").getRaavareId()==10 &&
				levDAO.getLeverandoer(10, "Kikis").getMaengde()==1.0
		);
		
	}

	@Test
	public void testUpdateLeverandoer() throws DALException {
		LeverandoerDTO lev = new LeverandoerDTO(5,"Kikis",5.0);
		MySQLLeverandoerDAO levDAO = new MySQLLeverandoerDAO();
		levDAO.updateLeverandoer(lev);
		assertTrue(
				"The leverandoer Kikis, has been updated.",
				levDAO.getLeverandoer(5, "Kikis").getLeverandoerNavn().equals("Kikis") &&
				levDAO.getLeverandoer(5, "Kikis").getRaavareId()==5 &&
				levDAO.getLeverandoer(5, "Kikis").getMaengde()==5.0
		);
		
	}

}
