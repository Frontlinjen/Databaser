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
	
	@Test //AnsatDTO
	public void testGetAnsat() throws DALException{
		AnsatDTO ansat = new AnsatDTO("1102990105", "Bob", "Bo", "fisken", 0);
		MySQLAnsatDAO ans = new MySQLAnsatDAO();
		ans.createAnsat(ansat);
		assertTrue
			("Succesful retrievel of the employee: ", 
					ans.getAnsat("1102990105").getOprNavn().equals("Bob") &&
					ans.getAnsat("1102990105").getIni().equals("Bo") &&
					ans.getAnsat("1102990105").getCpr().equals("1102990105") &&
					ans.getAnsat("1102990105").getTitel() == 0 &&
					ans.getAnsat("1102990105").getPassword().equals("fisken"));
	}
	
	@Test
	public void testCreateAnsat()throws DALException{
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		AnsatDTO ans = new AnsatDTO("1102990182", "Bob", "Bo", "fisken",0);
		ansDAO.createAnsat(ans);
		assertTrue
			("Succes creating the employee with the CPR: 1102990182, name: Bob, Initials: Bo, Password: fisken ", 
			ansDAO.getAnsat("1102990182").getOprNavn().equals("Bob") &&
			ansDAO.getAnsat("1102990182").getIni().equals("Bo") &&
			ansDAO.getAnsat("1102990182").getCpr().equals("1102990182") &&
			ansDAO.getAnsat("1102990182").getTitel() == 0 &&
			ansDAO.getAnsat("1102990182").getPassword().equals("fisken"));
	}
	
	@Test
	public void updateAnsat() throws DALException{
	AnsatDTO ans = new AnsatDTO("1102990101", "Tim", "Ti", "Tims",1);
	MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
	ansDAO.getAnsat("1102990101");
	ansDAO.updateAnsat(ans);
	assertFalse("Fail, the info are no longer applying to '1102990101' ", 
			ansDAO.getAnsat("1102990101").getOprNavn().equals("Bob") &&
			ansDAO.getAnsat("1102990101").getIni().equals("Bo") &&
			ansDAO.getAnsat("1102990101").getPassword().equals("fisken") &&
			ansDAO.getAnsat("1102990101").getTitel()==0);
	}

	@Test 
	public void getAnsatList() throws DALException{
		MySQLAnsatDAO ansatDAO = new MySQLAnsatDAO();
		assertFalse("Fail, the list is not empty: ", ansatDAO.getAnsatList()==null);
	}
	
}