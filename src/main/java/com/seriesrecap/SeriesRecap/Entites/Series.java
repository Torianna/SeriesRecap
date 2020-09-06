package com.seriesrecap.SeriesRecap.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="series")
public class Series {

	  	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;

	    
	    private String name;
	    private String year;
	    private String photo; //as an url
	    private String description;
	    private float totalScore;
	    private float score;
	    
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

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public float getTotalScore() {
			return totalScore;
		}

		public void setTotalScore(float totalScore) {
			this.totalScore = totalScore;
		}

		public float getScore() {
			return score;
		}

		public void setScore(float score) {
			this.score = score;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@ManyToOne(fetch = FetchType.LAZY, optional=false, cascade = CascadeType.DETACH)
	    @JoinColumn(name="user_id",nullable=false)
	    private User user;
}
