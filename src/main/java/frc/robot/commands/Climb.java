package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class Climb extends Command {

    private ClimbSubsystem climbSubsystem;
    private boolean aInput;
    private boolean yInput;

    public Climb(boolean aInput, boolean yInput, ClimbSubsystem climbSubsystem) {
        this.climbSubsystem = climbSubsystem;
        this.aInput = aInput;
        this.yInput = yInput;
    }

    @Override
    public void execute() {
        climbSubsystem.Climb(aInput, yInput);
    }

    @Override 
    public void end(boolean interrupted) {
        climbSubsystem.stop();
    }
    
}
