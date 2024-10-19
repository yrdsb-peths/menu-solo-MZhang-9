import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatars;
    private GreenfootImage currentAvatar;
    private Actor avatarActor;

    public MenuScreen() {    
        super(600, 400, 1);
        addObject(new Button(this::goInstructions, "Instructions"), 300, 360);
        addObject(new Button(this::goHighScores, "High Scores"), 300, 260); 
        addObject(new Button(this::cycleAvatar, "Next Avatar"), 300, 310);

        // Avatar Selection
        avatars = new LinkedList<>();
        avatars.add(new GreenfootImage("face_a.png"));
        avatars.add(new GreenfootImage("face_b.png"));
        avatars.add(new GreenfootImage("face_c.png"));

        currentAvatar = avatars.peek();
        avatarActor = new Actor() { // Create an anonymous Actor class for the avatar
            @Override
            public GreenfootImage getImage() {
                return currentAvatar;
            }
        };
        updateAvatar();
    }
    
    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
    }
    
    //going through avatar
    public void cycleAvatar() {
        avatars.add(avatars.remove()); // Rotate the avatars in the queue
        currentAvatar = avatars.peek();
        setBackground(currentAvatar);  // Update the background with the new avatar
    }
    
    //going to high score screen
    public void goHighScores(){
        Greenfoot.setWorld(new HighScore());  
    }
}
