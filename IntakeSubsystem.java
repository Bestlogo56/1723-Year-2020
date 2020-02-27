/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */
  private final VictorSPX intakeMotor;

  public IntakeSubsystem() {
    intakeMotor = new VictorSPX(Constants.intakeMotorPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intake() {
    intakeMotor.set(ControlMode.PercentOutput, .45);
  }
  
  public void outtake() {
    intakeMotor.set(ControlMode.PercentOutput, -.45);
  }

  public void stopIntake() {
    intakeMotor.set(ControlMode.PercentOutput, 0);
  }
}
