package com.company.subsystems;

import com.company.RobotMap;
import com.company.commands.ArcadeDriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrainSubsystem extends Subsystem {
    private DifferentialDrive MainDrive = new DifferentialDrive(RobotMap.driveLeft1, RobotMap.driveRight1);

    public DriveTrainSubsystem(){

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ArcadeDriveCommand());

    }

    public void TeleopDrive(Joystick Driver) {
        MainDrive.arcadeDrive(Driver.getY() * .5, Driver.getX() * .5);
    }

    public void Stop() {
        MainDrive.arcadeDrive(0, 0);
    }
}