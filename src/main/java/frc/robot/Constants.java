package frc.robot;

public class Constants {
    
    public class OperatorConstants {
        public static final int LEFT_JOYSTICK_PORT = 0;
        public static final int RIGHT_JOYSTICK_PORT = 1;
        public static final int XBOX_CONTROLLER_PORT = 2;    
    
    }

    public class DriveConstants {
        public static final int LEFT_MOTORS = 0;
        public static final boolean LEFT_INVERTED = true;

        public static final int RIGHT_MOTORS = 1;
        public static final boolean RIGHT_INVERTED = false;

        public static final double DEADBAND = .05;
    }

    public class IntakeConstants {
        public static final int INTAKE_MOTORS = 0;

        public static final int ADJUSTER_MOTORS = 1;

        public static final int INTAKE_PIVITOR =  2;

        //TODO: Double check these values
        public static final int UPPER_LS = 1;
        public static final int LOWER_LS = 2;
        public static final int NOTE_DETECTOR = 0;
        }
    
    public class ShooterConstants{
        public static final int LEFT_SHOOTER_MOTORS = 6;
        public static final int RIGHT_SHOOTER_MOTORS = 7;


    }

    public class ClimbConstants {
        public static final int CLIMB_MOTOR = 4;
        
    }
}
