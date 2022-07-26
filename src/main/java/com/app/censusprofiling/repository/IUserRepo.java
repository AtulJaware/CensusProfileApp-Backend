package com.app.censusprofiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.censusprofiling.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer>{
	
	@Query(value="select * from users inner join login on users.email=login.email where users.email=:email", nativeQuery=true)
	User getUserByEmail(@Param("email") String email);
	
}