package com.hieu.backend.metamodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.hieu.backend.entity.Book;
import com.hieu.backend.entity.ProductGroup;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductGroup.class)
public class ProductGroup_ {
	public static volatile SingularAttribute<ProductGroup, Long> id;
	public static volatile ListAttribute<ProductGroup, Book> books;
}
