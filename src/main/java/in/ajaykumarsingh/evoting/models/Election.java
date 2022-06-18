package in.ajaykumarsingh.evoting.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Election {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String Name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	@OneToMany(mappedBy = "election")
	private List<VoteCounter> voteCounters;
	
	@OneToMany(mappedBy = "election")
	private List<VoteRecord> voteRecords;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

	public List<VoteRecord> getVoteRecords() {
		return voteRecords;
	}

	public void setVoteRecords(List<VoteRecord> voteRecords) {
		this.voteRecords = voteRecords;
	}
	
}
