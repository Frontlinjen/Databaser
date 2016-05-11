package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLRecept;
import daoimpl01917.MySQLReceptKomp;
import daointerfaces01917.DALException;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

public class ReceptKompJUnit {
	
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
	public void testGetReceptKomp() throws DALException {
		ReceptDTO r = new ReceptDTO(12,"pineapple");
		MySQLRecept rD = new MySQLRecept();
		rD.createRecept(r);
		
		RaavareDTO ra = new RaavareDTO(10,"banan");
		MySQLRaavareDAO raD = new MySQLRaavareDAO();
		raD.createRaavare(ra);
		
		ReceptKompDTO rk = new ReceptKompDTO(12,10,2.0,3.0);
		MySQLReceptKomp rkDAO = new MySQLReceptKomp();
		rkDAO.createReceptKomp(rk);		
		assertTrue(
				"Succesfully retrieved ReceptKomp",
				rkDAO.getReceptKomp(12, 10).getReceptId()==12 &&
				rkDAO.getReceptKomp(12, 10).getRaavareId()==10 &&
				rkDAO.getReceptKomp(12, 10).getNomNetto()==2.0 &&
				rkDAO.getReceptKomp(12, 10).getTolerance()==3.0
			);	
	}

	@Test
	public void testGetReceptKompList() throws DALException {
		MySQLReceptKomp rkDAO = new MySQLReceptKomp();
		assertTrue(
				"The list has content",
				rkDAO.getReceptKompList()!=null
			);
	}

	@Test
	public void testCreateReceptKomp()  throws DALException {
		ReceptDTO r = new ReceptDTO(17,"pineapple");
		MySQLRecept rD = new MySQLRecept();
		rD.createRecept(r);
		
		RaavareDTO ra = new RaavareDTO(18,"banan");
		MySQLRaavareDAO raD = new MySQLRaavareDAO();
		raD.createRaavare(ra);
		
		ReceptKompDTO rk = new ReceptKompDTO(17,18,2.0,3.0);
		MySQLReceptKomp rkDAO = new MySQLReceptKomp();
		rkDAO.createReceptKomp(rk);		
		assertTrue(
				"Succesfully created Receptkomp",
				rkDAO.getReceptKomp(17, 18).getReceptId()==17 &&
				rkDAO.getReceptKomp(17, 18).getRaavareId()==18 &&
				rkDAO.getReceptKomp(17, 18).getNomNetto()==2.0 &&
				rkDAO.getReceptKomp(17, 18).getTolerance()==3.0
			);	
	}

	@Test
	public void testUpdateReceptKomp() throws DALException {
		ReceptDTO r = new ReceptDTO(14,"pineapple");
		MySQLRecept rD = new MySQLRecept();
		rD.createRecept(r);
		
		RaavareDTO ra = new RaavareDTO(12,"banan");
		MySQLRaavareDAO raD = new MySQLRaavareDAO();
		raD.createRaavare(ra);
		
		ReceptKompDTO rk = new ReceptKompDTO(14,12,2.0,3.0);
		ReceptKompDTO rk1 = new ReceptKompDTO(14,12,5.0,8.0);
		MySQLReceptKomp rkDAO = new MySQLReceptKomp();
		rkDAO.createReceptKomp(rk);
		rkDAO.updateReceptKomp(rk1);
		assertTrue(
				"Succesfully updated Receptkomp",
				rkDAO.getReceptKomp(14, 12).getReceptId()==14 &&
				rkDAO.getReceptKomp(14, 12).getRaavareId()==12 &&
				rkDAO.getReceptKomp(14, 12).getNomNetto()==5.0 &&
				rkDAO.getReceptKomp(14, 12).getTolerance()==8.0
			);	
	}

}
