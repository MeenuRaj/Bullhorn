package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ACCINFO database table.
 * 
 */ 
@Entity
@Table(name="Accinfo", schema="TESTDB")
@NamedQuery(name="Accinfo.findAll", query="SELECT a FROM Accinfo a")
public class Accinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="A_ID")
	private long aId;

	private String password;

	private String username;

	public Accinfo() {
	}

	public long getAId() {
		return this.aId;
	}

	public void setAId(long aId) {
		this.aId = aId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}