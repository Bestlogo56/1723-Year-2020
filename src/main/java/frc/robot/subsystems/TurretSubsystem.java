/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class TurretSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final static VictorSPX turretControlMotor = new VictorSPX(Constants.turretMotorPort);
  private final static NetworkTable camera = NetworkTableInstance.getDefault().getTable("limelight-master");
  DigitalInput leftLimitSwitch = new DigitalInput(0);
  DigitalInput rightLimitSwitch = new DigitalInput(1);
  double targetXOffset = 0.0;
  double targetYOffset = 0.0;
  double turnAmount = 0.0;
  boolean turnLimitReached = false;
  Number cameraMode = 0;

  //main method-- it is being tested still
  public void turnTurret()
  {
    getXOffset();
    if(getLimitSwitchValues() == false)
    {
      //scale the offset to a good amount to turn too

      //osciallated when it was multiplied by scale
      //turnAmount = Constants.alignScale/targetXOffset;
      turnAmount = (targetXOffset)/Constants.alignScale;
      //show that the target is found or not
      if(turnAmount>1)
      {
        turnAmount = 0.25;
      }
      if(targetXOffset == 0)
      {
        SmartDashboard.putBoolean("Target Found", false);
        turnAmount = 0;
      }
      else
      {
        SmartDashboard.putBoolean("Target Found", true);
      }
      
      setMotor(turnAmount);
    }
  }

  //get the limit switch values and return them
  public boolean getLimitSwitchValues()
  {
    boolean val = false;
    if(leftLimitSwitch.get() == true || rightLimitSwitch.get() == true)
    {
      val = false;
    }
    else
    {
      val = false;
    }
    return val;
  }

  //set the value of the motor more easily
  private void setMotor(double value)
  {
    turretControlMotor.set(ControlMode.PercentOutput, value);
    System.out.println(value);
  }

  //THE SETTING OF THE TARGETS TWICE IS ON PURPOSE
  
  //get the XOffset every loop
  private void getXOffset()
  {
    NetworkTableEntry tx = camera.getEntry("tx");
    targetXOffset = tx.getDouble(0.0);
    tx = camera.getEntry("tx");
    targetXOffset = tx.getDouble(0.0);
  }

  //get the YOffset every loop
  private void getYOffset()
  {
    NetworkTableEntry ty = camera.getEntry("ty");
    targetYOffset = ty.getDouble(0.0);
    ty = camera.getEntry("ty");
    targetYOffset = ty.getDouble(0.0);
  }

  public boolean isAligned() 
  {
    getXOffset();
    if (targetXOffset < .1 && targetXOffset > -.1){
      return true;
    } 
    else {
      return false;
    }
  }

  public void stopTurret()
  {
    setMotor(0);
  }
  
  //set the x offset to the dashboard
  public void setDashboard()
  {
    getXOffset();
    SmartDashboard.putNumber("Target X Offset", targetXOffset);
  }
}