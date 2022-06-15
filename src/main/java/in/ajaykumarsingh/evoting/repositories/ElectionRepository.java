package in.ajaykumarsingh.evoting.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ajaykumarsingh.evoting.models.Election;

@Repository
public interface ElectionRepository extends CrudRepository<Election, Integer> {

}
