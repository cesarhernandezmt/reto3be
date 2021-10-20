/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Doctor;
import co.usa.ciclo3.retos.repository.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }
    
    public Optional<Doctor> getDoctor(int id) {
        return doctorRepository.getDoctor(id);
    }
    
    public Doctor save(Doctor doctor) {
        if(doctor.getId() == null) {
            return doctorRepository.save(doctor);
        }
        else {
            Optional<Doctor> doctorOptional = doctorRepository.getDoctor(doctor.getId());
            if(doctorOptional.isEmpty()) {
                return doctorRepository.save(doctor);
            }
            else {
                return doctor;
            }
        }
    }
    
}
