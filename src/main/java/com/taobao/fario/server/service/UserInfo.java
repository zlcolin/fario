package com.taobao.fario.server.service;

// Generated 2012-6-12 17:01:23 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo generated by hbm2java
 */
public class UserInfo implements java.io.Serializable {

	private int id;
	private String name;
	private String password;
	private Character sex;
	private String telephone;
	private String nickname;
	private Set<Locationhistory> locationhistories = new HashSet<Locationhistory>(
			0);

	public UserInfo() {
	}

	public UserInfo(int id, String password) {
		this.id = id;
		this.password = password;
	}

	public UserInfo(int id, String name, String password, Character sex,
			String telephone, String nickname,
			Set<Locationhistory> locationhistories) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.telephone = telephone;
		this.nickname = nickname;
		this.locationhistories = locationhistories;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getSex() {
		return this.sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Set<Locationhistory> getLocationhistories() {
		return this.locationhistories;
	}

	public void setLocationhistories(Set<Locationhistory> locationhistories) {
		this.locationhistories = locationhistories;
	}

}
