package main.java.com.my.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the ingrenames database table.
 * 
 */
@Entity
@Table(name="ingrenames")
@JsonIgnoreProperties("indishs")
@NamedQuery(name="Ingrename.findAll", query="SELECT i FROM Ingrename i")
public class Ingrename implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idingrenames;

	private String ingrname;

	//bi-directional many-to-one association to Indish
	@OneToMany(mappedBy="ingrename")
	private List<Indish> indishs;

	public Ingrename() {
	}

	public int getIdingrenames() {
		return this.idingrenames;
	}

	public void setIdingrenames(int idingrenames) {
		this.idingrenames = idingrenames;
	}

	public String getIngrname() {
		return this.ingrname;
	}

	public void setIngrname(String ingrname) {
		this.ingrname = ingrname;
	}

	public List<Indish> getIndishs() {
		return this.indishs;
	}

	public void setIndishs(List<Indish> indishs) {
		this.indishs = indishs;
	}

	public Indish addIndish(Indish indish) {
		getIndishs().add(indish);
		indish.setIngrename(this);

		return indish;
	}

	public Indish removeIndish(Indish indish) {
		getIndishs().remove(indish);
		indish.setIngrename(null);

		return indish;
	}

}