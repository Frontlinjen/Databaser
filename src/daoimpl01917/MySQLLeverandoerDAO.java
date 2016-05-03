package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.LeverandoerDAO;
import dto01917.LeverandoerDTO;
import dto01917.RaavareDTO;

public class MySQLLeverandoerDAO implements LeverandoerDAO {

	@Override
	public LeverandoerDTO getLeverandoer(int rvId, String leverandoer) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM leverandoer WHERE raavare_id = " + rvId + " AND leverandoer_navn = '" + leverandoer + "';");
		
		try{
			if(!rs.first()) 
				throw new DALException("Raavaren " + rvId + " findes ikke fra leverand�ren: '" + leverandoer + "'");
			return new LeverandoerDTO(rs.getInt("raavare_id"), rs.getString("leverandoer_navn"), rs.getDouble("maengde"));
		}
		catch(SQLException e) 
		{
			throw new DALException(e);
		}
	}

	@Override
	public List<LeverandoerDTO> getLeverandoerList() throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM leverandoer;");
		return populateList(rs);
	}
	public List<LeverandoerDTO> populateList(ResultSet rs) throws DALException
	{
		try{
			if(!rs.first()) 
				throw new DALException("Ingen raavarebatches blev fundet");
			List<LeverandoerDTO> leverandoer = new ArrayList<LeverandoerDTO>();
			do
			{
				LeverandoerDTO lev = new LeverandoerDTO(rs.getInt("raavare_id"), rs.getString("leverandoer_navn"), rs.getDouble("maengde"));
				leverandoer.add(lev);
			}while(rs.next());
			return leverandoer;
		}
		catch(SQLException e) 
		{
			throw new DALException(e);
		}
	}
	

	@Override
	public void createLeverandoer(LeverandoerDTO leverandoer) throws DALException {
		int updateCount = Connector.doUpdate(String.format("INSERT INTO leverandoer(raavare_id, leverandoer_navn, maengde) VALUES(" + leverandoer.getRaavareId() + ", '" +
		leverandoer.getLeverandoerNavn() + "', " + leverandoer.getMaengde() + ");"));
		if(updateCount==0)
			throw new DALException("Failed to add new raavarebatch!");
	}

	@Override
	public void updateLeverandoer(LeverandoerDTO leverandoer) throws DALException {
		int updateCount = Connector.doUpdate(String.format("UPDATE leverandoer SET maengde = " + leverandoer.getMaengde() +
		"WHERE raavare_id = " + leverandoer.getRaavareId() + " AND leverandoer_navn = '" + leverandoer.getLeverandoerNavn() + "';"));
	}

	
}
