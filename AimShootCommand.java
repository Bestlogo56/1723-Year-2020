/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyWheelSubsystem;
import frc.robot.subsystems.TransportSubsystem;
import frc.robot.subsystems.TurretSubsystem;

public class AimShootCommand extends CommandBase {
  /**
   * Creates a new AimShootCommand.
   */
  private final TransportSubsystem transportSubsystem;
  private final FlyWheelSubsystem flyWheelSubsystem;
  private final TurretSubsystem turretSubsystem;

  public AimShootCommand(TransportSubsystem transport, FlyWheelSubsystem flywheel, TurretSubsystem turret) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.transportSubsystem = transport;
    addRequirements(transportSubsystem);

    this.flyWheelSubsystem = flywheel;
    addRequirements(flyWheelSubsystem);

    this.turretSubsystem = turret;
    addRequirements(turretSubsystem);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    flyWheelSubsystem.drive(true, false);
    turretSubsystem.turnTurret();
    if (flyWheelSubsystem.isAtSpeed() && turretSubsystem.isAligned()){
      transportSubsystem.up();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turretSubsystem.stopTurret();
    flyWheelSubsystem.stopFlyWheel();
    flyWheelSubsystem.resetSpedometer();
    transportSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
