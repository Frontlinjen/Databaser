package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;
import daointerfaces01917.AnsatDAO;
import daointerfaces01917.DALException;
import dto01917.AnsatDTO;

public class MySQLAnsatDAO implements AnsatDAO {
	public AnsatDTO getAnsat(String cpr) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM ansat WHERE cpr = " + cpr + ";");
	    try {
	    	if (!rs.first()) throw new DALException("Den ansatte med cprnr " + cpr + " findes ikke");
	    	return new AnsatDTO (rs.getString("cpr"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("password"), rs.getInt("titel"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createAnsat(AnsatDTO ans) throws DALException {		
			Connector.doUpdate(
				"INSERT INTO ansat(cpr, opr_navn, ini, password, titel) VALUES " +
				"(" + ans.getCpr() + ", '" + ans.getOprNavn() + "', '" + ans.getIni() + "', '" + 
				ans.getPassword() + "', '" + ans.getTitel() + "');"
			);
	}
	
	public void updateAnsat(AnsatDTO ans) throws DALException {
		Connector.doUpdate(
				"UPDATE ansat SET  opr_navn = '" + ans.getOprNavn() + "', ini =  '" + ans.getIni() + 
				"', password = '" + ans.getPassword() + "', titel = '" + ans.getTitel() + "' WHERE cpr = " +
				ans.getCpr() + ";"
		);
	}
	
	public List<AnsatDTO> getAnsatList() throws DALException {
		List<AnsatDTO> list = new ArrayList<AnsatDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM ansat;");
		try
		{
			while (rs.next()) 
			{
				list.add(new AnsatDTO(rs.getString("cpr"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("password"), rs.getInt("titel")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
}
	
