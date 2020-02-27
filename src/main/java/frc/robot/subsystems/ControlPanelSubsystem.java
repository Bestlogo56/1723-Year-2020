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

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANPIDController;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Encoder;

import frc.robot.Constants;  

public class ControlPanelSubsystem extends SubsystemBase {
  /**
   * Creates a new ControlPanelSubsystem.
  */
  public final CANSparkMax controlPanelMotor;
// I am a constructor. My purpose in life is to create instences of ControlPanelSubsystems
  public ControlPanelSubsystem() {
   controlPanelMotor = new CANSparkMax(Constants.controlPanelMotorPort, MotorType.kBrushless);
    
  }

  
  public void spin() {
    // This method will be called once per scheduler run
    controlPanelMotor.set(.7);

  }
  public void stopSpin() {
    // This method will be called once per scheduler run
    controlPanelMotor.set(0);
  }

  /*
  public void spinToColor(desiredColor) {
  
  }
*/

}
