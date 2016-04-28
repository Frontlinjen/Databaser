package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO {

	@Override
	public RaavareBatchDTO getRaavareBatch(int rvId, String leverandoer) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM leverandoer WHERE raavare_id = " + rvId + " AND leverandoer_navn = " + leverandoer + ";");
		
		try{
			if(!rs.first()) 
				throw new DALException("Raavaren " + rvId + " findes ikke fra leverandøren: " + leverandoer);
			return new RaavareBatchDTO(rs.getInt("raavare_id"), rs.getString("leverandoer_navn"), rs.getDouble("maengde"));
		}
		catch(SQLException e) 
		{
			throw new DALException(e);
		}
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM leverandoer;");
		return populateList(rs);
	}
	public List<RaavareBatchDTO> populateList(ResultSet rs) throws DALException
	{
		try{
			if(!rs.first()) 
				throw new DALException("Ingen raavarebatches blev fundet");
			List<RaavareBatchDTO> raavareBatches = new ArrayList<RaavareBatchDTO>();
			do
			{
				RaavareBatchDTO batch = new RaavareBatchDTO(rs.getInt("raavare_id"), rs.getString("leverandoer_navn"), rs.getDouble("maengde"));
				raavareBatches.add(batch);
			}while(rs.next());
			return raavareBatches;
		}
		catch(SQLException e) 
		{
			throw new DALException(e);
		}
	}
	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM leverandoer WHERE raavare_id = " + raavareId + ";");
		return populateList(rs);
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		int updateCount = Connector.doUpdate(String.format("INSERT INTO leverandoer(raavare_id, leverandoer_navn, maengde) values(%i, %s, %d", raavarebatch.getRaavareId(),  raavarebatch.getLeverandoerNavn(), raavarebatch.getMaengde() + ";"));
		if(updateCount==0)
			throw new DALException("Failed to add new raavarebatch!");
	}

	@Override
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		int updateCount = Connector.doUpdate(String.format("UPDATE leverandoer SET (maengde=%d) WHERE raavare_id=raavare_id=%i AND leverandoer_navm=%s", raavarebatch.getMaengde(), raavarebatch.getRaavareId(),  raavarebatch.getLeverandoerNavn() + ";"));
		if(updateCount==0)
			throw new DALException("Failed to update raavarebatch!");
		
	}

	
}
