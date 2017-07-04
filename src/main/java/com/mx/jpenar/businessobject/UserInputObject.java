package com.mx.jpenar.businessobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class UserInputObject {
	private String id;
	private String name;
	private String apePat;
	private String apeMat;
	private String address;
	private String phone;
	private String email;

	@JsonProperty(required = true)
	@ApiModelProperty(value = "Unique ID", required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(value = "First name", required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(value = "Last name", required = true)
	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(value = "Mother's last name", required = true)
	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(value = "Address", required = true)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty(required = false)
	@ApiModelProperty(value = "Phone", required = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(value = "Email", required = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
