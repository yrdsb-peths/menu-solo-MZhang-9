import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatars;
    private GreenfootImage currentAvatar;

    public MenuScreen() {    
        super(600, 400, 1);
        addObject(new Button(this::goInstructions, "Instructions"), 300, 340);

        // Avatar Selection
        avatars = new LinkedList<>();
        avatars.add(new GreenfootImage("avatar1.png"));
        avatars.add(new GreenfootImage("avatar2.png"));
        avatars.add(new GreenfootImage("avatar3.png"));

        currentAvatar = avatars.peek();
        setBackground(currentAvatar);

        addObject(new Button(this::cycleAvatar, "Next Avatar"), 300, 300);
    }

    //public void goInstructions() {
    //    Greenfoot.setWorld(new InstructionScreen(this));
    //}

    public void cycleAvatar() {
        avatars.add(avatars.remove()); // Rotate the avatars in the queue
        currentAvatar = avatars.peek();
        setBackground(currentAvatar);  // Update the background with the new avatar
    }
}
