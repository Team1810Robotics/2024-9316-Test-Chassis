package frc.robot.subsystems;


import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase{
    private Talon leftShooterMotor;
    private Talon rightShooterMotor;

    GenericEntry leftShooterSpeed;
    GenericEntry rightShooterSpeed;

    public ShooterSubsystem(){
        leftShooterMotor = new Talon(ShooterConstants.LEFT_SHOOTER_MOTOR);
        rightShooterMotor = new Talon(ShooterConstants.RIGHT_SHOOTER_MOTOR);
        ShuffleboardTab tab = Shuffleboard.getTab("Tab");
        leftShooterSpeed = tab.add("leftShooterSpeed", leftShooterRunning()).getEntry();
        rightShooterSpeed = tab.add("rightShooterSpeed", rightShooterRunning()).getEntry();
    }

    public boolean leftShooterRunning() {
        leftShooterMotor.get();
        Double speed = leftShooterMotor.get();
        if (speed > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean rightShooterRunning() {
        rightShooterMotor.get();
        Double speed = rightShooterMotor.get();
        if (speed > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setSpeakerSpeed() {
        leftShooterMotor.set(1);
        rightShooterMotor.set(-1);
    }

    public void setAmpSpeed() {
        leftShooterMotor.set(.38);
        rightShooterMotor.set(-.38);
    }
    

    public void stop(){
        leftShooterMotor.stopMotor();
        rightShooterMotor.stopMotor();
    }
}   
