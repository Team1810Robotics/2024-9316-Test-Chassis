package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {

    private IntakeSubsystem intakeSubsystem;
    private boolean isInverted;
    private boolean ignoreNote;
  


    public Intake(IntakeSubsystem intakeSubsystem, boolean isInverted, boolean ignoreNote) {
        this.intakeSubsystem = intakeSubsystem;
        this.isInverted = isInverted;
        this.ignoreNote = ignoreNote;


        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        if (isInverted) {
            intakeSubsystem.reverseIntake();
        } else {
            intakeSubsystem.intake();
        }
    }

    @Override
    public boolean isFinished() {
        boolean noteCurrent = intakeSubsystem.getNoteDetector();
        if (noteCurrent && !ignoreNote) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
    }
    
}
