package com.Om.DentalClinic.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_appointment")
public class Appointment {

	
	@Id
	@Column(name = "appointment_num")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int appointmentnum;
	
	@Column(name = "fname")
	private String firstname;
	
	@Column(name = "mname")
	private String middlename;
	
	@Column(name = "lname")
	private String lastname;
	
	@Column(name = "treatment")
	private String treatment;
	
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date starttime;

    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date endtime;

	
	@Column(name = "mobile_num")
	private long patientmobile1;
	
	@Column(name = "appoint_cashier_name")
	private String cashiername;
	
	@Column(name = "appoint_timestamp")
	private Date timestamp;
	
	@PrePersist
    protected void onCreate() {
        timestamp = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        timestamp = new Date();
    }
	
	public Appointment() {
		super();
		
	}

	public int getAppointmentnum() {
		return appointmentnum;
	}

	public void setAppointmentnum(int appointmentnum) {
		this.appointmentnum = appointmentnum;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public long getPatientmobile1() {
		return patientmobile1;
	}

	public void setPatientmobile1(long patientmobile1) {
		this.patientmobile1 = patientmobile1;
	}

	public String getCashiername() {
		return cashiername;
	}

	public void setCashiername(String cashiername) {
		this.cashiername = cashiername;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentnum=" + appointmentnum + ", firstname=" + firstname + ", middlename="
				+ middlename + ", lastname=" + lastname + ", treatment=" + treatment + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", patientmobile1=" + patientmobile1 + ", cashiername=" + cashiername
				+ ", timestamp=" + timestamp + "]";
	}

	public Appointment(int appointmentnum, String firstname, String middlename, String lastname, String treatment,
			Date starttime, Date endtime, long patientmobile1, String cashiername, Date timestamp) {
		super();
		this.appointmentnum = appointmentnum;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.treatment = treatment;
		this.starttime = starttime;
		this.endtime = endtime;
		this.patientmobile1 = patientmobile1;
		this.cashiername = cashiername;
		this.timestamp = timestamp;
	}

	
}
