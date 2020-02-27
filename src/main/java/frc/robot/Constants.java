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
    //joystick constants
    public static final int clearControllerPort = 0;
    public static final int bigBlackControllerPort = 1;

    //turret constants
    //the motor port is the... motor port
    public static final int turretMotorPort = 2;
    //alignK is the scalar of the target offset
    public static final double alignScale = 13;
    //alignTine is how far the target is to turn the turret
    public static final double alignTune = 0.1;

    //flywheel constants
    public static final int leftFlyMotorPort = 12;
    public static final int rightFlyMotorPort = 3;
    public static final int flyWheelSpeed = 5300;

    //transport constants
    public static final int transportMotorPort = 4;

    //Drive constants
    public static final int leftMasterMotorPort = 14;
    public static final int leftFollowerMotorPort = 15;
    public static final int rightMasterMotorPort = 16;
    public static final int rightFollowerMotorPort = 1;

    public static final double maxVelocity = 5700;

    public static final double turnSensitivity = 0.4;

    public static final double kP = 5e-5;
    public static final double kI = 3e-7; 
    public static final double kD = 1e-3;
    public static final double kIz = 0;
    public static final double kFF = 0;
    public static final double kMinOutput = -1;
    public static final double kMaxOutput = 1;

    //HoodConstants
    public static final int firstHoodSolenoidPort = 0;
    public static final int secondHoodSolenoidPort = 1;

    //intake constants
    public static final int intakeMotorPort = 5;

    //gondola/elevator constants
    public static final int gondolaMotorPort = 11;
    public static final int elevatorMotorPort = 13;

    public static final double gondolaSpeed = 0.5;
    public static final double elevatorSpeed = 0.5;

    public static final int elevatorLockSolenoidPort = 2;

    //control panel constants
    public static int controlPanelMotorPort = 6;
    
    public static final int DistancePerRotation = 2;
    public static final int DistancePerFourRotations = 2;
}
