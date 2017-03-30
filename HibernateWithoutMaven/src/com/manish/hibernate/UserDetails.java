package com.manish.hibernate;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity /*(name="user_details")*/          //we can customize the name of the table accordingly with name parameter of entity annotation
/*@Table (name="user_details") */              //Chnages the table name according to the name parameter but doesnt change the entity name
public class UserDetails {
	/*@Id							
	@Column (name="user_id")*/				//we can customize the name of the column accordingly with name parameter of column annotation
	private int userId;
	@Temporal(TemporalType.DATE) 				//Temporal annnotation let you choose between date or time (default is timestamp)
	private Date joinedDate;
	@Embedded							//This could be use to embed address if @Embeddable is not provided over Address class*/	
	private Address homeAddress;

	
	private Address officeAddress;

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name="street",column=@Column(name="OFFICE_STREET")),
		@AttributeOverride(name="state",column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="pincode",column=@Column(name="OFFICE_PINCODE")),
		@AttributeOverride(name="city",column=@Column(name="OFFICE_CITY"))})
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Lob									//Lob(large objects) changes default varchar255 to Lob which enables us to enter free text
	private String description;


	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String userName;
	@Id /*@GeneratedValue (strategy=GenerationType.AUTO)*/  //Generate surrogate key..ie. we need not provide the values it will aoto generate.
	/*@Column (name="user_id")*/			//we can put annnotations over getters instead of variables as well
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/*@Column (name="user_name")*/
	/*@Transient*/								//It enables us to skip the column which we dont want to save in the database
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}





}
