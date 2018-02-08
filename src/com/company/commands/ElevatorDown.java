package com.company.commands;


import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.ElevatorDrive;

public class ElevatorDown extends Command {
    public ElevatorDown() {
        super("Elevator Down");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

       // ElevatorDrive.ElevatorDrive(0.35, 0.35);
    }
    protected boolean isFinished () {
        return (true);
    }
    protected void end () {
    }

    protected void interrupted () {
    }
}
