/**
 * 
 */
package com.niit.ocs.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.niit.ocs.bean.DoctorBean;

/**
 * @author Training
 *
 */
public interface Administrator {
public String addDoctor(DoctorBean doctorBean);
public boolean modifyDoctor(DoctorBean doctorBean);
public ArrayList<DoctorBean> viewAllDoctors();
public int removeDoctor(String id);
public ArrayList<DoctorBean> suggestDoctors(String pid, LocalDate appointDate);
}
