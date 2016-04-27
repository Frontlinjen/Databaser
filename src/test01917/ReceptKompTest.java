package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLAnsatDAO;
import daoimpl01917.MySQLReceptKomp;
import daointerfaces01917.DALException;
import dto01917.AnsatDTO;
import dto01917.ReceptKompDTO;

public class ReceptKompTest {

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
		
		System.out.println("Receptkomponent receptId = 1, raavareId = 1: ");
		MySQLReceptKomp rek = new MySQLReceptKomp();
		try { 
				System.out.println(rek.getReceptKomp(1, 1)); 
			}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
			}
		
		System.out.println("Receptkomponent receptId = 3, raavareId = 5: ");
		try { 
				System.out.println(rek.getReceptKomp(3, 5)); 
			}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
			}
		
		System.out.println("Indsaettelse af ny receptkomponent med receptId = x, raavareId = y: ");
		ReceptKompDTO rekDTO = new ReceptKompDTO(1, 4, 3, 0.1);
		try { 
			rek.createReceptKomp(rekDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Opdatering af nom_netto for receptkomponent receptId = 1, raavareId = 1: ");
		rekDTO.setNomNetto(5);
		try { 
			rek.updateReceptKomp(rekDTO);
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("List af alle receptkomponenter: ");
		try { 
			System.out.println(rek.getReceptKompList());
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("List af alle receptkomponenter med receptId = 3: ");
		try { 
			System.out.println(rek.getReceptKompList(3));
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
	}

}
