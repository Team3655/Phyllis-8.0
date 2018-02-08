package com.company.commands.Auto;

import com.company.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.*;


public class SwitchAuto extends Command {

    public SwitchAuto() {
        super("SwitchAuto");
    }


    @Override
    protected void initialize() {
        super.initialize();

    }

    protected void execute() {

        MainDrive.AutoDrive(0.5, 0.5);
    }
        protected boolean isFinished () {
            return(true);
        }
        protected void end () {
        }

        protected void interrupted () {
        }
    }