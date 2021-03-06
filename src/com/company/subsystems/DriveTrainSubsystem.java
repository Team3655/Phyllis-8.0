package com.company.subsystems;

import com.company.RobotMap;
import com.company.commands.ArcadeDriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//import static com.company.RobotMap.FlipperDrive;


public class DriveTrainSubsystem extends Subsystem {
    private DifferentialDrive MainDrive = new DifferentialDrive(RobotMap.driveLeft1, RobotMap.driveRight1);

    public DriveTrainSubsystem() {

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ArcadeDriveCommand());

    }

    public void TeleopDrive(Joystick Driver) {
        MainDrive.arcadeDrive(Driver.getX() * -.8, Driver.getY() * .8);
    }

    public void Stop() {
        MainDrive.arcadeDrive(0, 0);
    }
}