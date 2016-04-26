package daoimpl01917;

import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptKompDAO;
import dto01917.AnsatDTO;
import dto01917.ReceptKompDTO;

public class MySQLReceptKomp implements ReceptKompDAO{

	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM receptKomponent WHERE receptID = " + receptId + " AND raavareId = " + raavareId);
		try{
			return new ReceptKompDTO(rs.getInt("receptId"), rs.getInt("raavareId"), rs.getDouble("nomNetto"), rs.getDouble("tolerance"));
		}
		catch (SQLException e) {throw new DALException("Receptkomponenten med receptId " + receptId + " og raavareId " + raavareId + " findes ikke"); }
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptKomponent WHERE receptId = " + receptId);
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("receptId"), rs.getInt("raavareId"), rs.getDouble("nomNetto"), rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptKomponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("receptId"), rs.getInt("raavareId"), rs.getDouble("nomNetto"), rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
	

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doUpdate("INSERT INTO receptKomponent(receptId, raavareId, nomNetto, tolerance) VALUES (" + receptkomponent.getReceptId() + ","
		+ receptkomponent.getRaavareId() + "," + receptkomponent.getNomNetto() + "," + receptkomponent.getTolerance());
	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doUpdate("UPDATE receptKomponent Set nomNetto = '" + receptkomponent.getNomNetto() + "', tolerance = '"
		+ receptkomponent.getTolerance() + "' WHERE receptId = " + receptkomponent.getReceptId() + " AND raavareId = " + receptkomponent.getRaavareId());
		
	}

}
