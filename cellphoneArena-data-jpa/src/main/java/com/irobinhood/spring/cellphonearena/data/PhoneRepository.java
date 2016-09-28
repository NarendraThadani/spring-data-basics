package com.irobinhood.spring.cellphonearena.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {

	
	List<Phone> findByName(String name);
}
