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

        public static final int INTAKE_PIVITOR = 2;
      
        //TODO: Double check these values

        public static final int UPPER_LS = 1;
        public static final int LOWER_LS = 2;
        public static final int NOTE_DETECTOR = 0;

        }
        public static final class VisionConstants {
            public static final double CAMERA_HEIGHT = 0;
            public static final double CAMERA_PITCH = 0;
            public static final double APRILTAG_ANGLE = 0;



        public static final class VisionConstants {
            public static final double CAMERA_HEIGHT = 0;
            public static final double CAMERA_PITCH = 0;
            public static final double APRILTAG_ANGLE = 0;
            public static final int APRILTAG_RED_SHOOTER_ID = 4;
            public static final double APRILTAG_RED_SHOOTER_HEIGHT = 1.32;
        }
    public class ClimbConstants {
        public static final int CLIMB_MOTOR = 4;
    }

    
    public class ShooterConstants{
        public static final int LEFT_SHOOTER_MOTOR = 3;
        public static final int RIGHT_SHOOTER_MOTOR = 2;
    }

}
