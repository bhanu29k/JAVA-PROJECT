/**
 * 
 */
package com.niit.ocs.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.niit.ocs.bean.CredentialsBean;
import com.niit.ocs.bean.DoctorBean;

/**
 * @author Training
 *
 */
public interface DoctorDao {
public String createDoctor(DoctorBean doctorBean);
public DoctorBean findByID(String str);
public boolean updateDoctor(DoctorBean db);
public ArrayList<DoctorBean> findAll();
public int deleteDoctor(ArrayList<String> al);
public ArrayList<DoctorBean> findByPatientIdAndAppointDate(String pid, LocalDate appointDate);
}
