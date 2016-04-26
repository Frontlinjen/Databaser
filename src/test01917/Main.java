package test01917;

import daoimpl01917.MySQLAnsatDAO;
import daointerfaces01917.DALException;
import dto01917.AnsatDTO;

import java.sql.SQLException;

import connector01917.Connector;

public class Main {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("Ansat nummer 3:");
		MySQLAnsatDAO ans = new MySQLAnsatDAO();
		try { System.out.println(ans.getAnsat("0909909009")); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny ansat med titel =  1");
		AnsatDTO ansDTO = new AnsatDTO("0000000001","Don Juan","DJ","iloveyou",1);
		try { ans.createAnsat(ansDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Ansat nummer 4:");
		try { System.out.println(ans.getAnsat("0000000001")); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af initialer for ansatte nummer 4");
		ansDTO.setIni("DoJu");
		try { ans.updateAnsat(ansDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Ansat nummer 4:");
		try { System.out.println(ans.getAnsat("0000000001")); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle ansatte:");
		try { System.out.println(ans.getAnsatList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Ansat nummer 5:");
		try { System.out.println(ans.getAnsat("0000000005")); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
		
	}
}
