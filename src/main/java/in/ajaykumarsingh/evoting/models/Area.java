package in.ajaykumarsingh.evoting.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

/***
 * Area (Constituency) *
 */
@Entity
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "area")
	private List<Election> elections;
	
	@OneToMany(mappedBy = "area")
	private List<Candidate> candidates;
	
	@OneToMany(mappedBy = "area")
	private List<User> users;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name.toUpperCase();
	}
	
	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public List<Election> getElections() {
		return elections;
	}

	public void setElections(List<Election> elections) {
		this.elections = elections;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
