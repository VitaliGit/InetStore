package com.vironit.store.entity.builder;

import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.book.BookPlan;

public class BookBuilder extends BookPlan {
	private int price;
	private boolean available;
	private int discount;
	
	private String title;
	private String author;
	private String ageGroup;
	private String genre;
	
	private int id;

	
	public Book build () {
		Book book = new Book();
		book.setPrice(this.price);
		book.setAvailable(this.available);
		book.setDiscount(this.discount);
		book.setTitle(this.title);
		book.setAuthor(this.author);
		book.setAgeGroup(this.ageGroup);
		book.setGenre(this.genre);
		book.setId(this.id);
		return book;
	}

	@Override
	public BookBuilder withPrice(final int price) {
		this.price = price;
		return this;
	}
	@Override
	public BookBuilder withAvailable(final boolean available) {
		this.available = available;
		return this;
	}
	@Override
	public BookBuilder withDiscount(final int discount) {
		this.discount = discount;
		return this;
	}
	@Override
	public BookBuilder withTitle(final String title) {
		this.title=title;
		return this;
	}
	@Override
	public BookBuilder withAuthor(final String author) {
		this.author=author;
		return this;
	}
	@Override
	public BookBuilder withAgeGroup(final String ageGroup) {
		this.ageGroup=ageGroup;
		return this;
	}
	@Override
	public BookBuilder withGenre(final String genre) {
		this.genre=genre;
		return this;
	}

	@Override
	public BookBuilder withID(final int id) {
		this.id=id;
		return this;
	}


}

