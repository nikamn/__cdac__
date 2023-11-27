package dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public interface CandidateDao {
	List<Candidate> getAllCandidates() throws SQLException;

	String incrementVotes(int candidateId) throws SQLException;

	List<Candidate> getTop2Candidates() throws SQLException;

	LinkedHashMap<String, Integer> getPartywiseVotes() throws SQLException;
}
