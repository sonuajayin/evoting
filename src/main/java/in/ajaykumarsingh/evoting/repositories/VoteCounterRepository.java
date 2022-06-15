package in.ajaykumarsingh.evoting.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ajaykumarsingh.evoting.models.VoteCounter;

@Repository
public interface VoteCounterRepository extends CrudRepository<VoteCounter, Long>{

}
