package com.devcom.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcom.boot.entity.Developer;


public interface IDeveloperRepository extends JpaRepository<Developer, Integer> {

}
