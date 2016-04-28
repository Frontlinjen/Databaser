package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;

public class RaavareBatchTest {

	public static void main(String[] args) {
		try { 
			new Connector(); 
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace(); 
		}
		catch (IllegalAccessException e) 
		{ 
			e.printStackTrace(); 
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		
		System.out.println("RaavareBatch med :");
		MySQLRaavareBatchDAO rab = new MySQLRaavareBatchDAO();
		try { 
				System.out.println(rab.getRaavareBatch(0, null)); 
			}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
			}

	}

}
