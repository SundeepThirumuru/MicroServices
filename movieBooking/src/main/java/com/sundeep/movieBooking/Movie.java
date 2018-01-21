package com.sundeep.movieBooking;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;

@Entity
public class Movie {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private Date release_date;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_actor_relation", 
    			   joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"), 
    			   inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    @JsonManagedReference
	private List<Actor> actors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Movie) {
			return this.getId() == ((Movie) o).getId();
		}
		return false;
	}

}
