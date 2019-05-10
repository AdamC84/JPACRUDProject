package com.skilldistillery.PGA.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Golfer {
	@Id
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="pga_wins")
	private int pgaWins;
	@Column(name="college_attended")
	private String collegeAttended;
	@Column(name="total_earnings")
	private int totalEarnings;
	
	public Golfer() {
		super();
	}
	@Override
	public String toString() {
		return "Golfer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pgaWins=" + pgaWins
				+ ", collegeAttended=" + collegeAttended + ", totalEarnings=" + totalEarnings + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPgaWins() {
		return pgaWins;
	}
	public void setPgaWins(int pgaWins) {
		this.pgaWins = pgaWins;
	}
	public String getCollegeAttended() {
		return collegeAttended;
	}
	public void setCollegeAttended(String collegeAttended) {
		this.collegeAttended = collegeAttended;
	}
	public int getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(int totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	
	
	

}
