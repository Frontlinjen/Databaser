package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktbatch implements ProduktBatchDAO {

	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pb_id = " + pbId);
	    try {
	    	if (!rs.first()) throw new DALException("Det produktbatch med pb_id'et " + pbId + " findes ikke");
	    	return new ProduktBatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	

	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		List<ProduktBatchDAO> list = new ArrayList<ProduktBatchDAO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchDAO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id");
			}
			
			
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
