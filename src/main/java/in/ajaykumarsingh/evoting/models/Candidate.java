package in.ajaykumarsingh.evoting.models;

public class Candidate {

	private int id;
	private int electionId;
	private String name;
	private String party;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getElectionId() {
		return electionId;
	}
	
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getParty() {
		return party;
	}
	
	public void setParty(String party) {
		this.party = party;
	}	
		
}
