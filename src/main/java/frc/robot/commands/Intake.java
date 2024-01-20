package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {

    private IntakeSubsystem intakeSubsystem;

    // private Relay.Value intakePrevious;


    public Intake(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;

        // intakePrevious = intakeSubsystem.getIntakeMotors();

        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        intakeSubsystem.intake();
    }

    /*This function will first check to see if there is a note in the intake, 
    and if the intake was moving. If that's true, it will stop the intake and pivot up. 
    Then it will check if there is not a note in the inttake and if the intake was not moving, 
    if it wasn't, it pivots down and begins intaking. If there is nno note in there and the intake was intaking, it keeps intaking.*/
    public void intakeOperator() {
        // Relay.Value intakeCurrent = intakeSubsystem.getIntakeMotors();
        boolean noteCurrent = intakeSubsystem.getNoteDetector();

        if (noteCurrent == true) {
          intakeSubsystem.pivotUp();
          intakeSubsystem.stopIntake();
        } else {
            intakeSubsystem.pivotDown();
          intakeSubsystem.intake();
        }

        // if (noteCurrent && intakePrevious == Relay.Value.kForward){
        //     intakeSubsystem.stopIntake();
        //     intakeSubsystem.pivotUp();
        // } else if(!noteCurrent && intakePrevious == Relay.Value.kOff){
        //     intakeSubsystem.pivotDown();
        //     intakeSubsystem.intake();
        // } else if(!noteCurrent && intakePrevious == Relay.Value.kForward){
        //     intakeSubsystem.intake();
        // }
        // intakePrevious = intakeCurrent;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
    }
    
}
