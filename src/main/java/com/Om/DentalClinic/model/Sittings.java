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
@Table(name = "tbl_proc_sittings")
public class Sittings {

	
	@Id
	@Column(name = "sitting_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sittingid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Sittingid_Proc", referencedColumnName = "proc_id")
	private PatientProcedure sittingidproc;
		
    @Column(name = "sitting_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Specify the expected date format
    private Date sittingdate;
  
	@Column(name = "sitting_details")
    private String sittingdetails;
	
	@Column(name = "sitting_cash_payment")
    private Double sittingcashpayment;
	
	@Column(name = "sitting_online_payment")
    private Double sittingonlinepayment;
	
	@Column(name = "sitting_payment_amount")
    private Double sittingpaymentamount;

	@Column(name = "sitting_lab_name")
    private String sittinglabname;
    
	@Column(name = "sitting_external_doctor")
    private String sittingexternaldoctor;
    
	@Column(name = "sitting_proc_cashier_name")
    private String sittingproccashiername;
    
	@Column(name = "sitting_proc_timestamp")
	private Date timestamp;
	 
    @PrePersist
    protected void onCreate() {
        timestamp = new Date();
    }  
    @PreUpdate
    protected void onUpdate() {
        timestamp = new Date();
    }
	public Sittings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sittings(int sittingid, PatientProcedure sittingidproc, Date sittingdate, String sittingdetails,
			Double sittingcashpayment, Double sittingonlinepayment, Double sittingpaymentamount, String sittinglabname,
			String sittingexternaldoctor, String sittingproccashiername, Date timestamp) {
		super();
		this.sittingid = sittingid;
		this.sittingidproc = sittingidproc;
		this.sittingdate = sittingdate;
		this.sittingdetails = sittingdetails;
		this.sittingcashpayment = sittingcashpayment;
		this.sittingonlinepayment = sittingonlinepayment;
		this.sittingpaymentamount = sittingpaymentamount;
		this.sittinglabname = sittinglabname;
		this.sittingexternaldoctor = sittingexternaldoctor;
		this.sittingproccashiername = sittingproccashiername;
		this.timestamp = timestamp;
	}
	public int getSittingid() {
		return sittingid;
	}
	public void setSittingid(int sittingid) {
		this.sittingid = sittingid;
	}
	public PatientProcedure getSittingidproc() {
		return sittingidproc;
	}
	public void setSittingidproc(PatientProcedure sittingidproc) {
		this.sittingidproc = sittingidproc;
	}
	public Date getSittingdate() {
		return sittingdate;
	}
	public void setSittingdate(Date sittingdate) {
		this.sittingdate = sittingdate;
	}
	public String getSittingdetails() {
		return sittingdetails;
	}
	public void setSittingdetails(String sittingdetails) {
		this.sittingdetails = sittingdetails;
	}
	public Double getSittingcashpayment() {
		return sittingcashpayment;
	}
	public void setSittingcashpayment(Double sittingcashpayment) {
		this.sittingcashpayment = sittingcashpayment;
	}
	public Double getSittingonlinepayment() {
		return sittingonlinepayment;
	}
	public void setSittingonlinepayment(Double sittingonlinepayment) {
		this.sittingonlinepayment = sittingonlinepayment;
	}
	public Double getSittingpaymentamount() {
		return sittingpaymentamount;
	}
	public void setSittingpaymentamount(Double sittingpaymentamount) {
		this.sittingpaymentamount = sittingpaymentamount;
	}
	public String getSittinglabname() {
		return sittinglabname;
	}
	public void setSittinglabname(String sittinglabname) {
		this.sittinglabname = sittinglabname;
	}
	public String getSittingexternaldoctor() {
		return sittingexternaldoctor;
	}
	public void setSittingexternaldoctor(String sittingexternaldoctor) {
		this.sittingexternaldoctor = sittingexternaldoctor;
	}
	public String getSittingproccashiername() {
		return sittingproccashiername;
	}
	public void setSittingproccashiername(String sittingproccashiername) {
		this.sittingproccashiername = sittingproccashiername;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Sittings [sittingid=" + sittingid + ", sittingidproc=" + sittingidproc + ", sittingdate=" + sittingdate
				+ ", sittingdetails=" + sittingdetails + ", sittingcashpayment=" + sittingcashpayment
				+ ", sittingonlinepayment=" + sittingonlinepayment + ", sittingpaymentamount=" + sittingpaymentamount
				+ ", sittinglabname=" + sittinglabname + ", sittingexternaldoctor=" + sittingexternaldoctor
				+ ", sittingproccashiername=" + sittingproccashiername + ", timestamp=" + timestamp + "]";
	}
    
    
	}
