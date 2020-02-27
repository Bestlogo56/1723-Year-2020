/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class FlyWheelSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  private final CANSparkMax leftFlyMotor;
  private final CANSparkMax rightFlyMotor;

  private final CANEncoder leftEncoder;

  public FlyWheelSubsystem() {
    leftFlyMotor = new CANSparkMax(Constants.leftFlyMotorPort, MotorType.kBrushless);
    rightFlyMotor = new CANSparkMax(Constants.rightFlyMotorPort, MotorType.kBrushless);

    leftEncoder = leftFlyMotor.getEncoder();

    rightFlyMotor.follow(leftFlyMotor, true);

    rightFlyMotor.setIdleMode(IdleMode.kCoast);
    leftFlyMotor.setIdleMode(IdleMode.kCoast);
  }

  public void drive(boolean forward) {
    SmartDashboard.putNumber("Flywheel speed", leftEncoder.getVelocity());
    if(forward){
      leftFlyMotor.set(1);
      //System.out.println(leftEncoder.getVelocity());
    }
    else if(!forward) {
      leftFlyMotor.set(-1);
      //System.out.println(leftEncoder.getVelocity());
    }
    else {
      stopFlyWheel();
    }    
  }

  public boolean isAtSpeed(){
    if(leftEncoder.getVelocity() > Constants.flyWheelSpeed){ //5300
      return true;
    }
    else {
      return false;
    }
  }

  public void stopFlyWheel()
  {
    leftFlyMotor.set(0);
  }

  public double getWheelVelocity()
  {
    return leftEncoder.getVelocity();
  }
  
  public void resetSpedometer()
  {
    SmartDashboard.putNumber("Flywheel speed", leftEncoder.getVelocity());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
