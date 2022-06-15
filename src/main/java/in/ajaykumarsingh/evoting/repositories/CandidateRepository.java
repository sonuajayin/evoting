package in.ajaykumarsingh.evoting.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ajaykumarsingh.evoting.models.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

}
