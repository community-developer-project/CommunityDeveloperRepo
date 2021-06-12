package com.devcom.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devcom.boot.entity.User;


@Repository
public interface UserRepository  extends CrudRepository<User,String> {

}
