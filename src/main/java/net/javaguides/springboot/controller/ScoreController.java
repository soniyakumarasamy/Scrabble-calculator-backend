package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Score;
import net.javaguides.springboot.model.ScoreRequest;
import net.javaguides.springboot.service.ScoreService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/api/scores")
    public ResponseEntity<String> saveScore(@RequestBody ScoreRequest scoreRequest) {
  	
        int score = scoreRequest.getScore();
        String tiles = scoreRequest.getTiles();
        
        System.out.println("Received ScoreRequest: " + scoreRequest);
        System.out.println("Score: " + score);
        System.out.println("Tiles: " + tiles);
        
        boolean exists=scoreService.checkIfRecordExists(score,tiles);
        if (!exists) {              	
        	 scoreService.saveScore(score,tiles);
        	  return ResponseEntity.ok("ok");   
        } else {
           
        	return ResponseEntity.ok("not");
        }     
    }
        
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/top-scores")
    public ResponseEntity<List<Score>> getTopScores() {
        List<Score> topScores = scoreService.getTopScores();

        return ResponseEntity.ok(topScores);
    }
    
}
