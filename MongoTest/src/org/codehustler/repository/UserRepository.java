package org.codehustler.repository;

import org.codehustler.dao.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {

	public UserModel findByUsername(String username);

}
