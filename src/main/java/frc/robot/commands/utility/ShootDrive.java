package frc.robot.commands.utility;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class ShootDrive extends SequentialCommandGroup{
    
    public ShootDrive(IntakeSubsystem intakeSubsystem, DriveSubsystem driveSubsystem){
        addCommands(
            new WaitCommand(1.5),
            new Intake(intakeSubsystem, false, true).withTimeout(1),

            new Drive(driveSubsystem, -1, -1, false)
        );
    } 
}
