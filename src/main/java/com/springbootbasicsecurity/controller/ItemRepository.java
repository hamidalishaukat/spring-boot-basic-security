package com.springbootbasicsecurity.controller;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootbasicsecurity.entity.Itemm;

@Repository
public interface ItemRepository extends JpaRepository<Itemm, Integer>{
	Logger logger = Logger.getLogger(ItemRepository.class);


}
