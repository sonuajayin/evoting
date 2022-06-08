package in.ajaykumarsingh.evoting.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ajaykumarsingh.evoting.models.Election;

@Service
public class ElectionService {

	/***
	 * Returns List of All Elections
	 * @return List<Election>
	 */
	public List<Election> getElections(){
		throw new UnsupportedOperationException();
	}
	
	/***
	 * Returns List of Elections based on if its Active or not
	 * @param isActive
	 * @return List<Election>
	 */
	public List<Election> getElections(boolean isActive){
		throw new UnsupportedOperationException();
	}
	
	/***
	 * Returns Election By Id
	 * @param isActive
	 * @return Election
	 */
	public Election getElection(int Id){
		throw new UnsupportedOperationException();
	}
	
	/***
	 * Adds or Updates Election Record
	 * @param election
	 */
	public void saveElection(Election election) {
		
	}
	
}
