package in.ajaykumarsingh.evoting.models;

import java.util.List;

public class VoteModel {

	private Election election;

	private boolean hasVoted;

	private List<Candidate> candidates;

	public VoteModel(Election election, List<Candidate> candidates, boolean hasVoted) {
		this.election = election;
		this.candidates = candidates;
		this.hasVoted = hasVoted;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

}
