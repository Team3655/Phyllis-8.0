/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.company;

import com.company.commands.*;
import com.company.commands.Auto.AutonomousCommand;
import com.company.commands.Auto.Test;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.company.commands.Auto.SwitchAuto;
import edu.wpi.first.wpilibj.MotorSafetyHelper;
import com.company.Instrum;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static com.company.OI.*;
import static com.company.RobotMap.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot
{
    public static OI oi;

    private Command autonomousCommand;
    SendableChooser autoChooser;

    StringBuilder sb = new StringBuilder();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Default auto", new Test());
        autoChooser.addObject("Switch Auto", new SwitchAuto());
        autoChooser.addObject("AutoCommand", new AutonomousCommand());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);

        button7.whileHeld(new ElevatorUp());
        button8.whileHeld(new ElevatorDown());
        button9.whileHeld(new RightFlipperOut());
        button10.whileHeld(new RightFlipperIn());
        button11.whileHeld(new FlipperOut());
        button12.whileHeld(new FlipperIn());

        double value = 1;

        RobotMap.driveLeft2.setInverted(true);
        RobotMap.driveLeft2.set(ControlMode.Follower, RobotMap.Drive_Left1);
        RobotMap.driveRight2.set(ControlMode.Follower, RobotMap.Drive_Right1);
        RobotMap.driveLeft1.setSafetyEnabled(false);
        RobotMap.driveLeft2.setSafetyEnabled(false);
        RobotMap.driveRight1.setSafetyEnabled(false);
        RobotMap.driveRight2.setSafetyEnabled(false);
       // RobotMap.flipperLeft.setSafetyEnabled(false);
       // RobotMap.flipperRight.setSafetyEnabled(false);

        RobotMap.driveRight1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        RobotMap.driveLeft1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);


        oi = new OI();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit()
    {

    }

    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit()
    {
        autonomousCommand = (Command) autoChooser.getSelected();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        if (autonomousCommand != null)
        {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when

        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
       if (autonomousCommand != null)
        {
            autonomousCommand.cancel();
        }

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic()
    {
        sb.append("\terr:");
        sb.append(RobotMap.driveRight1.getClosedLoopError(Constants.kPIDLoopIdx));
        sb.append("\ttrg:");
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {

    }
}
