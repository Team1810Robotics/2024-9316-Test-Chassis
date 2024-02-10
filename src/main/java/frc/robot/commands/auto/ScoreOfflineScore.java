package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Shoot;
import frc.robot.commands.utility.IntakeDrive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ScoreOfflineScore extends SequentialCommandGroup {

    
    public ScoreOfflineScore(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem, DriveSubsystem driveSubsystem) {

        addCommands(
            new Shoot(shooterSubsystem, intakeSubsystem).withTimeout(4),

            new IntakeDrive(driveSubsystem, intakeSubsystem).withTimeout(7), //TODO: Figure the timeout out

            new Shoot(shooterSubsystem, intakeSubsystem)
        );

        
    }
    
}
