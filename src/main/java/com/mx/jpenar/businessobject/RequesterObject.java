package com.mx.jpenar.businessobject;

public class RequesterObject {
	private String country;
	private String companyName;
	private String email;
	private String name;
	private String locale;
	private long entitlementId;

	public String getCountry() {
		return country;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getLocale() {
		return locale;
	}

	public long getEntitlementId() {
		return entitlementId;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setEntitlementId(long entitlementId) {
		this.entitlementId = entitlementId;
	}

}
