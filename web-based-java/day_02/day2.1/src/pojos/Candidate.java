package pojos;

/**
 * @author nishant
 *
 *         create table candidates( id int primary key auto_increment, name
 *         varchar(20) unique, party varchar(20), votes int );
 */
public class Candidate {

	private int candidateId;
	private String candidateName;
	private String candidateParty;
	private int candidateVotes;

	public Candidate() {
		super();
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidateParty="
				+ candidateParty + ", candidateVotes=" + candidateVotes + "]";
	}

	public Candidate(String candidateName, String candidateParty) {
		super();
		this.candidateName = candidateName;
		this.candidateParty = candidateParty;
	}

	/**
	 * @param candidateId
	 * @param candidateName
	 * @param candidateParty
	 * @param candidateVotes
	 */
	public Candidate(int candidateId, String candidateName, String candidateParty, int candidateVotes) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidateParty = candidateParty;
		this.candidateVotes = candidateVotes;
	}

	/**
	 * @return the candidateId
	 */
	public int getCandidateId() {
		return candidateId;
	}

	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	/**
	 * @return the candidateName
	 */
	public String getCandidateName() {
		return candidateName;
	}

	/**
	 * @param candidateName the candidateName to set
	 */
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	/**
	 * @return the candidateParty
	 */
	public String getCandidateParty() {
		return candidateParty;
	}

	/**
	 * @param candidateParty the candidateParty to set
	 */
	public void setCandidateParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}

	/**
	 * @return the candidateVotes
	 */
	public int getCandidateVotes() {
		return candidateVotes;
	}

	/**
	 * @param candidateVotes the candidateVotes to set
	 */
	public void setCandidateVotes(int candidateVotes) {
		this.candidateVotes = candidateVotes;
	}

	
}
