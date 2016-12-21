package omss.domain;

public class Appointment {

	public long appointmentId;
	public String doctorName ;
	public String patinetName ;
	public String appointmentType;
	public String appointmentDate;
	public String medicalReports;
	public String patientName;
	public String description;
	
	
	public long patientId;
	public long doctorId;
	
	
	 
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getMedicalReports() {
		return medicalReports;
	}
	public void setMedicalReports(String medicalReports) {
		this.medicalReports = medicalReports;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPatinetName() {
		return patinetName;
	}
	public void setPatinetName(String patinetName) {
		this.patinetName = patinetName;
	}
	
	
	
}
