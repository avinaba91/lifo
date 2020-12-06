package com.stack.lifo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stack.lifo.model.Stack;

public interface StackRepository extends JpaRepository<Stack, Long> {
	
	@Query(value = "SELECT max(itemId) FROM Stack")
    public Long getMaxItemId();

}
