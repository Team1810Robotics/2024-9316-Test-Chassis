package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class Climb extends Command {

    private boolean upDown;
    private ClimbSubsystem climbSubsystem;

    public Climb(ClimbSubsystem climbSubsystem, boolean upDown) {
        this.upDown = upDown;
        this.climbSubsystem = climbSubsystem;

        addRequirements(climbSubsystem);
    }

    public void execute () {
        climbSubsystem.climb(upDown);
    }
    
}
