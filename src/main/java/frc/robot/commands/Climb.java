package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class Climb extends Command {

    boolean upDown;
    ClimbSubsystem ClimbSubsystem = new ClimbSubsystem();

    public Climb (boolean upDown) {
        this.upDown = upDown;
    }

    public void execute () {
        ClimbSubsystem.Climb(upDown);
    }
    
}
