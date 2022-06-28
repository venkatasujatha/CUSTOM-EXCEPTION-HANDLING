package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.BusinessException;
import com.example.demo.Exception.ControllerException;
import com.example.demo.Model.Doctor;
import com.example.demo.Service.DoctorService;
import com.example.demo.Service.DoctorServiceImpl;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorServiceImpl;
	
	@GetMapping("/get")
	public ResponseEntity<?> getDoctor()
	{
		try
		{
		Object doctor2 = doctorServiceImpl.getDoctor();
		System.out.println(doctor2);
		return new ResponseEntity(doctor2,HttpStatus.OK);
		}
		catch (BusinessException e) {
			ControllerException controllerException=new ControllerException(e.getTimestamp(),e.getMessage(),e.getUrl());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getDoctorById(@PathVariable int id)
	{
		try
		{
			Object doctorById = doctorServiceImpl.getDoctorById(id);
			 return new ResponseEntity(doctorById, HttpStatus.OK);
		}
		catch (BusinessException e) {
			ControllerException controllerException=new ControllerException(e.getTimestamp(),e.getMessage(),e.getUrl());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor)
	{
		try
		{
		 Object saveDoctor = doctorServiceImpl.saveDoctor(doctor);
		 return new ResponseEntity(saveDoctor, HttpStatus.OK);
		}
		catch (BusinessException e) {
			ControllerException controllerException=new ControllerException(e.getTimestamp(),e.getMessage(),e.getUrl());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
	}
}
