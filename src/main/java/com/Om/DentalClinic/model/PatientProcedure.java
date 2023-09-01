package com.Om.DentalClinic.model;

import java.util.Date;


import jakarta.persistence.CascadeType;
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
	private int procedureid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proc_patient_num", referencedColumnName = "patient_num")
	private PatientInfo procedurepatientnumber;
    
    @Column(name = "proc_date")
	private Date proceduredate;
	
    @Column(name = "proc_details")
    private String proceduredetail;
	
    @Column(name = "proc_estimate_amount")
    private double procedureestimateamount;
	
    @Column(name = "proc_payment_type")
    private String procedurepaymenttype;
	
    @Column(name = "proc_payment_amount")
    private double procedurepaymentamount;
	
    @Column(name = "proc_lab_name")
    private String procedurelabname;
	
	public PatientProcedure() {
		super();
		
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
				+ procedurelabname + "]";
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

	
}
