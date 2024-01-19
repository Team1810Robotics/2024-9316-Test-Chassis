package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    private Talon leftIntake;
    private Talon rightIntake;

    private Talon leftAdjuster;
    private Talon rightAdjuster;

    private Talon intakePivitor;

    public IntakeSubsystem() {
        leftIntake = new Talon(IntakeConstants.LEFT_INTAKE);
        rightIntake = new Talon(IntakeConstants.RIGHT_INTAKE);

        leftAdjuster = new Talon(IntakeConstants.LEFT_ADJUSTER);
        rightAdjuster = new Talon(IntakeConstants.RIGHT_ADJUSTER);

        intakePivitor = new Talon(IntakeConstants.INTAKE_PIVITOR);

        leftIntake.addFollower(rightIntake);
        leftAdjuster.addFollower(rightAdjuster);
    };

    public void intake() {
        leftIntake.set(1);

        leftAdjuster.set(1);
    }

    public void stop(){
        leftIntake.stopMotor();
        // rightIntake.stopMotor();

        leftAdjuster.stopMotor();
        // rightAdjuster.stopMotor();

        intakePivitor.stopMotor();
    }



}
