package main.java.com.my.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the dish database table.
 * 
 */
@Entity
@NamedQuery(name="Dish.findAll", query="SELECT d FROM Dish d")
@JsonIgnoreProperties({"indishs","dishing"})
public class Dish implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddish;

	private int dishing;

	private String dishname;
	
	//bi-directional many-to-one association to Indish
	@OneToMany(mappedBy="dish", cascade = CascadeType.PERSIST)
	private List<Indish> indishs;

	public Dish() {
	}

	public int getIddish() {
		return this.iddish;
	}

	public void setIddish(int iddish) {
		this.iddish = iddish;
	}

	public int getDishing() {
		return this.dishing;
	}

	public void setDishing(int dishing) {
		this.dishing = dishing;
	}

	public String getDishname() {
		return this.dishname;
	}

	public void setDishname(String dishname) {
		this.dishname = dishname;
	}

	public List<Indish> getIndishs() {
		return this.indishs;
	}

	public void setIndishs(List<Indish> indishs) {
		this.indishs = indishs;
	}

	public Indish addIndish(Indish indish) {
		getIndishs().add(indish);
		indish.setDish(this);

		return indish;
	}

	public Indish removeIndish(Indish indish) {
		getIndishs().remove(indish);
		indish.setDish(null);

		return indish;
	}
	
/*    public void addIngred(Ingrename b) {
    	indishs.add(b);
        b.fieldClassA().add(this);
    }

    public void removeClassB(ClassB b) {
        fieldClassB.remove(b);
        b.fieldClassA().remove(this);
    }  */

}