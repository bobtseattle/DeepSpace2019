package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;
import org.usfirst.frc.team2412.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftAxisCommand extends CommandBase {

	public LiftAxisCommand() {
		requires(liftSubsystem);
	}
	 
	public void execute() {
		// liftSubsystem.liftAxisPID(Robot.m_oi.coDriverArduinoButtons.getRawAxis(OI.MANUAL_AXIS), 0, 1, 0.2, false);

		double axisValue = Robot.m_oi.coDriverArduinoButtons.getRawAxis(OI.MANUAL_AXIS);

		if(RobotMap.XBOX){
			axisValue = (Robot.m_oi.XboxController.getRawAxis(2)+Robot.m_oi.XboxController.getRawAxis(3))/1.5;
		}


		liftSubsystem.liftAxis(Math.pow(axisValue,3));
		SmartDashboard.putNumber("Lift position (rotations)", liftSubsystem.getPosition());
		System.out.println("Lifting with joystick axis...");
	}

	protected void end() {
		liftSubsystem.liftStop();
	}
}
