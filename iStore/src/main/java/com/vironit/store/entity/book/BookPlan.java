package com.vironit.store.entity.book;

import com.vironit.store.entity.AllGood;
import com.vironit.store.entity.builder.BookBuilder;

public abstract class BookPlan  extends AllGood{
	
	protected abstract BookBuilder withTitle(String title);
	protected abstract BookBuilder withAuthor(String author);
	protected abstract BookBuilder withAgeGroup(String ageGroup);
	protected abstract BookBuilder withGenre(String genre);

}



