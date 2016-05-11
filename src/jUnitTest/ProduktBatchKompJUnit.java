package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLAnsatDAO;
import daoimpl01917.MySQLProduktBatchKomp;
import daoimpl01917.MySQLProduktbatch;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.AnsatDTO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareDTO;

public class ProduktBatchKompJUnit {
	
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
	public void testGetProduktBatchKomp() throws DALException {
		AnsatDTO ansat = new AnsatDTO("1102990225", "Bob", "Bo", "fisken", 0);
		MySQLAnsatDAO ans = new MySQLAnsatDAO();
		ans.createAnsat(ansat);
		
		RaavareDTO raavareDTO = new RaavareDTO(21, "tomat");
		MySQLRaavareDAO raavareDAO = new MySQLRaavareDAO();
		raavareDAO.createRaavare(raavareDTO);
		
		ProduktBatchDTO pb = new ProduktBatchDTO(12,1,3);
		MySQLProduktbatch pbDAO = new MySQLProduktbatch();
		pbDAO.createProduktBatch(pb);
		
		ProduktBatchKompDTO pbk = new ProduktBatchKompDTO(12,21,1.0,2.0,"1102990225");
		MySQLProduktBatchKomp pbkDAO = new MySQLProduktBatchKomp();
		pbkDAO.createProduktBatchKomp(pbk);
		assertTrue(
				"Succesfully retrieved produktbatch",
				pbkDAO.getProduktBatchKomp(12,21).getPbId()==12 &&
				pbkDAO.getProduktBatchKomp(12,21).getRaavareId()==21 &&
				pbkDAO.getProduktBatchKomp(12,21).getTara()==1.0 &&
				pbkDAO.getProduktBatchKomp(12,21).getNetto()==2.0 &&
				pbkDAO.getProduktBatchKomp(12,21).getCpr().equals("1102990225")
		);
	}

	@Test
	public void testGetProduktBatchKompList() throws DALException {
		MySQLProduktBatchKomp pbkDAO = new MySQLProduktBatchKomp();
		assertTrue(
				"The ProduktBatchKompList has content",
				pbkDAO.getProduktBatchKompList()!=null

		);
	}

	@Test
	public void testCreateProduktBatchKomp() throws DALException {
		AnsatDTO ansat = new AnsatDTO("1102990226", "Bob", "Bo", "fisken", 0);
		MySQLAnsatDAO ans = new MySQLAnsatDAO();
		ans.createAnsat(ansat);
		
		RaavareDTO raavareDTO = new RaavareDTO(24, "tomat");
		MySQLRaavareDAO raavareDAO = new MySQLRaavareDAO();
		raavareDAO.createRaavare(raavareDTO);
		
		ProduktBatchDTO pb = new ProduktBatchDTO(13,1,3);
		MySQLProduktbatch pbDAO = new MySQLProduktbatch();
		pbDAO.createProduktBatch(pb);
		
		ProduktBatchKompDTO pbk = new ProduktBatchKompDTO(13,24,1.0,2.0,"1102990226");
		MySQLProduktBatchKomp pbkDAO = new MySQLProduktBatchKomp();
		pbkDAO.createProduktBatchKomp(pbk);
		assertTrue(
				"Succesfully created produktbatch",
				pbkDAO.getProduktBatchKomp(13,24).getPbId()==13 &&
				pbkDAO.getProduktBatchKomp(13,24).getRaavareId()==24 &&
				pbkDAO.getProduktBatchKomp(13,24).getTara()==1.0 &&
				pbkDAO.getProduktBatchKomp(13,24).getNetto()==2.0 &&
				pbkDAO.getProduktBatchKomp(13,24).getCpr().equals("1102990226")
		);
	}
	@Test
	public void testUpdateProduktBatchKomp() throws DALException {
		AnsatDTO ansat = new AnsatDTO("1102990107", "Bob", "Bo", "fisken", 0);
		MySQLAnsatDAO ans = new MySQLAnsatDAO();
		ans.createAnsat(ansat);
		
		ProduktBatchKompDTO pbk = new ProduktBatchKompDTO(5,5,1.0,2.0,"1102990107");
		ProduktBatchKompDTO pbk1 = new ProduktBatchKompDTO(5,5,0.5,4.0,"1102990107");
		MySQLProduktBatchKomp pbkDAO = new MySQLProduktBatchKomp();
		pbkDAO.createProduktBatchKomp(pbk);
		pbkDAO.updateProduktBatchKomp(pbk1);
		assertTrue(
				"Succesfully updated produktbatchkomp",
				pbkDAO.getProduktBatchKomp(5, 5).getPbId()==5 &&
				pbkDAO.getProduktBatchKomp(5, 5).getRaavareId()==5 &&
				pbkDAO.getProduktBatchKomp(5, 5).getTara()==0.5 &&
				pbkDAO.getProduktBatchKomp(5, 5).getNetto()==4.0 &&
				pbkDAO.getProduktBatchKomp(5, 5).getCpr().equals("1102990107")
		);
	}
}
