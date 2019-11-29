package com.example.api.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String number;
	private String complement;
	private String district;
	private String zipCode;
	private String cidadecity;
	private String state;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCidadecity() {
		return cidadecity;
	}

	public void setCidadecity(String cidadecity) {
		this.cidadecity = cidadecity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
