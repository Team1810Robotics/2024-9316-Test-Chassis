package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;


public class Constants {
    
    public class OperatorConstants {
        public static final int LEFT_JOYSTICK_PORT = 0;
        public static final int RIGHT_JOYSTICK_PORT = 1;
        public static final int XBOX_CONTROLLER_PORT = 2;    
    }
    public static final double trackWidth = 0.4651375;
        public static final double wheelDiameter_INCHES = 8;

    public static final DifferentialDriveKinematics TD_KINEMATICS = new DifferentialDriveKinematics(trackWidth);

    public class DriveConstants {
        public static final int LEFT_MOTORS = 0;
        public static final boolean LEFT_INVERTED = true;

        public static final int RIGHT_MOTORS = 1;
        public static final boolean RIGHT_INVERTED = false;

        public static final double DEADBAND = .05;
        public static final int GYRO = 15;
    }

    public class IntakeConstants {

        public static final int INTAKE_MOTORS = 0;

        public static final int ADJUSTER_MOTORS = 1;

        public static final int INTAKE_PIVITOR = 2;
      
        //TODO: Double check these values

        public static final int UPPER_LS = 1;
        public static final int LOWER_LS = 2;
        public static final int NOTE_DETECTOR = 0;

        }

    public class ClimbConstants {
        public static final int CLIMB_MOTOR = 4;
    }
    
    public class ShooterConstants{
        public static final int LEFT_SHOOTER_MOTOR = 3;
        public static final int RIGHT_SHOOTER_MOTOR = 2;
    }

}
