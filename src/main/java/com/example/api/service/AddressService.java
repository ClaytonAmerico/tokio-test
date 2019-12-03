package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Address;
import com.example.api.repository.AddressRepository;

@Service
public class AddressService {

	private AddressRepository repository;

	@Autowired
	public AddressService(AddressRepository repository) {
		this.repository = repository;
	}

	public List<Address> findAll() {
		return repository.findAll();
	}

	public Optional<Address> findById(Long id) {
		return repository.findById(id);
	}

	public Address save(Address address) {
		return repository.save(address);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Address updateAddress(Long code, Address address) {
		Optional<Address> addressSave = findById(code);
		BeanUtils.copyProperties(address, addressSave, "code");
		return repository.save(addressSave.get());
	}

}
