// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
	/**
	 * Constants for the operator controls.
	 */
	public static class OperatorConstants {
		/**
		 * Controller port for the driver controller.
		 */
		public static final int kDriverControllerPort = 0;
		/**
		 * Joystick deadband for the controller.
		 */
		public static final double controllerDeadband = 0.05;
	}

	/**
	 * Constants for the drivetrain.
	 */
	public static class DrivetrainConstants {
		/**
		 * CAN ID for the left leader motor controller.
		 */
		public static final int leftLeaderID = 0;
		/**
		 * CAN ID for the right leader motor controller.
		 */
		public static final int rightLeaderID = 1;
		/**
		 * CAN ID for the left follower motor controller.
		 */
		public static final int leftFollowerID = 2;
		/**
		 * CAN ID for the right follower motor controller.
		 */
		public static final int rightFollowerID = 3;
	}

	/**
	 * Constants for the LEDs.
	 */
	public static class LEDConstants {
		/**
		 * PWM pin that the LEDs are connected to. This must be a PWM header, not MXP or DIO.
		 */
		public static final int LED_STRIP_PIN = 9;
		/**
		 * Length of the LED strip.
		 */
		public static final int LED_STRIP_LENGTH = 180;
	}
}
