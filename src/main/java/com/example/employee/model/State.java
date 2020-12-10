package com.example.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {

	@Id
	private Integer stateId;
	
	private String cityId;
	
	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

}
