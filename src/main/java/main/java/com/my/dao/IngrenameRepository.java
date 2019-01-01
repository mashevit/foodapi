package main.java.com.my.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.my.model.Dish;
import main.java.com.my.model.Ingrename;

@Repository
public interface IngrenameRepository extends JpaRepository<Ingrename, Integer>{
	
	List<Ingrename> findByIndishsDish(Dish dish );
	List<Ingrename> findByIndishsDishIddish(int id );
	
    List<Ingrename> findByingrnameContainingIgnoreCase(String name);

}
