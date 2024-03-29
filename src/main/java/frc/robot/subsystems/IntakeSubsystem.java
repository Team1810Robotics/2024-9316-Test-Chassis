package frc.robot.subsystems;


import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
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

    boolean x;

    GenericEntry intakeSensor;
    GenericEntry intakeSpeed;


    public IntakeSubsystem() {
        intakeMotors = new Relay(IntakeConstants.INTAKE_MOTORS);

        adjusterMotors = new Relay(IntakeConstants.ADJUSTER_MOTORS);

        intakePivitor = new Relay(IntakeConstants.INTAKE_PIVITOR);

        upperLS = new DigitalInput(IntakeConstants.UPPER_LS);
        lowerLS = new DigitalInput(IntakeConstants.LOWER_LS);
        noteDetector = new DigitalInput(IntakeConstants.NOTE_DETECTOR);

        ShuffleboardTab tab = Shuffleboard.getTab("Tab");
        intakeSensor = tab.add("intakeSensor", x).getEntry();
        intakeSpeed = tab.add("intakeSpeed", intakeRunning()).getEntry();

    }

    //TODO: Check to see which way the motors need to turn (applies for everything)
    public void intake() {
        intakeMotors.set(Relay.Value.kReverse);
        adjusterMotors.set(Relay.Value.kForward);
    }

    public void reverseIntake() {
        intakeMotors.set(Relay.Value.kForward);
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

        adjusterMotors.stopMotor();

        intakePivitor.stopMotor();
    }



}
