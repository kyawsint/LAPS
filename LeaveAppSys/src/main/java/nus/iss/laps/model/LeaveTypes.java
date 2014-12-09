package nus.iss.laps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="leavetypes")
public class LeaveTypes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int typeid;
private String leaveName;


public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public String getLeaveName() {
	return leaveName;
}
public void setLeaveName(String leaveName) {
	this.leaveName = leaveName;
}


}
