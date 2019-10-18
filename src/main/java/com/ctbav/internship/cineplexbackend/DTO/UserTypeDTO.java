package com.ctbav.internship.cineplexbackend.DTO;

import com.ctbav.internship.cineplexbackend.models.UserType;

public class UserTypeDTO {
	Long id;
	String typeName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public UserTypeDTO(Long id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	public UserTypeDTO(UserType userType) {
		
	}
	@Override
	public String toString() {
		return "UserTypeDTO [id=" + id + ", typeName=" + typeName + "]";
	}

}
