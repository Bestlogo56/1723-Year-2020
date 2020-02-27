/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.AimShootCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController.Button;

import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.DriveSubsystem;

import frc.robot.commands.TurretCommand;
import frc.robot.subsystems.TurretSubsystem;

import frc.robot.commands.SpinUpShooterCommand;
import frc.robot.subsystems.FlyWheelSubsystem;

import frc.robot.subsystems.HoodSubsystem;
import frc.robot.commands.FirstHoodPneumatic;
import frc.robot.commands.SecondHoodPneumatic;

import frc.robot.subsystems.TransportSubsystem;
import frc.robot.commands.TransportCommand;
import frc.robot.commands.ReverseTransportCommand;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OuttakeCommand;

import frc.robot.commands.ClimbCommand;
import frc.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.ControlPanelWheelCommand;
import frc.robot.subsystems.ControlPanelSubsystem;

import frc.robot.Constants;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController clearController = new XboxController(Constants.clearControllerPort);
  private final XboxController bigBlackController = new XboxController(Constants.bigBlackControllerPort);

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final TurretSubsystem turretSubsystem = new TurretSubsystem();
  private final FlyWheelSubsystem flyWheelSubsystem = new FlyWheelSubsystem();

  private final TransportSubsystem TransportSubsystem = new TransportSubsystem();

  private final DriveSubsystem drive = new DriveSubsystem();

  private final IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();

  private final HoodSubsystem hoodSubsystem = new HoodSubsystem();

  private final ClimbSubsystem climb = new ClimbSubsystem();

  private final ControlPanelSubsystem controlPanelSubsystem = new ControlPanelSubsystem();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    climb.setDefaultCommand(new ClimbCommand(climb,
      () -> bigBlackController.getY(Hand.kLeft),
      () -> bigBlackController.getX(Hand.kLeft) ));

    //turretSubsystem.setDefaultCommand(new TurretCommand(turretSubsystem));
    /*
    flyWheelSubsystem.setDefaultCommand(new SpinUpShooterCommand(flyWheelSubsystem,
      () -> bigBlackController.getRawButton(1),
      () -> bigBlackController.getRawButton(2)));
    */
    drive.setDefaultCommand(new TeleopDrive(drive,
      () -> clearController.getRawAxis(3),
      () -> clearController.getRawAxis(2),
      () -> clearController.getRawAxis(0)));

    SmartDashboard.putNumber("Flywheel velocity", flyWheelSubsystem.getWheelVelocity());
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(bigBlackController, Button.kA.value).whenHeld(new AimShootCommand(TransportSubsystem,flyWheelSubsystem,turretSubsystem));

    new JoystickButton(bigBlackController, Button.kBumperLeft.value).whenHeld(new FirstHoodPneumatic(hoodSubsystem));
    new JoystickButton(bigBlackController, Button.kBumperRight.value).whenHeld(new SecondHoodPneumatic(hoodSubsystem));

    new JoystickButton(bigBlackController, Button.kB.value).whenHeld(new ControlPanelWheelCommand(controlPanelSubsystem));

    if (!bigBlackController.getStickButton(Hand.kLeft)){
      new JoystickButton(bigBlackController, Button.kY.value).whenHeld(new TransportCommand(TransportSubsystem));
      System.out.println("forward");
      new JoystickButton(bigBlackController, Button.kX.value).whenHeld(new IntakeCommand(IntakeSubsystem));
    }
    else {
      new JoystickButton(bigBlackController, Button.kY.value).whenHeld(new ReverseTransportCommand(TransportSubsystem));
      System.out.println("backwards");
      new JoystickButton(bigBlackController, Button.kX.value).whenHeld(new OuttakeCommand(IntakeSubsystem));
    }
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
