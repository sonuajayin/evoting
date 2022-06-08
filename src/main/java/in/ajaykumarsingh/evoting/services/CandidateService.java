package in.ajaykumarsingh.evoting.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ajaykumarsingh.evoting.models.Candidate;

@Service
public class CandidateService {

	/***
	 * Returns list of candidates for election
	 * @param electionId
	 * @return List<Candidate>
	 */
	public List<Candidate> getCandidates(int electionId){
		throw new UnsupportedOperationException();
	}
	
	/***
	 * Returns Candidate by Identifier
	 * @param id
	 * @return Candidate
	 */
	public Candidate getCandidate(int id) {
		throw new UnsupportedOperationException();
	}
	
	/***
	 * Add or Update Candidate Record
	 * @param candidate
	 */
	public void saveCandidate(Candidate candidate) {
		
	}
}
