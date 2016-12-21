package omss.domain;

public class CaseResolution {
	Long  caseresolutionId;
	Long  appointid;
	String patientName;
	String doctorName;
	String serialno;
	String mediciname;
	String courseDays;
	String comments;
	
	public Long getCaseresolutionId() {
		return caseresolutionId;
	}
	public void setCaseresolutionId(Long caseresolutionId) {
		this.caseresolutionId = caseresolutionId;
	}
	public Long getAppointid() {
		return appointid;
	}
	public void setAppointid(Long appointid) {
		this.appointid = appointid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getMediciname() {
		return mediciname;
	}
	public void setMediciname(String mediciname) {
		this.mediciname = mediciname;
	}
	public String getCourseDays() {
		return courseDays;
	}
	public void setCourseDays(String courseDays) {
		this.courseDays = courseDays;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
	
}
