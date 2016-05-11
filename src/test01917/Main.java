package test01917;

import daoimpl01917.MySQLAnsatDAO;
import daointerfaces01917.DALException;
import dto01917.AnsatDTO;

import java.sql.SQLException;

import connector01917.Connector;

public class Main {
	public static void main(String[] args) throws DALException {
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
		System.out.println("Ansat nummer 0707707007:");
		MySQLAnsatDAO ans = new MySQLAnsatDAO();
		try { 
				System.out.println(ans.getAnsat("0707707007") + "\n" ); 
			}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
			}

		System.out.println("Indsaettelse af ny ansat med CPR-nummer =  0000000002");
		AnsatDTO ansDTO = new AnsatDTO("0000000002","Don Juan","DJ","iloveyou",1);
		try { 
			ans.createAnsat(ansDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}	

		System.out.println("\nAnsat nummer 0000000002:");
		try { 
			System.out.println(ans.getAnsat("0000000002")); 
			}
		catch (DALException e) 
		{ 
			System.out.println(e.getMessage()); 
			}

		System.out.println("\nOpdatering af initialer for ansatte nummer 0000000002");
		AnsatDTO ansDTO5 = new AnsatDTO(ans.getAnsat("0000000002"));
		System.out.println(ans.getAnsat("0000000002"));
		ansDTO5.setIni("klmw");
		ans.updateAnsat(ansDTO5);
		System.out.println(ans.getAnsat("0000000002"));
		


		System.out.println("\nAlle ansatte:");
		try { 
			System.out.println(ans.getAnsatList()); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
	}
}
