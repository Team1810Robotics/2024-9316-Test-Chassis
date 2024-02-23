package frc.robot.commands.utility;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeShooter extends SequentialCommandGroup{
    public IntakeShooter(IntakeSubsystem intakeSubsystem){

        addCommands(
            new WaitCommand(1.5),
            new Intake(intakeSubsystem, false, true)
        );
    }
}
