package nus.iss.laps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave_details")
public class Leave {
	
	@Id
	@GeneratedValue
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leaveID")
	private long leaveId;
	private long staffId;
	private long leaveTypeId;
	private Date fromDate;
	private Double noOfDays;
	private String leaveStatus;
	private String contactAddress;
	private String comments;
	private String reasonForLeave;
	
	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public long getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Double getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Double noOfDays) {
		this.noOfDays = noOfDays;
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
}
