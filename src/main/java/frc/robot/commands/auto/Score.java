package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Score extends ParallelCommandGroup {
    
    public Score(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {

        addCommands(
            new Shoot(shooterSubsystem, intakeSubsystem).withTimeout(6)
        );
    }
}
