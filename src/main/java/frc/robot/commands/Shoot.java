package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.utility.IntakeShooter;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shoot extends ParallelCommandGroup {



    public Shoot(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {

        addCommands(
            new ShootSpeaker(shooterSubsystem),
            new IntakeShooter(intakeSubsystem)
        );
    }


    
}
