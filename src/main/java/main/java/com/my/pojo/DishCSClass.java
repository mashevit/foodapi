package main.java.com.my.pojo;

import java.io.Serializable;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class DishCSClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	//@JsonProperty("dishName")
	private String dishName;
	private List<String> ingreds;
	public List<String> getIngreds() {
		return ingreds;
	}
	public void setIngreds(List<String> ingreds) {
		this.ingreds = ingreds;
	}
	public DishCSClass() {
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}


}
