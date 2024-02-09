package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake;
import frc.robot.commands.ShootSpeaker;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ScoreOffline extends Command {

    private DriveSubsystem driveSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private ShooterSubsystem shooterSubsystem;

    public ScoreOffline(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;

        addRequirements(driveSubsystem, intakeSubsystem, shooterSubsystem);


        runCommand();

    }

    public void initialize() {
        new ShootSpeaker(shooterSubsystem).withTimeout(4);
    }

    public Command runCommand() {
        return new WaitCommand(2).andThen(
            new Intake(intakeSubsystem, false, true).withTimeout(1).andThen(
            new Drive(driveSubsystem, -1, -1, false)).withTimeout(5)
            );
    }

    
    
}
