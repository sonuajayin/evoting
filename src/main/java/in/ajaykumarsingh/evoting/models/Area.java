package in.ajaykumarsingh.evoting.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/***
 * Area (Constituency) *
 */
@Entity
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
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
	
}
