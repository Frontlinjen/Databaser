package jUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daointerfaces01917.DALException;

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
	public void testGetRecept() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReceptList() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateRecept() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRecept() {
		fail("Not yet implemented");
	}
}
