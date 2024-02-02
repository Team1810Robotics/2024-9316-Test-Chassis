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
        public static final int INTAKE_MOTORS = 3;

        public static final int ADJUSTER_MOTORS = 4;

        public static final int INTAKE_PIVITOR = 5;

        //TODO: Double check these values
        public static final int UPPER_LS = 0;
        public static final int LOWER_LS = 1;
        public static final int NOTE_DETECTOR = 2;
        }

    public class ClimbConstants {
        public static final int CLIMB_MOTOR = 4;
    }
    
}
