package com.example.api.web.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Address;
import com.example.api.event.ResourceEventCreated;
import com.example.api.service.AddressService;

@RestController
@RequestMapping("/address")
public class AdressController {

	@Autowired
	private AddressService service;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Address> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Address findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
	}
	
	@PostMapping
	public ResponseEntity<Address> create(@Valid @RequestBody Address address, HttpServletResponse response) {
		Address saveAddress = service.save(address);
		publisher.publishEvent(new ResourceEventCreated(this, response, saveAddress.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAddress);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(Long code) {
		service.deleteById(code);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> update(@PathVariable Long id, @Valid @RequestBody Address address) {
		Address saveAddress = service.updateAddress(id, address);
		return ResponseEntity.ok(saveAddress);
	}

}
