package com.devsuperior.movieflix.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devsuperior.movieflix.entities.pk.ReviewPK;

@Entity
@Table(name = "tb_review")
public class Review {
	
	private static final ReviewPK ReviewPK = null;

	@EmbeddedId
	private ReviewPK id = new ReviewPK();
	
	private String text;
	
	@ManyToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private User user; 
	
	@ManyToOne
	@JoinColumn(name="movie_id", insertable = false, updatable = false)
	private Movie movie;
	
	public Review() {
		
	}

	public Review(ReviewPK id, String text, User user, Movie movie) {
		super();
		this.id = id;
		this.text = text;
		this.user = user;
		this.movie = movie;
	}

	public ReviewPK getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = ReviewPK;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(id, other.id);
	}
	
		
	
	
		
}
