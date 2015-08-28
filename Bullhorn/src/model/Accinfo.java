package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


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

	@Temporal(TemporalType.DATE)
	private Date dates;

	@Column(name="F_NAME")
	private String fName;

	private String moto;

	private String password;

	public Accinfo() {
	}

	public long getAId() {
		return this.aId;
	}

	public void setAId(long aId) {
		this.aId = aId;
	}

	public Date getDates() {
		return this.dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getMoto() {
		return this.moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}