package com.Om.DentalClinic.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
	private PatientInfo procedurenumber;
	
 
    @Column(name = "proc_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Specify the expected date format
    private Date proceduredate;

    @Column(name = "proc_type")
    private String proceduretype;
    
    
    @Column(name = "proc_details")
    private String proceduredetail;
	
    @Column(name = "estimate_amount")
    private Double estimateamount;

    @Column(name = "cash_payment")
    private Double cashpayment;
    
    @Column(name = "online_payment")
    private Double onlinepayment;
    
    @Column(name = "payment_amount")
    private Double paymentamount;
	
    
    @Column(name = "balance_amount")
    private Double balanceamount;
    
    @Column(name = "lab_name")
    private String labname;
    
    @Column(name = "external_doctor")
    private String externaldoctor;
    
    @Column(name = "proc_cashier_name")
    private String cashiername;
    
    
 	@Column(name = "proc_timestamp")
 	private Date timestamp;
 	 
     @PrePersist
     protected void onCreate() {
         timestamp = new Date();
     }
     
     @PreUpdate
     protected void onUpdate() {
         timestamp = new Date();
     }

	public PatientProcedure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientProcedure(int procedureid, PatientInfo procedurenumber, Date proceduredate, String proceduretype,
			String proceduredetail, Double estimateamount, Double cashpayment, Double onlinepayment,
			Double paymentamount, Double balanceamount, String labname, String externaldoctor, String cashiername,
			Date timestamp) {
		super();
		this.procedureid = procedureid;
		this.procedurenumber = procedurenumber;
		this.proceduredate = proceduredate;
		this.proceduretype = proceduretype;
		this.proceduredetail = proceduredetail;
		this.estimateamount = estimateamount;
		this.cashpayment = cashpayment;
		this.onlinepayment = onlinepayment;
		this.paymentamount = paymentamount;
		this.balanceamount = balanceamount;
		this.labname = labname;
		this.externaldoctor = externaldoctor;
		this.cashiername = cashiername;
		this.timestamp = timestamp;
	}

	public int getProcedureid() {
		return procedureid;
	}

	public void setProcedureid(int procedureid) {
		this.procedureid = procedureid;
	}

	public PatientInfo getProcedurenumber() {
		return procedurenumber;
	}

	public void setProcedurenumber(PatientInfo procedurenumber) {
		this.procedurenumber = procedurenumber;
	}

	public Date getProceduredate() {
		return proceduredate;
	}

	public void setProceduredate(Date proceduredate) {
		this.proceduredate = proceduredate;
	}

	public String getProceduretype() {
		return proceduretype;
	}

	public void setProceduretype(String proceduretype) {
		this.proceduretype = proceduretype;
	}

	public String getProceduredetail() {
		return proceduredetail;
	}

	public void setProceduredetail(String proceduredetail) {
		this.proceduredetail = proceduredetail;
	}

	public Double getEstimateamount() {
		return estimateamount;
	}

	public void setEstimateamount(Double estimateamount) {
		this.estimateamount = estimateamount;
	}

	public Double getCashpayment() {
		return cashpayment;
	}

	public void setCashpayment(Double cashpayment) {
		this.cashpayment = cashpayment;
	}

	public Double getOnlinepayment() {
		return onlinepayment;
	}

	public void setOnlinepayment(Double onlinepayment) {
		this.onlinepayment = onlinepayment;
	}

	public Double getPaymentamount() {
		return paymentamount;
	}

	public void setPaymentamount(Double paymentamount) {
		this.paymentamount = paymentamount;
	}

	public Double getBalanceamount() {
		return balanceamount;
	}

	public void setBalanceamount(Double balanceamount) {
		this.balanceamount = balanceamount;
	}

	public String getLabname() {
		return labname;
	}

	public void setLabname(String labname) {
		this.labname = labname;
	}

	public String getExternaldoctor() {
		return externaldoctor;
	}

	public void setExternaldoctor(String externaldoctor) {
		this.externaldoctor = externaldoctor;
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
		return "PatientProcedure [procedureid=" + procedureid + ", procedurenumber=" + procedurenumber
				+ ", proceduredate=" + proceduredate + ", proceduretype=" + proceduretype + ", proceduredetail="
				+ proceduredetail + ", estimateamount=" + estimateamount + ", cashpayment=" + cashpayment
				+ ", onlinepayment=" + onlinepayment + ", paymentamount=" + paymentamount + ", balanceamount="
				+ balanceamount + ", labname=" + labname + ", externaldoctor=" + externaldoctor + ", cashiername="
				+ cashiername + ", timestamp=" + timestamp + "]";
	}


	    
}