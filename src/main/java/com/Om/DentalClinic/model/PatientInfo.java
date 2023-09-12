package com.Om.DentalClinic.model;


import java.util.Arrays;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "tbl_patient_info")
public class PatientInfo {
	
	@Id
	@Column(name = "patient_num")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientnumber;
			
	@Column(name = "fname")
	private String firstname;
	
	@Column(name = "mname")
	private String middlename;
	
	@Column(name = "lname")
	private String lastname;
	
	@Column(name = "age")
	private int patientage;
	
	@Column(name = "gender")
	private String patientgender;
	
	@Column(name = "reg_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date patientregdate;
	
	@Column(name = "mobile_one")
	private int patientmobile1;
	
	@Column(name = "mobile_two")
	private int patientmobile2;
	
	@Column(name = "medical_history")
	private String patientmedicalhistory;
	
	@Column(name = "info_cashier_name")
	private String cashiername;
	
	@Column(name = "info_timestamp")
	private Date timestamp;
	
    @Lob
    @Column(name = "reports")
    private byte[] patientReports;

	public PatientInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientInfo(int patientnumber, String firstname, String middlename, String lastname, int patientage,
			String patientgender, Date patientregdate, int patientmobile1, int patientmobile2,
			String patientmedicalhistory, String cashiername, Date timestamp, byte[] patientReports) {
		super();
		this.patientnumber = patientnumber;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.patientage = patientage;
		this.patientgender = patientgender;
		this.patientregdate = patientregdate;
		this.patientmobile1 = patientmobile1;
		this.patientmobile2 = patientmobile2;
		this.patientmedicalhistory = patientmedicalhistory;
		this.cashiername = cashiername;
		this.timestamp = timestamp;
		this.patientReports = patientReports;
	}

	public int getPatientnumber() {
		return patientnumber;
	}

	public void setPatientnumber(int patientnumber) {
		this.patientnumber = patientnumber;
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

	public int getPatientmobile1() {
		return patientmobile1;
	}

	public void setPatientmobile1(int patientmobile1) {
		this.patientmobile1 = patientmobile1;
	}

	public int getPatientmobile2() {
		return patientmobile2;
	}

	public void setPatientmobile2(int patientmobile2) {
		this.patientmobile2 = patientmobile2;
	}

	public String getPatientmedicalhistory() {
		return patientmedicalhistory;
	}

	public void setPatientmedicalhistory(String patientmedicalhistory) {
		this.patientmedicalhistory = patientmedicalhistory;
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

	public byte[] getPatientReports() {
		return patientReports;
	}

	public void setPatientReports(byte[] patientReports) {
		this.patientReports = patientReports;
	}

	@Override
	public String toString() {
		return "PatientInfo [patientnumber=" + patientnumber + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", patientage=" + patientage + ", patientgender=" + patientgender
				+ ", patientregdate=" + patientregdate + ", patientmobile1=" + patientmobile1 + ", patientmobile2="
				+ patientmobile2 + ", patientmedicalhistory=" + patientmedicalhistory + ", cashiername=" + cashiername
				+ ", timestamp=" + timestamp + ", patientReports=" + Arrays.toString(patientReports)
				+ ", getPatientnumber()=" + getPatientnumber() + ", getFirstname()=" + getFirstname()
				+ ", getMiddlename()=" + getMiddlename() + ", getLastname()=" + getLastname() + ", getPatientage()="
				+ getPatientage() + ", getPatientgender()=" + getPatientgender() + ", getPatientregdate()="
				+ getPatientregdate() + ", getPatientmobile1()=" + getPatientmobile1() + ", getPatientmobile2()="
				+ getPatientmobile2() + ", getPatientmedicalhistory()=" + getPatientmedicalhistory()
				+ ", getCashiername()=" + getCashiername() + ", getTimestamp()=" + getTimestamp()
				+ ", getPatientReports()=" + Arrays.toString(getPatientReports()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




}