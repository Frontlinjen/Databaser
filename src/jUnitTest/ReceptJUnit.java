package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLRecept;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;

public class ReceptJUnit {
	
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
	public void testGetRecept() throws DALException {
		ReceptDTO r = new ReceptDTO(4,"pine");
		MySQLRecept rD = new MySQLRecept();
		rD.createRecept(r);
		assertTrue(
				"Succesfully retrieved Recept",
				rD.getRecept(4).getReceptId()==4 &&
				rD.getRecept(4).getReceptNavn().equals("pine")
			);
	}

	@Test
	public void testGetReceptList() throws DALException {
		MySQLRecept rD = new MySQLRecept();
		assertTrue(
				"The list does have content",
				rD.getReceptList()!=null
			);
	}

	@Test
	public void testCreateRecept() throws DALException {
		ReceptDTO r = new ReceptDTO(11,"pineapple");
		MySQLRecept rD = new MySQLRecept();
		rD.createRecept(r);
		assertTrue(
				"Succesfully created Recept",
				rD.getRecept(11).getReceptId()==11 &&
				rD.getRecept(11).getReceptNavn().equals("pineapple")
			);	
	}

	@Test
	public void testUpdateRecept() throws DALException {
		ReceptDTO r = new ReceptDTO(8,"corn");
		ReceptDTO r1 = new ReceptDTO(8,"cron");
		MySQLRecept rD = new MySQLRecept();
		rD.createRecept(r);
		rD.updateRecept(r1);
		assertTrue(
				"Succesfully updated Recept",
				rD.getRecept(8).getReceptId()==8 &&
				rD.getRecept(8).getReceptNavn().equals("cron")
			);	

	}
}
