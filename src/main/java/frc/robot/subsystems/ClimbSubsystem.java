package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase{

  Talon Motor;

    public ClimbSubsystem() {
        Motor = new Talon(ClimbConstants.CLIMB_MOTOR);

    }

    public void climb(boolean upDown) {
        if(upDown == true) {
            Motor.set(1);
        } else {
            Motor.set(-1);
        }
    }
    
}


