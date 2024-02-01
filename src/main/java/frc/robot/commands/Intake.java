package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {

    private IntakeSubsystem intakeSubsystem;
  
    private boolean bButton;



    public Intake(boolean bButton, IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.bButton = bButton;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {

        if (bButton == true) {
            intakeSubsystem.reverseIntake();
        } else {
            intakeOperator();
        }
    }

    /*This function will first check to see if there is a note in the intake, 
    if there is, it will stop the intake and pivot up. 
    If there isn't, it pivots down and begins intaking.*/
    public void intakeOperator() {
        boolean noteCurrent = intakeSubsystem.getNoteDetector();

        if (noteCurrent == true) {
          intakeSubsystem.pivotUp();
          intakeSubsystem.stopIntake();
        } else {
          intakeSubsystem.pivotDown();
          intakeSubsystem.intake();
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
    }
    
}
