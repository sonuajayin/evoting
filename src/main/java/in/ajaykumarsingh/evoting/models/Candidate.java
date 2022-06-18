package in.ajaykumarsingh.evoting.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int electionId;
	private String name;
	private String party;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	@OneToMany(mappedBy = "candidate")
	private List<VoteCounter> voteCounters;
	
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<VoteCounter> getVoteCounters() {
		return voteCounters;
	}

	public void setVoteCounters(List<VoteCounter> voteCounters) {
		this.voteCounters = voteCounters;
	}
	
		
}
