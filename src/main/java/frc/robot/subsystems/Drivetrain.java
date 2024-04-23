// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
	// Create drivetrain motors
	TalonSRX motorLeft = new TalonSRX(DrivetrainConstants.leftMotorID);
	TalonSRX motorRight = new TalonSRX(DrivetrainConstants.rightMotorID);
	
	TalonSRXConfiguration motorConfig = new TalonSRXConfiguration();
	
	/** Creates a new Drivetrain. */
	public Drivetrain() {
		motorConfig.peakCurrentLimit = 40; // the peak current, in amps
		motorConfig.peakCurrentDuration = 1500; // the time at the peak current before the limit triggers, in ms
		motorConfig.continuousCurrentLimit = 30; // the current to maintain if the peak limit is triggered
		
		motorLeft.configAllSettings(motorConfig); // apply the config settings; this selects the quadrature encoder
		motorRight.configAllSettings(motorConfig); // apply the config settings; this selects the quadrature encoder
		
		motorLeft.setInverted(false);
		motorRight.setInverted(true);
	}
	
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
	
	public void setMotorSpeeds(double leftPercentage, double rightPercentage) {
		motorLeft.set(TalonSRXControlMode.PercentOutput, leftPercentage);
		motorRight.set(TalonSRXControlMode.PercentOutput, rightPercentage);
	}
	
	public Command TankDrive(double leftPercentage, double rightPercentage) {
		return Commands.runOnce(() -> {
			setMotorSpeeds(leftPercentage, rightPercentage);
		}, this);
	}
}
