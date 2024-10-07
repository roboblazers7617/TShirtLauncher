// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import io.github.roboblazers7617.buttonbox.ButtonBoxServer;
import io.github.roboblazers7617.buttonbox.controls.TestControl;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ButtonBox extends SubsystemBase {
	private final ButtonBoxServer buttonBox;

	/** Creates a new ButtonBox */
	public ButtonBox() {
		buttonBox = new ButtonBoxServer();
		buttonBox.addControl(new TestControl());
	}
}
