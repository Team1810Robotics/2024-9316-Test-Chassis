package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake;
import frc.robot.commands.ShootSpeaker;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ScoreOffline extends SequentialCommandGroup {


    public ScoreOffline(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) {

        addCommands(
            new Intake(intakeSubsystem, false, true).withTimeout(1),

            //shoot into speaker
            new ShootSpeaker(shooterSubsystem).withTimeout(2),

            new WaitCommand(1),
            //kicks note into shooter

            //drive back
            new Drive(driveSubsystem, -.5, -.5, false).withTimeout(2)
        );
    }
    
}
