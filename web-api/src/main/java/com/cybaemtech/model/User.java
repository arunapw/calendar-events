package com.cybaemtech.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public final class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
	@SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotEmpty(message = "Username is required")
	@Size(max = 50, message = "Username must be less than 50 characters")
	@Column(name = "username")
	private String username;

	@NotEmpty(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(name = "email")
	private String email;

	@NotEmpty(message = "City is required")
	@Size(max = 50, message = "City must be less than 50 characters")
	@Column(name = "city")
	private String city;

	public User()
	{
	}

	public User(Long id, String username, String email, String city)
	{
		this.id = id;
		this.username = username;
		this.email = email;
		this.city = city;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	@Override
	public String toString()
	{
		return "User{" +
			   "id=" + id +
			   ", username='" + username + '\'' +
			   ", email='" + email + '\'' +
			   ", city='" + city + '\'' +
			   '}';
	}
}
