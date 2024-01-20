package frc.robot.subsystems;


import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
    
    private Talon leftMotors;
    private Talon rightMotors;




    public DriveSubsystem() {
        leftMotors = new Talon(DriveConstants.LEFT_MOTORS);
        rightMotors = new Talon(DriveConstants.RIGHT_MOTORS);


        leftMotors.setInverted(DriveConstants.LEFT_INVERTED);
        rightMotors.setInverted(DriveConstants.RIGHT_INVERTED);



    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftSpeed = MathUtil.applyDeadband(leftSpeed, .02);
        rightSpeed = MathUtil.applyDeadband(rightSpeed, .02);

        var speeds = DifferentialDrive.tankDriveIK(leftSpeed, rightSpeed, true);

        leftMotors.set(speeds.left);
        rightMotors.set(speeds.right);


    }
    

    public void stop() {
        leftMotors.stopMotor();
        rightMotors.stopMotor();
    }

}
