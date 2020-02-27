/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends CommandBase {
  /**
   * Creates a new Gondola.
   
   */

  private final ClimbSubsystem climb;
  private final DoubleSupplier elevatorPercent;
  private final DoubleSupplier gondolaPercent;

  public ClimbCommand(ClimbSubsystem subsystem, DoubleSupplier elevatorAxis, DoubleSupplier gondolaAxis) {
    this.climb = subsystem;
    this.elevatorPercent = elevatorAxis;
    this.gondolaPercent = gondolaAxis;

    addRequirements(climb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climb.climbMotors(elevatorPercent.getAsDouble(), gondolaPercent.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }




  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
