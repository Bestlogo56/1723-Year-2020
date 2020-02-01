/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TeleopDrive extends CommandBase {
  /**
   * Creates a new TeleopDriveCommand.
   */
  private final DriveSubsystem drive;
  private final DoubleSupplier forward;
  private final DoubleSupplier reverse;
  private final DoubleSupplier rotation;

  public TeleopDrive(DriveSubsystem drive, DoubleSupplier forward, DoubleSupplier reverse, DoubleSupplier rotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.forward = forward;
    this.reverse = reverse;
    this.rotation = rotation;

    addRequirements(drive);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.drive(forward.getAsDouble(), reverse.getAsDouble(), rotation.getAsDouble());
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
