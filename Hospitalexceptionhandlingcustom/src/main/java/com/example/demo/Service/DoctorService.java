package com.example.demo.Service;

import com.example.demo.Model.Doctor;

public interface DoctorService {
	
	public Object getDoctor();
	
	public Object getDoctorById(int id);
	
	public Object saveDoctor(Doctor doctor);

}
