import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;
import java.util.Map;
import java.util.HashMap;

public class HighScore extends World
{
    private Map<String, Integer> scores;

    public HighScore() {
        super(600, 400, 1);
        
        // Initialize the scores map with some sample data
        scores = new HashMap<>();
        scores.put("Mason", 15000);
        scores.put("Charlie", 12000);
        scores.put("Henry", 9000);

        displayScores();
    }
    
    private void displayScores(){ 
        //starting position
        int yPosition = 150;
        addObject(new Label("HighScores", 32), getWidth()/2, 100); 
        
        // Loop through the entries in the map and display them
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String name = entry.getKey();
            Integer score = entry.getValue();
            String scoreText = name + ": " + score;
            addObject(new Label(scoreText, 24), getWidth() / 2, yPosition);
            yPosition += 50; // Move the next score further down so they dont overlap
        }
        //back to menu button
        addObject(new Button(this::goBack, "Back to Menu"), getWidth() / 2, 350);
    }
    //back to menu
    public void goBack(){
        Greenfoot.setWorld(new MenuScreen()); 
    }
}
