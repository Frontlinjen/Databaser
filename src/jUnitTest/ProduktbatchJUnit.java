package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLProduktbatch;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;

public class ProduktbatchJUnit {
	
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
	public void testGetProduktBatch() throws DALException {
		ProduktBatchDTO pb = new ProduktBatchDTO(6,1,3);
		MySQLProduktbatch pbDAO = new MySQLProduktbatch();
		pbDAO.createProduktBatch(pb);
		assertTrue(
				"Succesfully retrieved produktbatch",
				pbDAO.getProduktBatch(6).getPbId()==6 &&
				pbDAO.getProduktBatch(6).getStatus()==1 &&
				pbDAO.getProduktBatch(6).getReceptId()==3
		);
	}

	@Test
	public void testGetProduktBatchList() throws DALException {
		MySQLProduktbatch pbDAO = new MySQLProduktbatch();
		assertTrue(
				"The ProduktBatchList has content",
				pbDAO.getProduktBatchList()!=null

		);
	}

	@Test
	public void testCreateProduktBatch() throws DALException {
		ProduktBatchDTO pb = new ProduktBatchDTO(7,1,3);
		MySQLProduktbatch pbDAO = new MySQLProduktbatch();
		pbDAO.createProduktBatch(pb);
		assertTrue(
				"Succesfully created produktbatch",
				pbDAO.getProduktBatch(7).getPbId()==7 &&
				pbDAO.getProduktBatch(7).getStatus()==1 &&
				pbDAO.getProduktBatch(7).getReceptId()==3
		);
	}

	@Test
	public void testUpdateProduktBatch() throws DALException {
		ProduktBatchDTO pb = new ProduktBatchDTO(7,1,3);
		ProduktBatchDTO pb1 = new ProduktBatchDTO(7,1,3);
		MySQLProduktbatch pbDAO = new MySQLProduktbatch();
		pbDAO.createProduktBatch(pb);
		assertTrue(
				"Succesfully created produktbatch",
				pbDAO.getProduktBatch(7).getPbId()==7 &&
				pbDAO.getProduktBatch(7).getStatus()==1 &&
				pbDAO.getProduktBatch(7).getReceptId()==3
		);
	}

}
