package in.ajaykumarsingh.evoting.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ajaykumarsingh.evoting.models.VoteRecord;

@Repository
public interface VoteRecordRepository extends CrudRepository<VoteRecord, Long> {

}
