package daoimpl01917;

import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptKompDAO;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
