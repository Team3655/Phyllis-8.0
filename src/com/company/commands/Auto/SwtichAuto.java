package com.company.commands.Auto;

import com.company.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import static com.company.RobotMap.MainDrive;

public class SwtichAuto {
    public static void SwitchAuto() {
        Timer mainTimer = null;
        if (mainTimer.get() > 3.0) {
            MainDrive.tankDrive(0.0, 0.0);
        }
        else {
            MainDrive.tankDrive(0.5, 0.0);
        }
    }
}