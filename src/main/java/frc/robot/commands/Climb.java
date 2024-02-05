package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class Climb extends Command {
  
    private ClimbSubsystem climbSubsystem;

    private boolean upDown;


    public Climb(ClimbSubsystem climbSubsystem, boolean upDown) {
        this.climbSubsystem = climbSubsystem;
        this.upDown = upDown;

    }


        addRequirements(climbSubsystem);
    }
  
    @Override
    public void execute() {
        climbSubsystem.climb(upDown);
    }


    @Override 
    public void end(boolean interrupted) {
        climbSubsystem.stop();
    }
    
}