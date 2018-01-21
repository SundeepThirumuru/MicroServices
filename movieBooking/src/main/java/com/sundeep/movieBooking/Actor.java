package com.sundeep.movieBooking;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="movie_actor_relation", 
	joinColumns= {@JoinColumn(name="actor_id", referencedColumnName="id")}, 
	inverseJoinColumns= {@JoinColumn(name="movie_id", referencedColumnName="id")})
	@JsonBackReference
	private List<Movie> movies;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		StringBuilder stringBuilder = new StringBuilder();
		if(firstName != null) {
			stringBuilder.append(firstName);
		}
		if(lastName != null) {
			stringBuilder.append(" ");
			stringBuilder.append(lastName);
		}
		return stringBuilder.toString();
	}
	
	
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return getFullName();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Actor) {
			return this.getId().equals(((Actor) o).getId());
		}
		return false;
	}
	
}
