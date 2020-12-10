package com.example.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class District {

	@Id
	private Integer districtId;
	
	private String cityId;
	
	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}
