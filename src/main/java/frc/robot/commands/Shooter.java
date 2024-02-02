package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shooter extends Command {
    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;

    private boolean lb_Input;
    private boolean rb_Input;


    public Shooter(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem, boolean lb_Input, boolean rb_Input){
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.lb_Input = lb_Input;
        this.rb_Input = rb_Input;

        addRequirements(shooterSubsystem, intakeSubsystem);

    }

    @Override
    public void execute(){
        intakeSubsystem.pivotDownShooter();

        shooterSubsystem.shoot(rb_Input, lb_Input);

        new WaitCommand(1);

        intakeSubsystem.intake();

        new WaitCommand(.5);
    }

    @Override
    public boolean isFinished(){
        return true; //TODO: this
    }

    @Override
    public void end(boolean interrupted){
        shooterSubsystem.stop();
    }
}
