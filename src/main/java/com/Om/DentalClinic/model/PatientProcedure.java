package com.Om.DentalClinic.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_patient_procedure")
public class PatientProcedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proc_id")
	private int patientprocedureid;
	  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proc_patient_num", referencedColumnName = "patient_num")
	private PatientInfo patientprocedurenumber;
	
    @Column(name = "proc_date")
	private Date patientproceduredate;
	
    @Column(name = "proc_details")
    private String patientproceduredetail;
	
    @Column(name = "proc_estimate_amount")
    private Double patientprocedureestimateamount;
	
    @Column(name = "proc_payment_type")
    private String patientprocedurepaymenttype;
	
    @Column(name = "proc_payment_amount")
    private Double patientprocedurepaymentamount;
	
    @Column(name = "proc_lab_name")
    private String patientprocedurelabname;

	public int getPatientprocedureid() {
		return patientprocedureid;
	}

	public void setPatientprocedureid(int patientprocedureid) {
		this.patientprocedureid = patientprocedureid;
	}

	public PatientInfo getPatientprocedurenumber() {
		return patientprocedurenumber;
	}

	public void setPatientprocedurenumber(PatientInfo patientprocedurenumber) {
		this.patientprocedurenumber = patientprocedurenumber;
	}

	public Date getPatientproceduredate() {
		return patientproceduredate;
	}

	public void setPatientproceduredate(Date patientproceduredate) {
		this.patientproceduredate = patientproceduredate;
	}

	public String getPatientproceduredetail() {
		return patientproceduredetail;
	}

	public void setPatientproceduredetail(String patientproceduredetail) {
		this.patientproceduredetail = patientproceduredetail;
	}

	public double getPatientprocedureestimateamount() {
		return patientprocedureestimateamount;
	}

	public void setPatientprocedureestimateamount(double patientprocedureestimateamount) {
		this.patientprocedureestimateamount = patientprocedureestimateamount;
	}

	public String getPatientprocedurepaymenttype() {
		return patientprocedurepaymenttype;
	}

	public void setPatientprocedurepaymenttype(String patientprocedurepaymenttype) {
		this.patientprocedurepaymenttype = patientprocedurepaymenttype;
	}

	public double getPatientprocedurepaymentamount() {
		return patientprocedurepaymentamount;
	}

	public void setPatientprocedurepaymentamount(double patientprocedurepaymentamount) {
		this.patientprocedurepaymentamount = patientprocedurepaymentamount;
	}

	public String getPatientprocedurelabname() {
		return patientprocedurelabname;
	}

	public void setPatientprocedurelabname(String patientprocedurelabname) {
		this.patientprocedurelabname = patientprocedurelabname;
	}

	@Override
	public String toString() {
		return "PatientProcedure [patientprocedureid=" + patientprocedureid + ", patientprocedurenumber="
				+ patientprocedurenumber + ", patientproceduredate=" + patientproceduredate
				+ ", patientproceduredetail=" + patientproceduredetail + ", patientprocedureestimateamount="
				+ patientprocedureestimateamount + ", patientprocedurepaymenttype=" + patientprocedurepaymenttype
				+ ", patientprocedurepaymentamount=" + patientprocedurepaymentamount + ", patientprocedurelabname="
				+ patientprocedurelabname + "]";
	}

	public PatientProcedure(int patientprocedureid, PatientInfo patientprocedurenumber, Date patientproceduredate,
			String patientproceduredetail, double patientprocedureestimateamount, String patientprocedurepaymenttype,
			double patientprocedurepaymentamount, String patientprocedurelabname) {
		super();
		this.patientprocedureid = patientprocedureid;
		this.patientprocedurenumber = patientprocedurenumber;
		this.patientproceduredate = patientproceduredate;
		this.patientproceduredetail = patientproceduredetail;
		this.patientprocedureestimateamount = patientprocedureestimateamount;
		this.patientprocedurepaymenttype = patientprocedurepaymenttype;
		this.patientprocedurepaymentamount = patientprocedurepaymentamount;
		this.patientprocedurelabname = patientprocedurelabname;
	}

	public PatientProcedure() {
		super();
		// TODO Auto-generated constructor stub
	}

	    
}