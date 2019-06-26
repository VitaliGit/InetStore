package com.vironit.store.entity.book;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vironit.store.entity.cart.Cart;

@Entity
@Table(name="t_books")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Book{
	@Column(name="price")
	private int price;
	@Column(name="is_present")
	private boolean available;
	@Column(name="discount")
	private int discount;
	
	@Column(name="title")
	private String title;
	@Column(name="author")
	private String author;
	@Column(name="age_group")
	private String ageGroup;
	@Column(name="genre")
	private String genre;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@ManyToMany()
	@JoinTable(name="t_order", 
		joinColumns= @JoinColumn(name="book_id"),
		inverseJoinColumns= @JoinColumn(name="cart_id"))
	private List<Cart> cart;

	public Book() {
		} // no-args
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageGroup == null) ? 0 : ageGroup.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + discount;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (ageGroup == null) {
			if (other.ageGroup != null)
				return false;
		} else if (!ageGroup.equals(other.ageGroup))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (available != other.available)
			return false;
		if (discount != other.discount)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [price=" + price + ", available=" + available + ", discount=" + discount + ", title=" + title
				+ ", author=" + author + ", ageGroup=" + ageGroup + ", genre=" + genre + ", id=" + id + "]";
	}
	

}
