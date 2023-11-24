package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CandidateDao;
import pojos.Candidate;
import queries.SQLQueries;

import static utils.DBUtils.*;

public class CandidateDaoImpl implements CandidateDao {

	private Connection conn;
	private PreparedStatement pst;

	public CandidateDaoImpl() throws SQLException {
		conn = openConnection();
		System.out.println("candidate dao created");
	}

	@Override
	public List<Candidate> getAllCAndidates() throws SQLException {
		pst = conn.prepareStatement(SQLQueries.getAllC);

		List<Candidate> candidates = new ArrayList<Candidate>();
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			candidates.add(new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}

		return candidates;
	}

	@Override
	public String addNewCandidate(Candidate candidate) throws SQLException {
		pst = conn.prepareStatement(SQLQueries.insertC);

		pst.setString(1, candidate.getCandidateName());
		pst.setString(2, candidate.getCandidateParty());
		pst.setInt(3, 0);

		int rowCount = pst.executeUpdate();
		if (rowCount == 1)
			return "Candidate registered successfully ...!";
		return "Candidate registration failed ...!";

	}

	@Override
	public String updateVotesCount(int customerId) throws SQLException {
		pst = conn.prepareStatement(SQLQueries.updateVotesCount);

		pst.setInt(1, customerId);

		int rowCount = pst.executeUpdate();
		if (rowCount == 1)
			return "Candidate votes count updated successfully ...!";
		return "Candidate votes count updation failed ...!";

	}

	@Override
	public void cleanUp() throws SQLException {
		if (pst != null)
			pst.close();
		System.out.println("candidate dao cleaned up!");

	}

}
