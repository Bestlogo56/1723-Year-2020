/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.Constants;

public class HoodSubsystem extends SubsystemBase {
  /**
   * Creates a new Pneumatics.
   */

   //make names more specific - NATE ok
   //use the change all occurences command after right clicking
  private final Solenoid firstHoodSolenoid;
  private final Solenoid secondHoodSolenoid;

  public HoodSubsystem() {
    firstHoodSolenoid = new Solenoid(Constants.firstHoodSolenoidPort);
    secondHoodSolenoid = new Solenoid(Constants.secondHoodSolenoidPort);
  }

  public void pushOutFirstPneumatic() {
    firstHoodSolenoid.set(true);
  }

  public void retractFirstPneumatic(){
    firstHoodSolenoid.set(false);
  }

  public void pushOutSecondPneumatic(){
    secondHoodSolenoid.set(true);
    firstHoodSolenoid.set(true);
  }

  public void retractSecondPneumatic(){
    secondHoodSolenoid.set(false);
    firstHoodSolenoid.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
