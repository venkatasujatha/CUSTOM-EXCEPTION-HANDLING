package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.BusinessException;
import com.example.demo.Model.Doctor;
import com.example.demo.Repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	public Object getDoctor() {
		try
		{
			
		 List<Doctor> findall = doctorRepository.findAll();
		 if(findall.isEmpty())
			{
				throw new BusinessException(new Date(),"list is empty.pls fill something","604");
			}
			
		 return findall;
		}
		
		catch (Exception e) {
			throw new BusinessException(new Date(),"something went wrong in service layer while fetching","603"+e.getMessage());
		}
	}

	public Object getDoctorById(int id) {
		try
		{
			Optional<Doctor>  byid = doctorRepository.findById(id);
			if(byid.isEmpty())
			{
				throw new BusinessException(new Date(),"id is not present in DB","604");
			}
			return byid;
			
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException(new Date(), "something went wrong in service layer while fetching  ", "620"+e.getMessage());
			
			}
		
		catch (Exception e) {
			throw new BusinessException(new Date(),"something went wrong in service layer while fetching ","605"+e.getMessage());
		}
		
	}

	public Object saveDoctor(Doctor doctor) {
		
		
			if(doctor.getName().isEmpty()||doctor.getName().length()==0)
		{
			throw new BusinessException(new Date(), "pls send proper name.it's blank", "601");
		}
			try
			{
			Doctor save1 = doctorRepository.save(doctor);
			return save1;
			
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException(new Date(), "given employee is null", "602"+e.getMessage());
			
			}
			
		catch (Exception e) {
			throw new BusinessException(new Date(),"something went wrong in service layer while saving","607"+e.getMessage());
			
		}
		
	}

}
