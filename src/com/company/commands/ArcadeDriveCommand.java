package com.company.commands;

import com.company.Robot;
import com.company.RobotMap;
import com.company.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveCommand extends Command {
    public ArcadeDriveCommand() {

        super.requires(Robot.Sub_Drive);
        super.requires(RobotMap.MainDrive);
    }

    @Override
    protected void initialize(){

    }

    @Override
    protected void execute() {
        RobotMap.MainDrive.TeleopDrive(Robot.oi.getJoystick());

    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void interrupted() {
        // TODO Auto-generated method stub

    }

}
