package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchKomp;
import daointerfaces01917.DALException;
import dto01917.AnsatDTO;
import dto01917.ProduktBatchKompDTO;

public class ProduktBatchKompTest {

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
		
		System.out.println("ProduktBatchKomponent med pb_id = 4 og rb_id = 5:");
		MySQLProduktBatchKomp pbk = new MySQLProduktBatchKomp();
		try { 
			System.out.println(pbk.getProduktBatchKomp(4, 5)); 
		}
		catch (DALException e) { 
				System.out.println(e.getMessage()); 
		}
		
		System.out.println("Indsaettelse af nyt produktBatchKomponent med pbId = 4, raavareId = 2, tara = 0.5, netto = 10.1, cpr = 8549003489:");
		ProduktBatchKompDTO pbkDTO = new ProduktBatchKompDTO(4, 2, 0.5, 10.1, "8549003489");
		try { 
			pbk.createProduktBatchKomp(pbkDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Opdatering af tara, netto og cpr på test produktBatchKomponentet");
		pbkDTO.setTara(5.0);
		pbkDTO.setNetto(5);
		pbkDTO.setCpr("8912873894");
		try { 
			pbk.updateProduktBatchKomp(pbkDTO); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
		
		System.out.println("Alle produktBatchKomponenter på en liste:");
		try { 
			System.out.println(pbk.getProduktBatchKompList()); 
			}
		catch (DALException e) { 
			System.out.println(e.getMessage()); 
			}
	}

}
