package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase{
    private Talon leftShooterMotor;
    private Talon rightShooterMotor;

    public ShooterSubsystem(){
        leftShooterMotor = new Talon(ShooterConstants.LEFT_SHOOTER_MOTORS);
        rightShooterMotor = new Talon(ShooterConstants.RIGHT_SHOOTER_MOTORS);

    
    }

    public void shoot(boolean rb_Input, boolean lb_Input) {
        if (rb_Input) {
            leftShooterMotor.set(1);
            rightShooterMotor.set(-1);
        } else if (lb_Input) {
            leftShooterMotor.set(.2);
            rightShooterMotor.set(-.2);
        } else if ((lb_Input == false) && (rb_Input == false)) {
            leftShooterMotor.stopMotor();
            rightShooterMotor.stopMotor();
        }

    }

    

    public void stop(){
        leftShooterMotor.stopMotor();
        rightShooterMotor.stopMotor();
    }
}   
