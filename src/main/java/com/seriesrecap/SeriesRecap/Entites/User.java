package com.seriesrecap.SeriesRecap.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;

    public User(int id, String userName, String password, List<Series> series) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public User(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
