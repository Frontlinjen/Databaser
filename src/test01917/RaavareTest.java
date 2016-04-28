package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareDTO;

public class RaavareTest {

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
		
		System.out.println("Raavare med raavare_id = 2:");
		MySQLRaavareDAO rav = new MySQLRaavareDAO();
		try { 
			System.out.println(rav.getRaavare(2)); 
		}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
		}
		
		System.out.println("Indsaettelse af ny raavare med raavare_id = 6 og raavare_navn = Oregano:");
		RaavareDTO ravDTO = new RaavareDTO(6, "Oregano");
		try { 
			rav.createRaavare(ravDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Opdatering af navn på raavaren med raavare_id = 6");
		ravDTO.setRaavareNavn("ananas(klamt og forkert)");
		try { 
			rav.updateRaavare(ravDTO);
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Alle raavarer på en liste:");
		try { 
			System.out.println(rav.getRaavareList()); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
	}

}