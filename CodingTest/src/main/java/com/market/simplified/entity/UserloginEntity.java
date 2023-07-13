package com.market.simplified.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="UserLogin")
@Getter
@Setter
@NoArgsConstructor

public class UserloginEntity {
	@Id
	@GeneratedValue
	@Column(name="USERID")
	private Integer userId;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String passWord;
	
	@Column(name="DECLINATION")
	private String declination;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getDeclination() {
		return declination;
	}

	public void setDeclination(String declination) {
		this.declination = declination;
	}
	
	
	
	
}