package nus.iss.laps.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="staff_details")
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
    private int staffid;
	private String staff_name;
	private String userid;
	private int reportsTo;
	private Double compOffConsumed;
	private Double totalOTHours;
	private Date dob;
	private String address;
	private String contactno;
	private String emailid;
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
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
	public Double getCompOffConsumed() {
		return compOffConsumed;
	}
	public void setCompOffConsumed(Double compOffConsumed) {
		this.compOffConsumed = compOffConsumed;
	}
	public Double getTotalOTHours() {
		return totalOTHours;
	}
	public void setTotalOTHours(Double totalOTHours) {
		this.totalOTHours = totalOTHours;
	}

}
