/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.ControlType;
import com.revrobotics.CANPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  private final CANSparkMax leftMasterMotor;
  private final CANSparkMax leftFollowerMotor;
  private final CANSparkMax rightMasterMotor;
  private final CANSparkMax rightFollowerMotor;

  private final CANEncoder leftEncoder;
  
  private final CANPIDController leftPIDController;
  private final CANPIDController rightPIDController;


  public DriveSubsystem() {
    leftMasterMotor = new CANSparkMax(Constants.leftMasterMotorPort, MotorType.kBrushless);
    leftFollowerMotor = new CANSparkMax(Constants.leftFollowerMotorPort, MotorType.kBrushless);
    rightMasterMotor = new CANSparkMax(Constants.rightMasterMotorPort, MotorType.kBrushless);
    rightFollowerMotor = new CANSparkMax(Constants.rightFollowerMotorPort, MotorType.kBrushless);

    leftEncoder = leftMasterMotor.getEncoder();

    leftFollowerMotor.follow(leftMasterMotor);
    rightFollowerMotor.follow(rightMasterMotor);

    leftPIDController = leftMasterMotor.getPIDController();
    rightPIDController = rightMasterMotor.getPIDController();

    leftPIDController.setP(Constants.kP);
    leftPIDController.setI(Constants.kI);
    leftPIDController.setD(Constants.kD);
    leftPIDController.setIZone(Constants.kIz);
    leftPIDController.setFF(Constants.kFF);
    leftPIDController.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);

    rightPIDController.setP(Constants.kP);
    rightPIDController.setI(Constants.kI);
    rightPIDController.setD(Constants.kD);
    rightPIDController.setIZone(Constants.kIz);
    rightPIDController.setFF(Constants.kFF);
    rightPIDController.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);
  }

  public void drive(double forward, double reverse, double rotation) {
    if(rotation > 0){
      rotation *= rotation*-1;
    }
    else if(rotation < 0) {
      rotation *= rotation;    
    }
    
    reverse *= reverse;
    forward *= forward;

    //dead zones for joysticks
    if(rotation <= 0.01 && rotation >= -0.01) {
      rotation = 0.0;
    }
    if(reverse <= 0.01) {
      reverse = 0.0;
    }
    if(forward <= 0.01) {
      forward = 0.0;
    }

    double throttle = forward - reverse;

    rotation = rotation * Constants.turnSensitivity;
    //calculate differentials with variables for two sides of robot drive train
    double rightSidePercentage = (throttle - rotation)*-1;
    double leftSidePercentage = throttle + rotation;

    //clamp differential values
     if(rightSidePercentage >= 1) {
      rightSidePercentage = 1;
    }
    else if(rightSidePercentage <= -1) {
      rightSidePercentage = -1;
    }
    if(leftSidePercentage >= 1) {
      leftSidePercentage = 1;
    }
    else if(leftSidePercentage <= -1) {
      leftSidePercentage = -1;
    }

    if(leftEncoder.getVelocity() >= 1000 || leftEncoder.getVelocity() <= -1000) {
      //System.out.println(throttle);
      System.out.println(leftEncoder.getVelocity());
    }

    leftPIDController.setReference(leftSidePercentage*Constants.maxVelocity, ControlType.kVelocity);
    rightPIDController.setReference(rightSidePercentage*Constants.maxVelocity, ControlType.kVelocity);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
