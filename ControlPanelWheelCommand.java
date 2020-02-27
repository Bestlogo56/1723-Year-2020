/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelSubsystem;

/**
 * Add your docs here.
 */
public class ControlPanelWheelCommand extends CommandBase {

  private final ControlPanelSubsystem controlPanelSubsystem;

  public ControlPanelWheelCommand(ControlPanelSubsystem subsystem){
    this.controlPanelSubsystem = subsystem;
    addRequirements(controlPanelSubsystem);
  }

 @Override
  public void execute() {
    controlPanelSubsystem.spin();
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    controlPanelSubsystem.stopSpin();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}


