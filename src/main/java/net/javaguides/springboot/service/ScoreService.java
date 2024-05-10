package net.javaguides.springboot.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Score;
import net.javaguides.springboot.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
   
    private ScoreRepository scoreRepository;
     
    public boolean checkIfRecordExists(int score, String tiles) {
        return scoreRepository.existsByScoreAndTiles(score, tiles);
    }

    public void saveScore(int score,String tiles) {
        Score scoreEntity = new Score();
       
        scoreEntity.setScore(score);
        scoreEntity.setTiles(tiles);


        scoreRepository.save(scoreEntity);
       
    }

	public List<Score> getTopScores() {
		
		  
		 List<Score> topscore=scoreRepository.findTop10ByOrderByScoreDesc();
		
		 
		return topscore;
	}
}
