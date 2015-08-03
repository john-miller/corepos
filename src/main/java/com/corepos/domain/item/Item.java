package com.corepos.domain.item;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.corepos.domain.barcode.BarCode;

@Entity
@Table(name = "Items")
public class Item {
	
	@Id
	private long id;
	
	@Column(name = "NAME")
	private String name;
		
	@OneToMany
	private Collection<? extends BarCode> barcodes;
	
	@OneToMany
	private Collection <? extends ItemAttribute> attributes;
	
	
}
