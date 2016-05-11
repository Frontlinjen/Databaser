package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLAnsatDAO;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.AnsatDTO;
import dto01917.RaavareDTO;

public class AnsatJUnit {

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
	public void testGetAnsat() throws DALException{
		AnsatDTO ansat = new AnsatDTO("1102990109", "Bob", "Bo", "fisken", 0);
		MySQLAnsatDAO ans = new MySQLAnsatDAO();
		ans.createAnsat(ansat);
		assertTrue
			("Succesful retrievel of the employee: ", 
					ans.getAnsat("1102990109").getOprNavn().equals("Bob") &&
					ans.getAnsat("1102990109").getIni().equals("Bo") &&
					ans.getAnsat("1102990109").getCpr().equals("1102990109") &&
					ans.getAnsat("1102990109").getTitel() == 0 &&
					ans.getAnsat("1102990109").getPassword().equals("fisken"));
	}
	
	@Test
	public void testCreateAnsat()throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("1102990185", "Bob", "Bo", "fisken",0);
		ansDAO.createAnsat(ans);
		assertTrue
			("Succes creating the employee with the CPR: 1102990185", 
			ansDAO.getAnsat("1102990185").getOprNavn().equals("Bob") &&
			ansDAO.getAnsat("1102990185").getIni().equals("Bo") &&
			ansDAO.getAnsat("1102990185").getCpr().equals("1102990185") &&
			ansDAO.getAnsat("1102990185").getTitel() == 0 &&
			ansDAO.getAnsat("1102990185").getPassword().equals("fisken"));
	}
	
	@Test
	public void updateAnsat() throws DALException{	
	AnsatDTO ans1 = new AnsatDTO("1102990185", "Tim", "Ti", "Tims",1);
	MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
	ansDAO.getAnsat("1102990185");
	ansDAO.updateAnsat(ans1);
	assertFalse("Fail, the info are no longer applying to '1102990185' ", 
			ansDAO.getAnsat("1102990185").getOprNavn().equals("Bob") &&
			ansDAO.getAnsat("1102990185").getIni().equals("Bo") &&
			ansDAO.getAnsat("1102990185").getPassword().equals("fisken") &&
			ansDAO.getAnsat("1102990185").getTitel()==0);
	}

	@Test 
	public void getAnsatList() throws DALException{
		MySQLAnsatDAO ansatDAO = new MySQLAnsatDAO();
		assertFalse("Fail, the list is not empty: ", ansatDAO.getAnsatList()==null);
	}
	
	@Test
	public void triggerTestVerifyPWShort() throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("11029901", "Bob", "Bo", "fisken",0);
		ansDAO.createAnsat(ans);
		fail("The employee couldn't be created due to too short CPR number.");
		
	}
	
	@Test
	public void triggerTestVerifyPWLong() throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("11029901999", "Bob", "Bo", "fisken",0);
		ansDAO.createAnsat(ans);
		fail("The employee couldn't be created due to too long CPR number.");

	}
	
	@Test
	public void triggerTestInsertIni() throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("1102990101", "Bob", "B", "fisken",0);
		ansDAO.createAnsat(ans);
		fail("The initials are too short.");
		
	}
	
	@Test
	public void triggerTestUpdateIni() throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("1102990111", "Bob", "Bo", "fisken",0);
		ansDAO.createAnsat(ans);
		AnsatDTO ans1 = new AnsatDTO("1102990111", "Bob", "B", "fisken",0);
		ansDAO.createAnsat(ans1);
		ansDAO.updateAnsat(ans1);
		fail("Could not update. The initials are too short.");
		
	}
	
	@Test
	public void triggerTestInsertTitel() throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("1102990111", "Bob", "Bo", "fisken",8);
		ansDAO.createAnsat(ans);
		fail("Could not create ansat. The Titel are not within the range of 0 and 3.");
	}
	
	@Test
	public void triggerTestInsertUpdate() throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("1102990112", "Bob", "Bo", "fisken",1);
		ansDAO.createAnsat(ans);
		AnsatDTO ans1 = new AnsatDTO("1102990112", "Bob", "Bo", "fisken",5);
		ansDAO.createAnsat(ans1);
		fail("Could not create ansat. The Titel are not within the range of 0 and 3.");
		
	}
}