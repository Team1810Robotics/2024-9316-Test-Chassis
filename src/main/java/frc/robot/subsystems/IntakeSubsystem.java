package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    private Relay intakeMotors;

    private Relay adjusterMotors;


    private Talon intakePivitor;

    private DigitalInput upperLS;
    private DigitalInput lowerLS;
    private DigitalInput noteDetector;

    boolean x;

    GenericEntry intakeSensor;
    GenericEntry intakeSpeed;


    public IntakeSubsystem() {
        intakeMotors = new Relay(IntakeConstants.LEFT_INTAKE);

        adjusterMotors = new Relay(IntakeConstants.LEFT_ADJUSTER);

        intakePivitor = new Talon(IntakeConstants.INTAKE_PIVITOR);

        upperLS = new DigitalInput(IntakeConstants.UPPER_LS);
        lowerLS = new DigitalInput(IntakeConstants.LOWER_LS);
        noteDetector = new DigitalInput(IntakeConstants.NOTE_DETECTOR);

        ShuffleboardTab tab = Shuffleboard.getTab("Tab");
        intakeSensor = tab.add("intakeSensor", x).getEntry();
        intakeSpeed = tab.add("intakeSpeed", intakeRunning()).getEntry();

    }

    public void intake() {
        intakeMotors.set(Relay.Value.kForward);
        adjusterMotors.set(Relay.Value.kForward);

    }

    public boolean getNoteDetector() {
            return noteDetector.get();
    }
@Override
    public void periodic() {
        x = getNoteDetector();
        intakeSensor.setBoolean(x);
        intakeSpeed.setBoolean(intakeRunning());
    }

    public boolean intakeRunning() {
        intakeMotors.get();
        Relay.Value speed = intakeMotors.get();
        if (speed == Relay.Value.kOn) {
            return true;
        }
        else {
            return false;
        }
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
