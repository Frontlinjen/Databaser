package test01917;

import java.sql.SQLException;

import daoimpl01917.MySQLProduktbatch;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;
import connector01917.Connector;

public class ProduktBatchTest {
	
	public static void main(String[] args){
		try { new Connector(); }
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	
		System.out.println("Produktbatch nummer 3:");
		MySQLProduktbatch pb = new MySQLProduktbatch();
		try { System.out.println(pb.getProduktBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	
		System.out.println("Indsaettelse af ny produktbatch med id =  1");
		ProduktBatchDTO pbDTO = new ProduktBatchDTO(5 , 3 , 1);
		try {
			
		}
		catch (DALException e) { System.out.println(e.getMessage()); }	
	}
}