package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase{

    private Talon climbMotor;

    public ClimbSubsystem() {
        climbMotor = new Talon(ClimbConstants.CLIMB_MOTOR);

    }

    public void Climb(boolean upDown) {
        if (upDown) {
            climbMotor.set(.5);
        } else {
            climbMotor.set(-.5);
        }
    }

    public void stop(){
        climbMotor.stopMotor();
    }
    
}


