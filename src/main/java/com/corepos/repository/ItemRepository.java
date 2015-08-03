package com.corepos.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corepos.domain.barcode.BarCode;
import com.corepos.domain.item.Item;
import com.corepos.domain.item.ItemAttribute;

public interface ItemRepository extends JpaRepository<Item, Long> {

	public Collection<Item> findByAttributes(Collection<ItemAttribute> attributes);
	
	public Item findByBarcodes(BarCode barCode);
	
}
