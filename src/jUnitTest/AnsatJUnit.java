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
	public void testAnsatDTO(){
		AnsatDTO ans = new AnsatDTO("1102990101", "Bob", "Bo", "fisken", 0);
		assertTrue
			("Succesful retrievel of all information: ", ans.getCpr().equals("1102990101") 
			&& ans.getOprNavn().equals("Bob") && ans.getIni().equals("Bo") 
			&& ans.getPassword().equals("fisken") && ans.getTitel()==0);
	}
	
	@Test
	public void testCreateAnsat()throws DALException{
		AnsatDTO ansa = new AnsatDTO("1102990101", "Bob", "Bo", "fisken",0);
		MySQLAnsatDAO ansDAO = new MySQLAnsatDAO();
		ansDAO.createAnsat(ansa);
		assertTrue
			("Succes the employee with the CPR 1102990101 is Bob ", 
			ansDAO.getAnsat("1102990101").getOprNavn().equals("Bob") &&
			ansDAO.getAnsat("1102990101").getIni().equals("Bo"));
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
		
	
}
//this.cpr = ans.getCpr();
//this.oprNavn = ans.getOprNavn();
//this.ini = ans.getIni();
//this.password = ans.getPassword();
//this.titel = ans.getTitel();