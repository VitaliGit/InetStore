package com.vironit.store.entity.cart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vironit.store.entity.Status;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.person.User;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.entity.tablet.Tablet;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;

@Entity
@Table(name="t_cart")
@JsonIgnoreProperties(ignoreUnknown=true)
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class Cart {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_name")
	private User userName;
	
	@ManyToMany(mappedBy = "cart")
	private List <Book> idBook;
	
	@ManyToMany
	@JoinTable(name="t_order", joinColumns=@JoinColumn(name="cart_id"),
								inverseJoinColumns=@JoinColumn(name="tablet_id"))
	private List <Tablet> idTablet;
	
	@ManyToMany
	@JoinTable(name="t_order", joinColumns=@JoinColumn(name="cart_id"),
								inverseJoinColumns=@JoinColumn(name="laptop_id"))
	private List <Laptop> idLaptop;
	
	@ManyToMany
	@JoinTable(name="t_order", joinColumns=@JoinColumn(name="cart_id"),
								inverseJoinColumns=@JoinColumn(name="phone_id"))
	private List <Phone> idPhone;
	

	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="order_date")
	private LocalDateTime orderDate;
	@Column(name="total_price")
	private int totalPrice;


	@Enumerated(value=EnumType.STRING)
	@Column(name="status")
	@Type( type = "pgsql_enum" )
	private Status status;
	
	public Cart() {

	}
	
	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUserName() {
		return userName;
	}


	public void setUserName(User userName) {
		this.userName = userName;
	}

	public List<Book> getIdBook() {
		return idBook;
	}


	public void setIdBook(List<Book> idBook) {
		this.idBook = idBook;
	}


	public List<Tablet> getIdTablet() {
		return idTablet;
	}


	public void setIdTablet(List<Tablet> idTablet) {
		this.idTablet = idTablet;
	}


	public List<Laptop> getIdLaptop() {
		return idLaptop;
	}


	public void setIdLaptop(List<Laptop> idLaptop) {
		this.idLaptop = idLaptop;
	}


	public List<Phone> getIdPhone() {
		return idPhone;
	}


	public void setIdPhone(List<Phone> idPhone) {
		this.idPhone = idPhone;
	}
	public void addBook(Book theBook) {
		if(idBook==null)
			idBook=new ArrayList<>();
			idBook.add(theBook);
	}
	public void addLaptop(Laptop theLaptop) {
		if(idLaptop==null)
			idLaptop=new ArrayList<>();
			idLaptop.add(theLaptop);
	}
	public void addPhone(Phone thePhone) {
		if(idPhone==null)
			idPhone=new ArrayList<>();
			idPhone.add(thePhone);
	}
	public void addTablet(Tablet theTablet) {
		if(idTablet==null)
			idTablet=new ArrayList<>();
			idTablet.add(theTablet);
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


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + totalPrice;
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
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
		Cart other = (Cart) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id != other.id)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}


	public Cart(int id, LocalDateTime updatedDate, LocalDateTime createdDate, LocalDateTime orderDate, int totalPrice, Status status) {
		this.id = id;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate + ", orderDate="
				+ orderDate + ", totalPrice=" + totalPrice + "]";
	}

}
