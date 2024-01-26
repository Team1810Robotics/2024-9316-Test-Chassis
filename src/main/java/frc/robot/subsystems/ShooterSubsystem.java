package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase{
    private Talon leftShooterMotors;
    private Talon rightShooterMotors;

    public ShooterSubsystem(){
        leftShooterMotors = new Talon(ShooterConstants.LEFT_SHOOTER_MOTORS);
        rightShooterMotors = new Talon(ShooterConstants.RIGHT_SHOOTER_MOTORS);

    
    }

    public void shootSpeaker(){
        leftShooterMotors.set(1);
        rightShooterMotors.set(-1);
    }

    public void shootAmp(){
        leftShooterMotors.set(.25);
        rightShooterMotors.set(-.25);
    }

    public void stop(){
        leftShooterMotors.stopMotor();
        rightShooterMotors.stopMotor();
    }
}   
