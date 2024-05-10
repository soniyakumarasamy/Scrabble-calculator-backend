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
    	System.out.println("********");
        // Query the database to check if a record with the given score and tiles exists
        return scoreRepository.existsByScoreAndTiles(score, tiles);
    }
    

    public void saveScore(int score,String tiles) {
        // Create a Score entity
        Score scoreEntity = new Score();
        System.out.println("%%%%%%%%%%%%%%%%%%%");
        
       //Score existingWord  =duplicateTilesremove.findByTiles(tiles);
       /*System.out.println("&&&&&"+existingWord);
      if (existingWord != null) {
    	   existingWord.setTiles(tiles);
           scoreRepository.save(existingWord);
           // If the tiles word already exists, you may choose to update the score, or do nothing
           // For now, let's assume you just return without saving again
           return;
       }*/
       
        scoreEntity.setScore(score);
        scoreEntity.setTiles(tiles);

        // Save the score to the database
        scoreRepository.save(scoreEntity);
       
    }

	public List<Score> getTopScores() {
		
		  
		 List<Score> topscore=scoreRepository.findTop10ByOrderByScoreDesc();
		
		 
		return topscore;
	}
}