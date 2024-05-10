package net.javaguides.springboot.model;
import jakarta.persistence.*;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;
    
    private String tiles;

    public String getTiles() {
		return tiles;
	}

	public void setTiles(String tiles) {
		this.tiles = tiles;
	}


	// Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}