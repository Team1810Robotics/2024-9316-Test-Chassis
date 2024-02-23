package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootSpeaker extends Command {
    private ShooterSubsystem shooterSubsystem;

    public ShootSpeaker(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;

        addRequirements(shooterSubsystem);
    }

    @Override 
    public void execute() {
        shooterSubsystem.setSpeakerSpeed();
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stop();
    }
}
