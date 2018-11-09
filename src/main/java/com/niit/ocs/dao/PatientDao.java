package com.niit.ocs.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.niit.ocs.bean.DoctorBean;
import com.niit.ocs.bean.PatientBean;
import com.niit.ocs.bean.ProfileBean;

public interface PatientDao {
	public String createPatient(PatientBean patientBean);

	public ArrayList<PatientBean> findAll();

	public PatientBean findByID(String patientID);

	public boolean updatePatient(PatientBean patientBean);

	public ArrayList<DoctorBean> findDoctors(String special, LocalDate dateAppoint);

	public String createRequest(String did, LocalDate dateAppoint, String mainId);

	public DoctorBean findAvaiableDoctor(String did, LocalDate dateAppoint);
}
