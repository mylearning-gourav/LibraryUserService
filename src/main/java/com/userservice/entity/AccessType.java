package com.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Gourav Singh
 * AccessType Entity Class
 */
@Entity
@Table(name="access_types")
public class AccessType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int accessTypeId;
	@Column(name="access_type")
	private String accessType;
	private String description;
	private boolean active;
	
	public int getAccessTypeId() {
		return accessTypeId;
	}
	public void setAccessTypeId(int accessTypeId) {
		this.accessTypeId = accessTypeId;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
