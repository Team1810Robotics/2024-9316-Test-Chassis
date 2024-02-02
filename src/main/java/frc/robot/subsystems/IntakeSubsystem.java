package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    private Relay intakeMotors;

    private Relay adjusterMotors;

    private Relay intakePivitor;

    private DigitalInput upperLS;
    private DigitalInput lowerLS;
    private DigitalInput noteDetector;


    public IntakeSubsystem() {
        intakeMotors = new Relay(IntakeConstants.INTAKE_MOTORS);

        adjusterMotors = new Relay(IntakeConstants.ADJUSTER_MOTORS);

        intakePivitor = new Relay(IntakeConstants.INTAKE_PIVITOR);

        upperLS = new DigitalInput(IntakeConstants.UPPER_LS);
        lowerLS = new DigitalInput(IntakeConstants.LOWER_LS);
        noteDetector = new DigitalInput(IntakeConstants.NOTE_DETECTOR);


    }

    //TODO: Check to see which way the motors need to turn (applies for everything)
    public void intake() {
        intakeMotors.set(Relay.Value.kForward);
        adjusterMotors.set(Relay.Value.kForward);

    }

    public void reverseIntake() {
        intakeMotors.set(Relay.Value.kReverse);
    }


    public void stopIntake() {
        intakeMotors.stopMotor();
        adjusterMotors.stopMotor();
    }

    public void pivotUp() {
        if (getUpperLS()) {
            intakePivitor.set(Relay.Value.kOff);
        } else {
            intakePivitor.set(Relay.Value.kForward);
        }
    }

    public void pivotDown() {
        if (getLowerLS()) {
            intakePivitor.set(Relay.Value.kOff);
        } else {
            intakePivitor.set(Relay.Value.kForward);
        }
    }

    public void pivotDownShooter() {
        while (getLowerLS() == false) {
            intakePivitor.set(Relay.Value.kReverse);
        }
    }


    public boolean getNoteDetector() {
        return noteDetector.get();
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
