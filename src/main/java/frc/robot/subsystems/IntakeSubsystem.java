package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    private Relay intakeMotors;

    private Relay adjusterMotors;


    private Talon intakePivitor;

    private DigitalInput upperLS;
    private DigitalInput lowerLS;
    private DigitalInput noteDetector;


    public IntakeSubsystem() {
        intakeMotors = new Relay(IntakeConstants.LEFT_INTAKE);

        adjusterMotors = new Relay(IntakeConstants.LEFT_ADJUSTER);

        intakePivitor = new Talon(IntakeConstants.INTAKE_PIVITOR);

        upperLS = new DigitalInput(IntakeConstants.UPPER_LS);
        lowerLS = new DigitalInput(IntakeConstants.LOWER_LS);
        noteDetector = new DigitalInput(IntakeConstants.NOTE_DETECTOR);


    }

    public void intake() {
        intakeMotors.set(Relay.Value.kForward);
        adjusterMotors.set(Relay.Value.kForward);

    }

    public boolean getNoteDetector() {
            return noteDetector.get();
    }

    public Relay.Value getIntakeMotors() {
        return intakeMotors.get();
    }

    public void stopIntake() {
        intakeMotors.stopMotor();
        adjusterMotors.stopMotor();
    }

    public void pivotUp() {
        if (getUpperLS()) {
            intakePivitor.set(0);
        } else {
            intakePivitor.set(0.1);
        }
    }

    public void pivotDown() {
        if (getLowerLS()) {
            intakePivitor.set(0);
        } else {
            intakePivitor.set(0.1);
        }

    }

    public boolean getLowerLS() {
        return lowerLS.get();
    }

    public boolean getUpperLS() {
        return upperLS.get();
    }


    public void stop(){
        intakeMotors.stopMotor();
        intakeMotors.stopMotor();

        intakePivitor.stopMotor();
    }



}
