/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/**
 * An example command. You can replace me with your own command.
 */
public class Drive extends Command {
  
  private double deadzone;
  
  public Drive() {
    this.deadzone = 0.1D;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_subsystem);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    double joyAxisLeft = OI.leftJoystick.getRawAxis(1); // how are these numbers chosen?

    double joyAxisRight = OI.rightJoystick.getRawAxis(1); // how are these numbers chosen?

    boolean rightTrig = OI.rightJoystick.getRawButton(2); // how are these numbers chosen?
    boolean leftTrig = OI.leftJoystick.getRawButton(1); // how are these numbers chosen?

    if (Math.abs(joyAxisLeft) < this.deadzone) joyAxisLeft = 0.0D;
    if (Math.abs(joyAxisRight) < this.deadzone) joyAxisRight = 0.0D;

    if (joyAxisLeft == 0.0D && joyAxisRight == 0.0D) {
      Robot.m_subsystem.stop();
    }
    else if (rightTrig) {
      Robot.m_subsystem.arcadeDrive(joyAxisLeft, joyAxisRight);
    } else {
      Robot.m_subsystem.arcadeDrive(joyAxisLeft / 3.0D, joyAxisRight / 3.0D);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_subsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}