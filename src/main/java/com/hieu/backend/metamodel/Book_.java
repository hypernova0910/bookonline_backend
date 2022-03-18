package com.hieu.backend.metamodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.hieu.backend.entity.Book;
import com.hieu.backend.entity.Genre;
import com.hieu.backend.entity.ProductGroup;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public class Book_ {
	public static volatile SingularAttribute<Book, Long> id;
	
	public static volatile ListAttribute<Book, ProductGroup> productGroups;
	public static volatile ListAttribute<Book, Genre> genres;
}
