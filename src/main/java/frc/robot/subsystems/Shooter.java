// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
	// DoubleSolenoid corresponds to a double solenoid.
	// Solenoid valve for shooting cylinder
	private final DoubleSolenoid shooterSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ShooterConstants.solenoidForwardChannel, ShooterConstants.solenoidReverseChannel);
	
	/** Creates a new Drivetrain. */
	public Shooter() {
		// Initialize the solenoid valve so it starts in a known position
		shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
	
	/**
	 * Shoots
	 * Returns after shooting sequence is complete
	 */
	public Command Shoot() {
		return Commands.runOnce(() -> {
			shooterSolenoid.set(DoubleSolenoid.Value.kForward);
		});
	}
	
	/**
	 * Stows
	 */
	public Command Stow() {
		return Commands.runOnce(() -> {
			shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
		});
	}
}