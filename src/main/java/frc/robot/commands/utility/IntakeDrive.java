package frc.robot.commands.utility;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Intake;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeDrive extends ParallelCommandGroup {
    
    public IntakeDrive(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {

        addCommands(
            new Intake(intakeSubsystem, false, false),
            new Drive(driveSubsystem, -.5, -.5, true)
        );
    }
}
