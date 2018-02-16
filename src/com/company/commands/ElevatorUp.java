package com.company.commands;


import edu.wpi.first.wpilibj.command.Command;

import static com.company.OI.coDriver;
import static com.company.RobotMap.ElevatorDrive;

public class ElevatorUp extends Command {
    public ElevatorUp() {
        super("FlipperOut");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

        //elevator.set(coDriver.getX() * -.875);
    }
    protected boolean isFinished () {
        return (true);
    }
    protected void end () {
    }

    protected void interrupted () {
    }
}
