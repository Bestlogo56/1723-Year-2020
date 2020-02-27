/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;  

public class TransportSubsystem extends SubsystemBase {
  /**
   * Creates a new TransportSubsystem.
  */
  public final VictorSPX transportMotor;
// I am a constructor. My purpose in life is to create instences of TransportSubsystems
  public TransportSubsystem() {
    transportMotor = new VictorSPX(Constants.transportMotorPort);
    
  }

  public void down() {
    transportMotor.set(ControlMode.PercentOutput, -1);
  }
  
  public void up() {
    // This method will be called once per scheduler run
    transportMotor.set(ControlMode.PercentOutput, 1);

  }
  public void stop() {
    // This method will be called once per scheduler run
    transportMotor.set(ControlMode.PercentOutput, 0);

  }
}
