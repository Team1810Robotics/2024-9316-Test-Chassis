package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase{

  Talon Motor;

    public ClimbSubsystem() {
        Motor = new Talon(0);

    }

    public void Climb (boolean upDown) {
        if(upDown == true) {
            Motor.set(1);
        } else {
            Motor.set(-1);
        }
    }
    
}


