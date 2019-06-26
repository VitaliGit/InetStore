package com.vironit.store.entity.person;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vironit.store.entity.cart.Cart;
import com.vironit.store.validation.PasswordAnnotation;

@Entity
@Table(name="users")
@JsonIgnoreProperties(ignoreUnknown=true)
public class User{
	
	@Id
	@Column(name="username")
	@NotNull(message="(*) Le champ est obligatoire")
	@Size(min=5, max=15, message="Cela ne peut pas dépasser 15 caractères (au minimum 5 sont demandés)")
	@Pattern(regexp="\\w+", message="Des caractères spéciaux ne sont pas admissibles")
	private String userName;
	
	@Column(name="password")
	@NotNull(message="(*) Le champ est obligatoire")
	@PasswordAnnotation
	private String password;
	
	@Column(name="enabled")
	private short enabled;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="character")
	private String character;// type of a dude
	
	@Column(name="connection_number")
	private int connectionNumber;
	
	@Column(name="phone_number")
	@NotNull(message="(*) Le champ est obligatoire")
	@Pattern(regexp="\\+\\d{8,15}", message="(!) Le numéro est invalide: il doit commencer par +(code du pays)")
	private String phoneNumber;
	

	@OneToOne(mappedBy="userName", cascade=CascadeType.ALL)
	@JsonManagedReference()
	private Authority authority;
	
	
	@OneToMany(mappedBy="userName", fetch=FetchType.EAGER)
	private List<Cart> carts;

	

	public User() {
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
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

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getConnectionNumber() {
		return connectionNumber;
	}

	public void setConnectionNumber(int connectionNumber) {
		this.connectionNumber = connectionNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User(
			String userName, String password, short enabled,
			LocalDateTime updatedDate, LocalDateTime createdDate, String character, int connectionNumber, String phoneNumber) {

		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.character = character;
		this.connectionNumber = connectionNumber;
		this.phoneNumber = phoneNumber;
	}

	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + connectionNumber;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + enabled;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (connectionNumber != other.connectionNumber)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (enabled != other.enabled)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", enabled=" + enabled + ", updatedDate="
				+ updatedDate + ", createdDate=" + createdDate + ", character=" + character + ", connectionNumber="
				+ connectionNumber + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	}