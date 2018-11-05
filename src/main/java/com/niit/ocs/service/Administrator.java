/**
 * 
 */
package com.niit.ocs.service;

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
}
