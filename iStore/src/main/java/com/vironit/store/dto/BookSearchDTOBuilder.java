package com.vironit.store.dto;

public class BookSearchDTOBuilder {
	
	private int price;
	private boolean available;
	private int discount;
	
	private String title;
	private String author;
	private String ageGroup;
	private String genre;
	
	public BookSearchDTO build() {
		BookSearchDTO bookSearchDTO = new BookSearchDTO();
		bookSearchDTO.setAvailable(available);
		bookSearchDTO.setDiscount(discount);
		bookSearchDTO.setPrice(price);
		bookSearchDTO.setTitle(title);
		bookSearchDTO.setAuthor(author);
		bookSearchDTO.setAgeGroup(ageGroup);
		bookSearchDTO.setGenre(genre);
		return bookSearchDTO;
	}
	
	public BookSearchDTOBuilder withPrice(final int price) {
		this.price=price;
		return this;
	}
	public BookSearchDTOBuilder withDiscount(final int discount) {
		this.discount=discount;
		return this;
	}
	public BookSearchDTOBuilder withAvailable(final boolean available) {
		this.available=available;
		return this;
	}
	public BookSearchDTOBuilder withTitle(final String title) {
		this.title=title;
		return this;
	}
	public BookSearchDTOBuilder withAuthor(final String author) {
		this.author=author;
		return this;
	}
	public BookSearchDTOBuilder withAgeGroup(final String ageGroup) {
		this.ageGroup=ageGroup;
		return this;
	}
	public BookSearchDTOBuilder withGenre(final String genre) {
		this.genre=genre;
		return this;
	}
	
}
