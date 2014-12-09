package nus.iss.laps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="leave_details")
@NamedQuery(name="Leave_Details.findByStaffID",query="Select l from Leave_Details l where l.staffID LIKE :staffID and leavetypeid<>1")
public class Leave_Details {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int leaveID;
	@Column(name="staffID")
	private int staffID;
	@Column(name="fromDate")
	private Date fromDate;
	@Column(name="noOfDays")
	private double noOfDays;
	@Column(name="leaveTypeID")
	private int leaveTypeID;
	@Column(name="leaveStatus")
	private String leaveStatus;
	@Column(name="contactAddress")
	private String contactAddress;
	@Column(name="comments")
	private String comments;
	@Column(name="reasonForLeave")
	private String reasonForLeave;
	//
	@ManyToOne
	@JoinColumn(name="staffid")
	private staff_details sd;
	//
	
	public int getLeaveID() {
		return leaveID;
	}
	public staff_details getSd() {
		return sd;
	}
	public void setSd(staff_details sd) {
		this.sd = sd;
	}
	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public double getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(double noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getLeaveTypeID() {
		return leaveTypeID;
	}
	public void setLeaveTypeID(int leaveTypeID) {
		this.leaveTypeID = leaveTypeID;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getReasonForLeave() {
		return reasonForLeave;
	}
	public void setReasonForLeave(String reasonForLeave) {
		this.reasonForLeave = reasonForLeave;
	}
//	@Override
//	public String toString() {
//		return "Leave_Details [leaveID=" + leaveID + ", staffID=" + staffID
//				+ ", fromDate=" + fromDate + ", noOfDays=" + noOfDays
//				+ ", leaveTypeID=" + leaveTypeID + ", leaveStatus="
//				+ leaveStatus + ", contactAddress=" + contactAddress
//				+ ", comments=" + comments + ", reasonForLeave="
//				+ reasonForLeave + "]";
//	}
	
	
	
}
