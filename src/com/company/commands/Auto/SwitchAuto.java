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
        driveLeft1.setSafetyEnabled(false);
        driveRight1.setSafetyEnabled(false);
        driveLeft2.setSafetyEnabled(false);
        driveRight2.setSafetyEnabled(false);
    }

    protected void execute() {
       // mainTimer.start();
       // if (mainTimer.get() < 3.0) {
            MainDrive.AutoDrive(0.5, 0.5);
       // } else {
        //    MainDrive.AutoDrive(0.0, 0.0);
       // }
    }
        protected boolean isFinished () {
            return(true);
        }
        protected void end () {
        }

        protected void interrupted () {
        }
    }