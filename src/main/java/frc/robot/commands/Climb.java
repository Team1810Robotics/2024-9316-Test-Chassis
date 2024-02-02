package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class Climb extends Command {

    private boolean a_Input;
    private boolean y_Input;
    private ClimbSubsystem climbSubsystem;

    public Climb(ClimbSubsystem climbSubsystem, boolean a_Input, boolean y_Input) {
        this.a_Input = a_Input;
        this.y_Input = y_Input;
        this.climbSubsystem = climbSubsystem;

        addRequirements(climbSubsystem);
    }

    public void execute () {
        climbSubsystem.climb(a_Input, y_Input);
    }
    
}