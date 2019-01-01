package main.java.com.my.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.my.model.Indish;

@Repository
public interface IndishRepository extends JpaRepository<Indish, Integer>{
	
	List<Indish> findByDishIddishAndIngrenameIdingrenames(int dishId, int ingrenameId);
	void deleteByDishIddishAndIngrenameIdingrenames(int dishId, int ingrenameId);
	
	void deleteByIngrenameIdingrenamesIn(int ingrenameId);
	
	List<Indish> findByIngrenameIdingrenamesIn(int ingrenameId);
	
	int countByIngrenameIdingrenamesIn(int ingrenameId);
	
	


}
