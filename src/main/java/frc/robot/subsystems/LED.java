// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LEDConstants;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

/**
 * Subsystem that controls the LEDs.
 */
public class LED extends SubsystemBase {
	private AddressableLED ledStrip;
	private AddressableLEDBuffer ledBuffer;

	/** Creates a new LED. */
	public LED() {
		ledStrip = new AddressableLED(LEDConstants.LED_STRIP_PIN);

		ledBuffer = new AddressableLEDBuffer(LEDConstants.LED_STRIP_LENGTH);
		ledStrip.setLength(ledBuffer.getLength());

		// Set the data
		ledStrip.setData(ledBuffer);
		ledStrip.start();

		// Write a solid color to the strip
		for (var i = 0; i < ledBuffer.getLength(); i++) {
			// Sets the specified LED to the RGB values for red
			ledBuffer.setRGB(i, 255, 0, 0);
		}
		ledStrip.setData(ledBuffer);
	}

	@Override
	public void periodic() {}
}
