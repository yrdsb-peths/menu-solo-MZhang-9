import greenfoot.*;

public class InstructionScreen extends World {
    private MenuScreen menu;
    private String[] instructions;
    private int index;
    private Label instructionLabel;

    public InstructionScreen(MenuScreen menu) {
        super(600, 400, 1);
        this.menu = menu;
        instructions = new String[]{
            "Welcome to the game!",
            "Use arrow keys to move.",
            "Press space to jump."
        };
        index = 0;

        instructionLabel = new Label(instructions[index], 24);
        addObject(instructionLabel, 300, 200);
        
        addObject(new Button(this::nextInstruction, "Next"), 450, 350);
        addObject(new Button(this::previousInstruction, "Previous"), 150, 350);
        addObject(new Button(this::goBack, "Back to Menu"), 300, 350);
    }

    public void nextInstruction() {
        if (index < instructions.length - 1) {
            index++;
            instructionLabel.setText(instructions[index]);
        }
    }

    public void previousInstruction() {
        if (index > 0) {
            index--;
            instructionLabel.setText(instructions[index]);
        }
    }

    public void goBack() {
        Greenfoot.setWorld(menu);
    }
}
