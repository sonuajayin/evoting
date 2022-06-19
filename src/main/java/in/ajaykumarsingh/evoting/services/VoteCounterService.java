package in.ajaykumarsingh.evoting.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajaykumarsingh.evoting.models.Election;
import in.ajaykumarsingh.evoting.models.VoteCounter;
import in.ajaykumarsingh.evoting.repositories.ElectionRepository;

@Service
public class VoteCounterService {
	
	@Autowired
	private ElectionRepository electionRepository;

	public VoteCounterService(ElectionRepository electionRepository) {
		this.electionRepository = electionRepository;
	}

	public List<List<Object>> getResults(int electionId) {
		Election election = electionRepository.findById(electionId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid election Id" + electionId));
		
		Map<String,Long> countMap=new HashMap<>();
		
		for(VoteCounter count: election.getVoteCounters()){
			String candidate=count.getCandidate().getName()+" ("+count.getCandidate().getParty()+")";
			long counter=countMap.getOrDefault(candidate, 0L);
			countMap.put(candidate, counter+1);			
		}
		
		List<List<Object>> resultList=new ArrayList<>();
		
		for(Map.Entry<String, Long> entry: countMap.entrySet()) {
			resultList.add(List.of(entry.getKey(),entry.getValue()));
		}
		
		return resultList;
	}
}
