/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Score;
import co.usa.ciclo3.retos.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score score) {
        if(score.getIdScore() == null) {
            return scoreRepository.save(score);
        }
        else {
            Optional<Score> scoreOptional = scoreRepository.getScore(score.getIdScore());
            if(scoreOptional.isEmpty()) {
                return scoreRepository.save(score);
            }
            else {
                return score;
            }
        }
    }
 
}
