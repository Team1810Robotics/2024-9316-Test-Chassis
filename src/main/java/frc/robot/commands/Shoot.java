package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shoot extends SequentialCommandGroup {

    public Shoot(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {

        addCommands(
            new ShootSpeaker(shooterSubsystem).withTimeout(4),

            new WaitCommand(2),

            new Intake(intakeSubsystem, false, true)


        );
    }
    
}
