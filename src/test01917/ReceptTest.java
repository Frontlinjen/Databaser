package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRecept;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;

public class ReceptTest {

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
		System.out.println("Recept med id 1:");
		MySQLRecept ans = new MySQLRecept();
		try { 
				System.out.println(ans.getRecept(1)); 
			}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
			}

		System.out.println("Oprettelse af recept med navn kage og id'et 5");
		ReceptDTO ansDTO = new ReceptDTO(5, "kage");
		try { 
			ans.createRecept(ansDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}	

		System.out.println("Recept med id'et 5:");
		try { 
			System.out.println(ans.getRecept(5)); 
			}
		catch (DALException e) 
		{ 
			System.out.println(e.getMessage()); 
			}

		System.out.println("Opdaterer recepten med id'et 5");
		ansDTO.setReceptNavn("lagkage");
		try { 
			ans.updateRecept(ansDTO); 
			System.out.println(ans.getRecept(5));
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}

		System.out.println("Alle ansatte:");
		try { 
			System.out.println(ans.getReceptList()); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
	}
}
