package net.javaguides.springboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long>{

	List<Score> findTop10ByOrderByScoreDesc();

	boolean existsByScoreAndTiles(int score, String tiles);
	
	

	
		
	 
	}

