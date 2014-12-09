package nus.iss.laps.controller;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class staff_details {
	@Id
    private int staffid;
	private String staff_name;
	private String userid;
	private int reportsTo;
	private Double compOffConsumed;
	private Double totalOTHours;
	
public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staff_id) {
		this.staffid = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	public double getCompOffConsumed() {
		return compOffConsumed;
	}
	public void setCompOffConsumed(double compOffConsumed) {
		this.compOffConsumed = compOffConsumed;
	}
	public Double getTotalOTHours() {
		return totalOTHours;
	}
	public void setTotalOTHours(Double totalOTHours) {
		this.totalOTHours = totalOTHours;
	}
}
