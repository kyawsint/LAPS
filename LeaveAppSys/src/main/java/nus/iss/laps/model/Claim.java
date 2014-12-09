package nus.iss.laps.model;

import java.sql.Date;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="leave_details")
public class Claim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int leaveID;

		private int staffID;

		private Date fromDate;
		private Double noOfDays;
		
		private int leaveTypeID;
		private String contactAddress;
		private String reasonForLeave;
		private String comments;
		private String leaveStatus;
		@Transient
		private Double totalOTHours;
		
		@Transient
		private String leaveName;
		
		@ManyToOne
		@JoinColumn(name="staffid")
		@Transient
		private Staff sn;
		
		public Staff getSn() {
			return sn;
		}
		public void setSn(Staff sn) {
			this.sn = sn;
		}
		
		
		
		
		@Override
		public String toString() {
			return "Claim [leaveID=" + leaveID + ", staffID=" + staffID
					+ ", fromDate=" + fromDate + ", noOfDays=" + noOfDays
					+ ", leaveTypeID=" + leaveTypeID + ", contactAddress="
					+ contactAddress + ", reasonForLeave=" + reasonForLeave
					+ ", comments=" + comments + ", leaveStatus=" + leaveStatus
					+ ", totalOTHours=" + totalOTHours + ", leaveName="
					+ leaveName + ", sn=" + sn + "]";
		}
		public String getLeaveName() {
			return leaveName;
		}
		public void setLeaveName(String leaveName) {
			this.leaveName = leaveName;
		}
		public Double getTotalOTHours() {
			return totalOTHours;
		}
		public void setTotalOTHours(Double totalOTHours) {
			this.totalOTHours = totalOTHours;
		}
		public String getLeaveStatus() {
			return leaveStatus;
		}
		public void setLeaveStatus(String leaveStatus) {
			this.leaveStatus = leaveStatus;
		}
		public int getLeaveTypeID() {
			return leaveTypeID;
		}
		public void setLeaveTypeID(int leaveTypeID) {
			this.leaveTypeID = leaveTypeID;
		}
		public String getContactAddress() {
			return contactAddress;
		}
		public void setContactAddress(String contactAddress) {
			this.contactAddress = contactAddress;
		}
		public String getReasonForLeave() {
			return reasonForLeave;
		}
		public void setReasonForLeave(String reasonForLeave) {
			this.reasonForLeave = reasonForLeave;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		
	public int getLeaveID() {
		return leaveID;
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
	public Double getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Double noOfDays) {
		this.noOfDays = noOfDays;
	}
	
	
	
	
	
}
