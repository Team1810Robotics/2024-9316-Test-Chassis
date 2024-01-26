package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shooter extends Command {
    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;

    private boolean leftBumper;
    private boolean rightBumper;

    public Shooter(boolean leftBumper, boolean rightBumper, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem){
        this.leftBumper = leftBumper;
        this.rightBumper = rightBumper;
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(shooterSubsystem, intakeSubsystem);
    }

    @Override
    public void execute(){
        if (leftBumper) {
            shooterSubsystem.shootAmp();

            new WaitCommand(1);

            intakeSubsystem.intake();
        } else if(rightBumper){
            shooterSubsystem.shootSpeaker();

            new WaitCommand(1);

            intakeSubsystem.intake();
        }
    }

    public boolean isFinished(){
        if (leftBumper || rightBumper) {
            return false;
        } else {
            return true;
        }
    }

    public void end(boolean interrupted){
        shooterSubsystem.stop();
    }
}
