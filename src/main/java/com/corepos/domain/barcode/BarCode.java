package com.corepos.domain.barcode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BARCODES")
public class BarCode {
	
	@Id
	private long id;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "value")
	private String value;
	
}
