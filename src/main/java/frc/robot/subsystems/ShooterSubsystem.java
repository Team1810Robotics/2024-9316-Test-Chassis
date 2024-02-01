package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase{
    private Talon shooterMotors;


    public ShooterSubsystem(){
        shooterMotors = new Talon(ShooterConstants.SHOOTER_MOTORS);
    }

    public void shoot() {
        shooterMotors.set(1);
    }

    

    public void stop(){
        shooterMotors.stopMotor();
    }
}   
