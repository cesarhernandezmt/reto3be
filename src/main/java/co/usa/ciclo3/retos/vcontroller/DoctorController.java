/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.vcontroller;


import co.usa.ciclo3.retos.model.Doctor;
import co.usa.ciclo3.retos.service.DoctorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, 
             RequestMethod.PUT, RequestMethod.DELETE})
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping("/all")
    public List<Doctor> getDoctors() {
        return doctorService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int id) {
        return doctorService.getDoctor(id);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }
    
}
