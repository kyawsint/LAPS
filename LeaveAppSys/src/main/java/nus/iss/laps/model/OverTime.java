package nus.iss.laps.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="overtimeworkdetails")
public class OverTime {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int otid;
private Date otdate;
private Double noOfHours ;
private int staffid;

public int getOtid() {
	return otid;
}
public void setOtid(int otid) {
	this.otid = otid;
}
public Date getOtdate() {
	return otdate;
}
public void setOtdate(Date otdate) {
	this.otdate = otdate;
}
public Double getNoOfHours() {
	return noOfHours;
}
public void setNoOfHours(Double noOfHours) {
	this.noOfHours = noOfHours;
}
public int getStaffid() {
	return staffid;
}
public void setStaffid(int staffid) {
	this.staffid = staffid;
}


}
