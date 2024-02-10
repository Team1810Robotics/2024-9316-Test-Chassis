package frc.robot.commands.utility;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class Drive extends Command {
    
    private DriveSubsystem driveSubsystem;

    private double leftSpeed;
    private double rightSpeed;

    private boolean grabNote;

    public Drive(DriveSubsystem driveSubsystem, double leftSpeed, double rightSpeed, boolean grabNote) {
        this.driveSubsystem = driveSubsystem;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.grabNote = grabNote;

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        if (grabNote) {
            driveSubsystem.driveAutoGrab();
        } else {
            driveSubsystem.drive(leftSpeed, rightSpeed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();
    }

}
