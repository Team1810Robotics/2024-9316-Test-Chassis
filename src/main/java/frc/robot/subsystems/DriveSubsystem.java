package frc.robot.subsystems;


import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import com.ctre.phoenix.sensors.Pigeon2;

public class DriveSubsystem extends SubsystemBase {
    
    private Talon leftMotors;
    private Talon rightMotors;
    
    private IntakeSubsystem intakeSubsystem;
    public Pigeon2 pg;


    public DriveSubsystem() {
        leftMotors = new Talon(DriveConstants.LEFT_MOTORS);
        rightMotors = new Talon(DriveConstants.RIGHT_MOTORS);


        leftMotors.setInverted(DriveConstants.LEFT_INVERTED);
        rightMotors.setInverted(DriveConstants.RIGHT_INVERTED);

        pg = new Pigeon2(DriveConstants.GYRO);
        pg.configFactoryDefault();
    }

    public void zeroGyro(){
    pg.setYaw(0);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftSpeed = MathUtil.applyDeadband(leftSpeed, .02);
        rightSpeed = MathUtil.applyDeadband(rightSpeed, .02);

        var speeds = DifferentialDrive.tankDriveIK(leftSpeed, rightSpeed, true);

        leftMotors.set(speeds.left);
        rightMotors.set(speeds.right);


    }

    public void driveAutoGrab() {
        boolean noteCurrent = intakeSubsystem.getNoteDetector();
         if (!noteCurrent) {
            drive(-.5, -.5);
         } else {
            drive(.5, .5);
         }
    }
    

    public void stop() {
        leftMotors.stopMotor();
        rightMotors.stopMotor();
    }

}
