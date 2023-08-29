package com.Om.DentalClinic.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


@Entity
//@IdClass(PatientInfoId.class)
public class PatientInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientid;
	
	@Id
	private String patientnumber;
	private String patientname;
	private int patientage;
	private String patientgender;
	private Date patientregdate;
	private int patientmobile;
	private String patientmedicalhistory;
	
	public PatientInfo() {
		super();
	
	}
	
	public PatientInfo(int patientid, String patientnumber, String patientname, int patientage, String patientgender,
			Date patientregdate, int patientmobile, String patientmedicalhistory) {
		super();
		this.patientid = patientid;
		this.patientnumber = patientnumber;
		this.patientname = patientname;
		this.patientage = patientage;
		this.patientgender = patientgender;
		this.patientregdate = patientregdate;
		this.patientmobile = patientmobile;
		this.patientmedicalhistory = patientmedicalhistory;
	}

	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getPatientnumber() {
		return patientnumber;
	}
	public void setPatientnumber(String patientnumber) {
		this.patientnumber = patientnumber;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public int getPatientage() {
		return patientage;
	}
	public void setPatientage(int patientage) {
		this.patientage = patientage;
	}
	public String getPatientgender() {
		return patientgender;
	}
	public void setPatientgender(String patientgender) {
		this.patientgender = patientgender;
	}
	public Date getPatientregdate() {
		return patientregdate;
	}
	public void setPatientregdate(Date patientregdate) {
		this.patientregdate = patientregdate;
	}
	public int getPatientmobile() {
		return patientmobile;
	}
	public void setPatientmobile(int patientmobile) {
		this.patientmobile = patientmobile;
	}
	public String getPatientmedicalhistory() {
		return patientmedicalhistory;
	}
	public void setPatientmedicalhistory(String patientmedicalhistory) {
		this.patientmedicalhistory = patientmedicalhistory;
	}

	@Override
	public String toString() {
		return "PatientInfo [patientid=" + patientid + ", patientnumber=" + patientnumber + ", patientname="
				+ patientname + ", patientage=" + patientage + ", patientgender=" + patientgender + ", patientregdate="
				+ patientregdate + ", patientmobile=" + patientmobile + ", patientmedicalhistory="
				+ patientmedicalhistory + ", getPatientid()=" + getPatientid() + ", getPatientnumber()="
				+ getPatientnumber() + ", getPatientname()=" + getPatientname() + ", getPatientage()=" + getPatientage()
				+ ", getPatientgender()=" + getPatientgender() + ", getPatientregdate()=" + getPatientregdate()
				+ ", getPatientmobile()=" + getPatientmobile() + ", getPatientmedicalhistory()="
				+ getPatientmedicalhistory() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
