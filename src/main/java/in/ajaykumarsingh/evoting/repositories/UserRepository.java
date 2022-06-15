package in.ajaykumarsingh.evoting.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ajaykumarsingh.evoting.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
