/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Reservation;
import co.usa.ciclo3.retos.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation) {
        if(reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        }
        else {
            Optional<Reservation> reservationOptional = 
            reservationRepository.getReservation(reservation.getIdReservation());
            if(reservationOptional.isEmpty()) {
                return reservationRepository.save(reservation);
            }
            else {
                return reservation;
            }
        }
    }    
    
}
