package com.Om.DentalClinic.model;

import java.util.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PatientProcedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int procedureid;
	
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "patientnumber")
	private PatientInfo procedurepatientnumber;
	
	private Date proceduredate;
	private String proceduredetail;
	private double procedureestimateamount;
	private String procedurepaymenttype;
	private double procedurepaymentamount;
	private String procedurelabname;
	
	public PatientProcedure() {
		super();
		
	}

	public PatientProcedure(int procedureid, PatientInfo procedurepatientnumber, Date proceduredate,
			String proceduredetail, double procedureestimateamount, String procedurepaymenttype,
			double procedurepaymentamount, String procedurelabname) {
		super();
		this.procedureid = procedureid;
		this.procedurepatientnumber = procedurepatientnumber;
		this.proceduredate = proceduredate;
		this.proceduredetail = proceduredetail;
		this.procedureestimateamount = procedureestimateamount;
		this.procedurepaymenttype = procedurepaymenttype;
		this.procedurepaymentamount = procedurepaymentamount;
		this.procedurelabname = procedurelabname;
	}

	public int getProcedureid() {
		return procedureid;
	}

	public void setProcedureid(int procedureid) {
		this.procedureid = procedureid;
	}

	public PatientInfo getProcedurepatientnumber() {
		return procedurepatientnumber;
	}

	public void setProcedurepatientnumber(PatientInfo procedurepatientnumber) {
		this.procedurepatientnumber = procedurepatientnumber;
	}

	public Date getProceduredate() {
		return proceduredate;
	}

	public void setProceduredate(Date proceduredate) {
		this.proceduredate = proceduredate;
	}

	public String getProceduredetail() {
		return proceduredetail;
	}

	public void setProceduredetail(String proceduredetail) {
		this.proceduredetail = proceduredetail;
	}

	public double getProcedureestimateamount() {
		return procedureestimateamount;
	}

	public void setProcedureestimateamount(double procedureestimateamount) {
		this.procedureestimateamount = procedureestimateamount;
	}

	public String getProcedurepaymenttype() {
		return procedurepaymenttype;
	}

	public void setProcedurepaymenttype(String procedurepaymenttype) {
		this.procedurepaymenttype = procedurepaymenttype;
	}

	public double getProcedurepaymentamount() {
		return procedurepaymentamount;
	}

	public void setProcedurepaymentamount(double procedurepaymentamount) {
		this.procedurepaymentamount = procedurepaymentamount;
	}

	public String getProcedurelabname() {
		return procedurelabname;
	}

	public void setProcedurelabname(String procedurelabname) {
		this.procedurelabname = procedurelabname;
	}

	@Override
	public String toString() {
		return "PatientProcedure [procedureid=" + procedureid + ", procedurepatientnumber=" + procedurepatientnumber
				+ ", proceduredate=" + proceduredate + ", proceduredetail=" + proceduredetail
				+ ", procedureestimateamount=" + procedureestimateamount + ", procedurepaymenttype="
				+ procedurepaymenttype + ", procedurepaymentamount=" + procedurepaymentamount + ", procedurelabname="
				+ procedurelabname + ", getProcedureid()=" + getProcedureid() + ", getProcedurepatientnumber()="
				+ getProcedurepatientnumber() + ", getProceduredate()=" + getProceduredate() + ", getProceduredetail()="
				+ getProceduredetail() + ", getProcedureestimateamount()=" + getProcedureestimateamount()
				+ ", getProcedurepaymenttype()=" + getProcedurepaymenttype() + ", getProcedurepaymentamount()="
				+ getProcedurepaymentamount() + ", getProcedurelabname()=" + getProcedurelabname() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

		
}
