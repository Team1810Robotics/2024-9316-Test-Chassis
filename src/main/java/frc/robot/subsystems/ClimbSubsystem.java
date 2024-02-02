package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase{

    private Talon climbMotor;

    public ClimbSubsystem() {
        climbMotor = new Talon(ClimbConstants.CLIMB_MOTOR);
    }

    public void climb(boolean a_Input, boolean y_Input) {
        if (a_Input) {
            climbMotor.set(-1);
        } else if (y_Input) {
            climbMotor.set(1);
        } else if ((a_Input == false) && (y_Input == false)) {
            climbMotor.stopMotor();
        }
    }

    public void stop() {
        climbMotor.stopMotor();
    }
    
}


