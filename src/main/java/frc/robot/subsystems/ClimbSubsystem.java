/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
  /**
   * Creates a new ClimbSubsystem.
   */

  private final VictorSPX gondolaMotor;
  private final VictorSPX elevatorMotor;

  public final Solenoid elevatorLockSolenoid;

  public ClimbSubsystem() {
    gondolaMotor = new VictorSPX(Constants.gondolaMotorPort);
    elevatorMotor = new VictorSPX(Constants.elevatorMotorPort);

    elevatorLockSolenoid = new Solenoid(Constants.elevatorLockSolenoidPort);
  }

  public void climbMotors(double elevatorPercent, double gondolaPercent){
    //System.out.println(povAngle);
    if(gondolaPercent <= 0.08 && gondolaPercent >= -0.08) {
      gondolaPercent = 0.0;
    }
  
    gondolaMotor.set(ControlMode.PercentOutput, gondolaPercent);

    if(elevatorPercent <= 0.08 && elevatorPercent >= -0.08){
      elevatorPercent = 0.0;     
    }
    
    elevatorMotor.set(ControlMode.PercentOutput, elevatorPercent);
  }

  public void lockElevator(){
    elevatorLockSolenoid.set(true);
  }

  public void unlockElevator(){
    elevatorLockSolenoid.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

