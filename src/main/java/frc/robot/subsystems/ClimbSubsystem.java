package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase{

    private Talon climbMotor;

    public ClimbSubsystem() {
        climbMotor = new Talon(ClimbConstants.CLIMB_MOTOR);
    }


    public void Climb(boolean aInput, boolean yInput) {
        if (aInput) {
            climbMotor.set(-1);
        } else if (yInput) {
            climbMotor.set(1);
        } else if ((aInput && yInput) == false) {
            climbMotor.stopMotor();
        }
    }

    public void stop(){
        climbMotor.stopMotor();
    }
    
}


