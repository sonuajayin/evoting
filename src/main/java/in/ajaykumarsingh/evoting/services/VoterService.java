package in.ajaykumarsingh.evoting.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajaykumarsingh.evoting.models.Candidate;
import in.ajaykumarsingh.evoting.models.Election;
import in.ajaykumarsingh.evoting.models.User;
import in.ajaykumarsingh.evoting.models.VoteCounter;
import in.ajaykumarsingh.evoting.models.VoteModel;
import in.ajaykumarsingh.evoting.models.VoteRecord;
import in.ajaykumarsingh.evoting.repositories.CandidateRepository;
import in.ajaykumarsingh.evoting.repositories.ElectionRepository;
import in.ajaykumarsingh.evoting.repositories.UserRepository;
import in.ajaykumarsingh.evoting.repositories.VoteCounterRepository;
import in.ajaykumarsingh.evoting.repositories.VoteRecordRepository;

@Service
public class VoterService {

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VoteRecordRepository voteRecordRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private VoteCounterRepository voteCounterRepository;

	public VoterService(ElectionRepository electionRepository, UserRepository userRepository,
			VoteRecordRepository voteRecordRepository, CandidateRepository candidateRepository,
			VoteCounterRepository voteCounterRepository) {
		this.electionRepository = electionRepository;
		this.userRepository = userRepository;
		this.voteRecordRepository = voteRecordRepository;
		this.candidateRepository = candidateRepository;
		this.voteCounterRepository = voteCounterRepository;
	}

	public List<Election> getActiveElections(String userEmail) {

		int areaId = userRepository.findByEmail(userEmail).getArea().getId();

		List<Election> elections = ((List<Election>) electionRepository.findAll())
				.stream().filter(e -> e.getStartDate().isBefore(LocalDate.now())
						&& e.getEndDate().isAfter(LocalDate.now()) && e.getArea().getId() == areaId)
				.collect(Collectors.toList());

		return elections;
	}

	public VoteModel getElectionDetails(int electionId, String userEmail) {
		Election election = electionRepository.findById(electionId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid election Id" + electionId));
		User user = userRepository.findByEmail(userEmail);
		List<Candidate> candidates = (List<Candidate>) candidateRepository.findAll();

		VoteRecord voteRecord = voteRecordRepository.findVoteRecordByElectionAndUser(election.getId(), user.getId());

		return new VoteModel(election, candidates, voteRecord != null ? true : false);
	}

	public void recordVote(int electionId, int candidateId, String userEmail) {
		User user = userRepository.findByEmail(userEmail);

		VoteRecord record = new VoteRecord();
		VoteCounter counter = new VoteCounter();

		Election election = electionRepository.findById(electionId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid election Id" + electionId));

		Candidate candidate = candidateRepository.findById(candidateId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id" + candidateId));

		record.setElection(election);
		record.setUser(user);
		
		counter.setCandidate(candidate);
		counter.setElection(election);

		voteRecordRepository.save(record);
		voteCounterRepository.save(counter);
	}
}
