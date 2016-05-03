package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;

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
		
		System.out.println("RaavareBatch med:");
		MySQLRaavareBatchDAO rab = new MySQLRaavareBatchDAO();
		try { 
				System.out.println(rab.getRaavareBatch(2, "Franz")); 
			}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
			}
		System.out.println("Indsaettelse af nyt RaavareBatch med rvId = 1, leverandoer = Franz, maengde = 200");
		RaavareBatchDTO rabDTO = new RaavareBatchDTO(1, "Franz", 200.5);
		try { 
			rab.createRaavareBatch(rabDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Opdatering af rvID, maengde og leverandoer paa test RaavareBatch");
		rabDTO.setRaavareId(2);
		rabDTO.setMaengde(300);
		rabDTO.setLeverandoerNavn("Knoor");
		try { 
			rab.updateRaavareBatch(rabDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Alle RaavareBatch paa en liste:");
		try { 
			System.out.println(rab.getRaavareBatchList()); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
	}

	}

