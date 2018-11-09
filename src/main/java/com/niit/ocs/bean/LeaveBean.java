package com.niit.ocs.bean;

import java.time.LocalDate;

import com.niit.ocs.service.ReporterService;
import com.niit.ocs.service.impl.ReporterServiceImpl;

public class LeaveBean {
private String reporterId;
private String reporterName;
private String leaveId;
private String doctorId;
private LocalDate leaveFrom;
private LocalDate leaveTo;
private String reason;
private int status;
ReporterService leaveService;
/**
 * 
 */
public LeaveBean() {
	super();
	leaveService=new ReporterServiceImpl();
	
}

/**
 * @param reporterId
 * @param reporterName
 * @param doctorId
 * @param leaveFrom
 * @param leaveTo
 * @param reason
 * @param status
 */
public LeaveBean(String reporterId, String reporterName, String doctorId, LocalDate leaveFrom, LocalDate leaveTo,
		String reason, int status) {
	super();
	this.reporterId = reporterId;
	this.reporterName = reporterName;
	this.doctorId = doctorId;
	this.leaveFrom = leaveFrom;
	this.leaveTo = leaveTo;
	this.reason = reason;
	this.status = status;
}

/**
 * @return the reporterId
 */
public String getReporterId() {
	return reporterId;
}

/**
 * @param reporterId the reporterId to set
 */
public void setReporterId(String reporterId) {
	this.reporterId = reporterId;
}

/**
 * @return the reporterName
 */
public String getReporterName() {
	return reporterName;
}

/**
 * @param reporterName the reporterName to set
 */
public void setReporterName(String reporterName) {
	this.reporterName = reporterName;
}



/**
 * @return the leaveId
 */
public String getLeaveId() {
	return leaveId;
}

/**
 * @param leaveId the leaveId to set
 */
public void setLeaveId() {
	leaveId =leaveService.generateLeaveId();
}

/**
 * @return the doctorId
 */
public String getDoctorId() {
	return doctorId;
}

/**
 * @param doctorId the doctorId to set
 */
public void setDoctorId(String doctorId) {
	this.doctorId = doctorId;
}

/**
 * @return the leaveFrom
 */
public LocalDate getLeaveFrom() {
	return leaveFrom;
}

/**
 * @param leaveFrom the leaveFrom to set
 */
public void setLeaveFrom(LocalDate leaveFrom) {
	this.leaveFrom = leaveFrom;
}

/**
 * @return the leaveTo
 */
public LocalDate getLeaveTo() {
	return leaveTo;
}

/**
 * @param leaveTo the leaveTo to set
 */
public void setLeaveTo(LocalDate leaveTo) {
	this.leaveTo = leaveTo;
}

/**
 * @return the reason
 */
public String getReason() {
	return reason;
}

/**
 * @param reason the reason to set
 */
public void setReason(String reason) {
	this.reason = reason;
}

/**
 * @return the status
 */
public int getStatus() {
	return status;
}

/**
 * @param status the status to set
 */
public void setStatus(int status) {
	this.status = status;
}





}
