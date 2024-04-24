// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
	// Create drivetrain motors
	TalonSRX motorLeftLeader = new TalonSRX(DrivetrainConstants.leftLeaderID);
	TalonSRX motorRightLeader = new TalonSRX(DrivetrainConstants.rightLeaderID);
	TalonSRX motorLeftFollower = new TalonSRX(DrivetrainConstants.leftFollowerID);
	TalonSRX motorRightFollower = new TalonSRX(DrivetrainConstants.rightFollowerID);
	
	TalonSRXConfiguration motorConfig = new TalonSRXConfiguration();
	
	/** Creates a new Drivetrain. */
	public Drivetrain() {
		// Motor configuration for all motors
		motorConfig.peakCurrentLimit = 40; // the peak current, in amps
		motorConfig.peakCurrentDuration = 1500; // the time at the peak current before the limit triggers, in ms
		motorConfig.continuousCurrentLimit = 30; // the current to maintain if the peak limit is triggered
		
		// Apply the config settings; this selects the quadrature encoder
		motorLeftLeader.configAllSettings(motorConfig);
		motorRightLeader.configAllSettings(motorConfig);
		motorLeftFollower.configAllSettings(motorConfig);
		motorRightFollower.configAllSettings(motorConfig);
		
		// Set up followers to follow leaders
		motorLeftFollower.follow(motorLeftLeader);
		motorRightFollower.follow(motorRightLeader);
		
		// Set up motor inverting
		motorLeftLeader.setInverted(false);
		motorRightLeader.setInverted(true);
		
		// Set up followers to follow leader's invert values
		motorLeftFollower.setInverted(InvertType.FollowMaster);
		motorRightFollower.setInverted(InvertType.FollowMaster);
	}
	
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
	
	/**
	 * Set motor speeds
	 * 
	 * @param leftPercentage
	 *            left side speed [-1,1]
	 * @param rightPercentage
	 *            right side speed [-1,1]
	 */
	public void setMotorSpeeds(double leftPercentage, double rightPercentage) {
		motorLeftLeader.set(TalonSRXControlMode.PercentOutput, leftPercentage);
		motorRightLeader.set(TalonSRXControlMode.PercentOutput, rightPercentage);
	}
	
	/**
	 * Set motor speeds for tank drive
	 * 
	 * @param leftPercentage
	 *            left side speed [-1,1]
	 * @param rightPercentage
	 *            right side speed [-1,1]
	 * @return Command
	 */
	public Command TankDrive(double leftPercentage, double rightPercentage) {
		return Commands.runOnce(() -> {
			setMotorSpeeds(leftPercentage, rightPercentage);
		}, this);
	}
}