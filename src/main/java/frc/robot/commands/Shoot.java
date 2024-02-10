package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shoot extends Command {

    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;

    public Shoot(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;


        runCommands();
    }

    public void initialize() {
        shooterSubsystem.setSpeakerSpeed();
    }

    public Command runCommands() {
        return new WaitCommand(2).andThen(
            new Intake(intakeSubsystem, false, true)
        );
    }
    
}
