package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class ReverseIntake extends Command{

    private IntakeSubsystem intakeSubsystem;

    public ReverseIntake(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        intakeSubsystem.reverseIntake();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
    }
    
}
