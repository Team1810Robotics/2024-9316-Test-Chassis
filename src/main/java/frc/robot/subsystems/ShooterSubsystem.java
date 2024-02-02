package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase{
    private Talon leftShooterMotor;
    private Talon rightShooterMotor;


    public ShooterSubsystem(){
        leftShooterMotor = new Talon(ShooterConstants.LEFT_SHOOTER_MOTORS);
        rightShooterMotor = new Talon(ShooterConstants.RIGHT_SHOOTER_MOTOR);
    }

    public void shoot() {
        leftShooterMotor.set(1);
        rightShooterMotor.set(-1);
    }

    

    public void stop(){
        leftShooterMotor.stopMotor();
        rightShooterMotor.stopMotor();
    }
}   
