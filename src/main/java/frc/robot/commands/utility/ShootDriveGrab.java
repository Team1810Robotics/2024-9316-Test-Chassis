package frc.robot.commands.utility;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Intake;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootDriveGrab extends SequentialCommandGroup {

    public ShootDriveGrab(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) {

        addCommands(
            new Shoot(shooterSubsystem, intakeSubsystem).withTimeout(2),

            new Intake(intakeSubsystem, false, false),

            new Drive(driveSubsystem, -.5, -.5, true)
        );
    }
    
}
