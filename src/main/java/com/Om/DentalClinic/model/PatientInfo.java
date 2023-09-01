package com.Om.DentalClinic.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@IdClass(PatientInfo.PatientInfoId.class)
@Table(name = "tbl_patient_info")
public class PatientInfo {
	
	@Id
	@Column(name = "p_id")
	private Long patientid;
	
	@Id
	@Column(name = "patient_num")
	private String patientnumber;
	
	@Column(name = "patient_name")
	private String patientname;
	
	@Column(name = "patient_age")
	private int patientage;
	
	@Column(name = "patient_gender")
	private String patientgender;
	
	@Column(name = "patient_reg_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date patientregdate;
	
	@Column(name = "patient_mobile")
	private Long patientmobile;
	
	@Column(name = "patient_medical_history")
	private String patientmedicalhistory;
	
    @Lob
    @Column(name = "patient_reports")
    private byte[] patientReports;

	public PatientInfo() {
		super();
	}

	public PatientInfo(Long patientid, String patientnumber, String patientname, int patientage, String patientgender,
			Date patientregdate, Long patientmobile, String patientmedicalhistory, byte[] patientReports) {
		super();
		this.patientid = patientid;
		this.patientnumber = patientnumber;
		this.patientname = patientname;
		this.patientage = patientage;
		this.patientgender = patientgender;
		this.patientregdate = patientregdate;
		this.patientmobile = patientmobile;
		this.patientmedicalhistory = patientmedicalhistory;
		this.patientReports = patientReports;
	}

	public Long getPatientid() {
		return patientid;
	}
	
	public void setPatientid(Long patientid) {
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

	public Long getPatientmobile() {
		return patientmobile;
	}
	public void setPatientmobile(Long patientmobile) {
		this.patientmobile = patientmobile;
	}


	public String getPatientmedicalhistory() {
		return patientmedicalhistory;
	}


	public void setPatientmedicalhistory(String patientmedicalhistory) {
		this.patientmedicalhistory = patientmedicalhistory;
	}



	public byte[] getPatientReports() {
		return patientReports;
	}




	public void setPatientReports(byte[] patientReports) {
		this.patientReports = patientReports;
	}




	@Override
	public String toString() {
		return "PatientInfo [patientid=" + patientid + ", patientnumber=" + patientnumber + ", patientname="
				+ patientname + ", patientage=" + patientage + ", patientgender=" + patientgender + ", patientregdate="
				+ patientregdate + ", patientmobile=" + patientmobile + ", patientmedicalhistory="
				+ patientmedicalhistory + ", patientReports=" + Arrays.toString(patientReports) + ", getPatientid()="
				+ getPatientid() + ", getPatientnumber()=" + getPatientnumber() + ", getPatientname()="
				+ getPatientname() + ", getPatientage()=" + getPatientage() + ", getPatientgender()="
				+ getPatientgender() + ", getPatientregdate()=" + getPatientregdate() + ", getPatientmobile()="
				+ getPatientmobile() + ", getPatientmedicalhistory()=" + getPatientmedicalhistory()
				+ ", getPatientReports()=" + Arrays.toString(getPatientReports()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




	public static class PatientInfoId implements Serializable {
    	
    	private static final long serialVersionUID = 1L; 
        private Long patientid;
        private String patientnumber;

        public PatientInfoId() {
            // Default constructor
        }

        public PatientInfoId(Long patientid, String patientnumber) {
            this.patientid = patientid;
            this.patientnumber = patientnumber;
        }

        // Getters and setters for the composite key fields
        public Long getPatientid() {
            return patientid;
        }

        public void setPatientid(Long patientid) {
            this.patientid = patientid;
        }

        public String getPatientnumber() {
            return patientnumber;
        }

        public void setPatientnumber(String patientnumber) {
            this.patientnumber = patientnumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PatientInfoId that = (PatientInfoId) o;

            if (patientid != that.patientid) return false;
            return patientnumber != null ? patientnumber.equals(that.patientnumber) : that.patientnumber == null;
        }

        @Override
        public int hashCode() {
            int result = patientid != null ? patientid.hashCode() : 0;
            result = 31 * result + (patientnumber != null ? patientnumber.hashCode() : 0);
            return result;
        }

    }

}
