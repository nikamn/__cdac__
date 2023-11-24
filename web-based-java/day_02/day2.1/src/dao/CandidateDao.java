package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

/**
 * @author nishant
 *
 */
public interface CandidateDao {
	List<Candidate> getAllCAndidates() throws SQLException;

	String addNewCandidate(Candidate candidate) throws SQLException;

	String updateVotesCount(int customerId) throws SQLException;

	void cleanUp() throws SQLException;

}
