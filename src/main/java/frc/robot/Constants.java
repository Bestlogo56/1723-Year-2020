/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int leftMasterMotorPort = 1;
    public static int leftFollowerMotorPort = 2;
    public static int rightMasterMotorPort = 3;
    public static int rightFollowerMotorPort = 4;

    public static int joyPort = 0;
    
    public static double maxVelocity = 5700;

    public static double turnSensitivity = 0.4;

    public static double kP = 5e-5;
    public static double kI = 5e-7; 
    public static double kD = 1e-3;
    public static double kIz = 0;
    public static double kFF = 0;
    public static double kMinOutput = -1;
    public static double kMaxOutput = 1;
}
