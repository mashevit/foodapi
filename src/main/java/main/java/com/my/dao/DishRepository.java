package main.java.com.my.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.my.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer>{

	//List<Dish> findBydishNameIgnoreCase(String name);
   //List<Dish> findBydishNameIgnoreCase(String name);

	List<Dish> findBydishnameIgnoreCase(String name);
	
    List<Dish> findBydishnameContainingIgnoreCase(String name);
    
    List<Dish> findByindishsIngrenameIdingrenamesIn(int id);

}
