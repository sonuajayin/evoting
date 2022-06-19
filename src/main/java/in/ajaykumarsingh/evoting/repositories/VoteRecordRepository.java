package in.ajaykumarsingh.evoting.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ajaykumarsingh.evoting.models.VoteRecord;

@Repository
public interface VoteRecordRepository extends CrudRepository<VoteRecord, Long> {

	@Query("SELECT v FROM VoteRecord v WHERE v.election.id=?1 AND v.user.id=?2")
	VoteRecord findVoteRecordByElectionAndUser(int electionId, long userId);
}
