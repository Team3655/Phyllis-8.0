/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package com.company;
import com.company.subsystems.DriveTrainSubsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.MotorSafetyHelper;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    public static final int
        Drive_Left1 = 2,
        Drive_Left2 = 5,
        Drive_Right1 = 1,
        Drive_Right2 = 4;

    public static WPI_TalonSRX driveLeft1 = new WPI_TalonSRX(Drive_Left1);
    public static WPI_TalonSRX driveLeft2 = new  WPI_TalonSRX(Drive_Left2);
    public static WPI_TalonSRX driveRight1 = new WPI_TalonSRX(Drive_Right1);
    public static WPI_TalonSRX driveRight2 = new WPI_TalonSRX(Drive_Right2);

    public static DriveTrainSubsystem MainDrive = new DriveTrainSubsystem();



    //driveLeft1

    //driveLeft2

    //driveRight1

    //driveRight2

    //Motor Safety
}
