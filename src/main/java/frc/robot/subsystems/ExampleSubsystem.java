/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExampleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
    private Spark left1 = new Spark(0);
    private Spark left2 = new Spark(1);
    private Spark right1 = new Spark(2);
    private Spark right2 = new Spark(3);
    

  @Override
  public void initDefaultCommand() { setDefaultCommand(new Drive()); }

  public void tankDrive(double leftPower, double rightPower) {
    this.left1.set(leftPower);
    this.left2.set(leftPower);
    this.right1.set(rightPower);
    this.right2.set(rightPower);
  }
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    public void arcadeDrive(double power, double rotation) { tankDrive(power - rotation, power + rotation); }
  
    public void stop() { tankDrive(0.0D, 0.0D); }
}
