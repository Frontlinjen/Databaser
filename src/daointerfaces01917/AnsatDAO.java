package daointerfaces01917;

import java.util.List;

import dto01917.AnsatDTO;

public interface AnsatDAO {
	AnsatDTO getAnsat(String cpr) throws DALException;
	List<AnsatDTO> getAnsatList() throws DALException;
	void createAnsat(AnsatDTO ans) throws DALException;
	void updateAnsat(AnsatDTO ans) throws DALException;
}
