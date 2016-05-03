package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLLeverandoerDAO;
import daointerfaces01917.DALException;
import dto01917.LeverandoerDTO;

public class LeverandoerTest {

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
		MySQLLeverandoerDAO lev = new MySQLLeverandoerDAO();
		try { 
				System.out.println(lev.getLeverandoer(2, "Franz")); 
			}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
			}
		System.out.println("Indsaettelse af ny Leverandoer med rvId = 1, leverandoer = Franz, maengde = 200");
		LeverandoerDTO levDTO = new LeverandoerDTO(1, "Franz", 200.5);
		try { 
			lev.createLeverandoer(levDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Opdatering af rvID, maengde og leverandoer paa test Leverandoer");
		levDTO.setRaavareId(2);
		levDTO.setMaengde(300);
		levDTO.setLeverandoerNavn("Knoor");
		try { 
			lev.updateLeverandoer(levDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Alle RaavareBatch paa en liste:");
		try { 
			System.out.println(lev.getLeverandoerList()); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
	}

	}

