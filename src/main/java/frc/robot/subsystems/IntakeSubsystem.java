package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    private Talon leftIntake;
    private Talon rightIntake;

    private Talon leftAdjuster;
    private Talon rightAdjuster;

    private Talon intakePivitor;

    private DigitalInput upperLS;
    private DigitalInput lowerLS;
    private DigitalInput noteDetector;

    public IntakeSubsystem() {
        leftIntake = new Talon(IntakeConstants.LEFT_INTAKE);
        rightIntake = new Talon(IntakeConstants.RIGHT_INTAKE);

        leftAdjuster = new Talon(IntakeConstants.LEFT_ADJUSTER);
        rightAdjuster = new Talon(IntakeConstants.RIGHT_ADJUSTER);

        intakePivitor = new Talon(IntakeConstants.INTAKE_PIVITOR);

        upperLS = new DigitalInput(IntakeConstants.UPPER_LS);
        lowerLS = new DigitalInput(IntakeConstants.LOWER_LS);
        noteDetector = new DigitalInput(IntakeConstants.NOTE_DETECTOR);

        leftIntake.addFollower(rightIntake);
        leftAdjuster.addFollower(rightAdjuster);
    };

    public void intake() {
        leftIntake.set(1);

        leftAdjuster.set(1);

    }

    public boolean getNoteDetector() {
            return noteDetector.get();
    }

    public double getIntakeMotors() {
        return leftIntake.get();
    }

    public void stopIntake() {
        leftIntake.stopMotor();
        leftAdjuster.stopMotor();
    }

    public void stop(){
        leftIntake.stopMotor();
        // rightIntake.stopMotor();

        leftAdjuster.stopMotor();
        // rightAdjuster.stopMotor();

        intakePivitor.stopMotor();
    }



}
