package com.devcom.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devcom.boot.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer>{

}
