/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.company;

import com.company.commands.FlipperIn;
import com.company.commands.FlipperOut;
import com.company.commands.RightFlipperIn;
import com.company.commands.RightFlipperOut;
import com.company.subsystems.DriveTrainSubsystem;
import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.company.commands.Auto.SwitchAuto;

import static com.company.OI.*;

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
    public static final DriveTrainSubsystem Sub_Drive = new DriveTrainSubsystem();
    public static OI oi;

    private Command autonomousCommand;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() 
    {
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Default program", new SwitchAuto());
        autoChooser.addObject("Switch Auto", new SwitchAuto());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);

        double value = 1;

        double currentAmps = RobotMap.driveLeft1.getOutputCurrent();
        double outputV = RobotMap.driveLeft1.getMotorOutputVoltage();
        double busV = RobotMap.driveLeft1.getBusVoltage();
        double outputPerc = RobotMap.driveLeft1.getMotorOutputPercent();
        int quadPos = RobotMap.driveLeft1.getSensorCollection().getQuadraturePosition();
        int quadVel = RobotMap.driveLeft1.getSensorCollection().getQuadratureVelocity();
        int analogPos = RobotMap.driveLeft1.getSensorCollection().getAnalogIn();
        int analogVel = RobotMap.driveLeft1.getSensorCollection().getAnalogInVel();
        int selectedSensorPos = RobotMap.driveLeft1.getSelectedSensorPosition(0); /* sensor selected for PID Loop 0 */
        int selectedSensorVel = RobotMap.driveLeft1.getSelectedSensorVelocity(0); /* sensor selected for PID Loop 0 */
        int closedLoopErr = RobotMap.driveLeft1.getClosedLoopError(0); /* sensor selected for PID Loop 0 */
        double closedLoopAccum = RobotMap.driveLeft1.getIntegralAccumulator(0); /* sensor selected for PID Loop 0 */
        double derivErr = RobotMap.driveLeft1.getErrorDerivative(0); /* sensor selected for PID Loop 0 */

        double currentAmpsRight = RobotMap.driveRight1.getOutputCurrent();
        double outputVRight = RobotMap.driveRight1.getMotorOutputVoltage();
        double busVRight = RobotMap.driveRight1.getBusVoltage();
        double outputPercRight = RobotMap.driveRight1.getMotorOutputPercent();
        int quadPosRight = RobotMap.driveRight1.getSensorCollection().getQuadraturePosition();
        int quadVelRight = RobotMap.driveRight1.getSensorCollection().getQuadratureVelocity();
        int analogPosRight = RobotMap.driveRight1.getSensorCollection().getAnalogIn();
        int analogVelRight = RobotMap.driveRight1.getSensorCollection().getAnalogInVel();
        int selectedSensorPosRight = RobotMap.driveRight1.getSelectedSensorPosition(0); /* sensor selected for PID Loop 0 */
        int selectedSensorVelRight = RobotMap.driveRight1.getSelectedSensorVelocity(0); /* sensor selected for PID Loop 0 */
        int closedLoopErrRight = RobotMap.driveLeft1.getClosedLoopError(0); /* sensor selected for PID Loop 0 */
        double closedLoopAccumRight = RobotMap.driveRight1.getIntegralAccumulator(0); /* sensor selected for PID Loop 0 */
        double derivErrRight = RobotMap.driveRight1.getErrorDerivative(0); /* sensor selected for PID Loop 0 */


        RobotMap.driveLeft2.set(ControlMode.Follower, RobotMap.Drive_Left1);
        RobotMap.driveRight2.set(ControlMode.Follower, RobotMap.Drive_Right1);
        RobotMap.driveLeft1.setSafetyEnabled(false);
        RobotMap.driveLeft2.setSafetyEnabled(false);
        RobotMap.driveRight1.setSafetyEnabled(false);
        RobotMap.driveRight2.setSafetyEnabled(false);

        RobotMap.driveRight1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        RobotMap.driveRight1.configSetParameter(ParamEnum.eFeedbackNotContinuous, 0, 0x00, 0x00, 0x00);
        RobotMap.driveLeft1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        RobotMap.driveLeft1.configSetParameter(ParamEnum.eFeedbackNotContinuous, 0, 0x00, 0x00, 0x00);

        RobotMap.driveLeft1.configSetParameter(ParamEnum.eClearPositionOnQuadIdx, value, 0x00, 0x00, 10);
        RobotMap.driveLeft1.configSetParameter(ParamEnum.eClearPositionOnLimitF, value, 0x00, 0x00, 10);
        RobotMap.driveLeft1.configSetParameter(ParamEnum.eClearPositionOnLimitR, value, 0x00, 0x00, 10);

        RobotMap.driveRight1.configSetParameter(ParamEnum.eClearPositionOnQuadIdx, value, 0x00, 0x00, 10);
        RobotMap.driveRight1.configSetParameter(ParamEnum.eClearPositionOnLimitF, value, 0x00, 0x00, 10);
        RobotMap.driveRight1.configSetParameter(ParamEnum.eClearPositionOnLimitR, value, 0x00, 0x00, 10);

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
        button9.whileHeld(new RightFlipperOut());
        button10.whileHeld(new RightFlipperIn());
        button11.whileHeld(new FlipperOut());
        button12.whileHeld(new FlipperIn());
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() 
    {
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
