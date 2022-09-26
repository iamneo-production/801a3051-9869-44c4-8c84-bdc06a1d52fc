package com.examly.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.Model.*;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	@Query(value = "select u.email,u.password from user u where u.email=:emailID and u.password=:password",nativeQuery=true)
	public UserModel logginInUser(@Param("emailID") String emailID, @Param("password") String password);

}