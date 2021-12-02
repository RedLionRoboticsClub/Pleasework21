
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="pleasework21", group="Test")

public class pleasework21 extends LinearOpMode {

    BasicHardwareMap2122 robot = new BasicHardwareMap2122();

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.init(hardwareMap);

        double motorPower = 1;

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            double yLValue = gamepad1.left_stick_y;
            double yRValue = gamepad1.right_stick_y;
            double xLValue = gamepad1.left_stick_x;
            double xRValue = gamepad1.right_stick_x;

            boolean changed = false;
            boolean changed0 = false;
            boolean changed1 = false;
            boolean changed2 = false;
            boolean changed3 = false;



//Dont worry about the math right now I think, thats a later issue
            double radL = Math.sqrt(Math.pow(xLValue, 2) + Math.pow(yLValue, 2));

            double radR = Math.sqrt(Math.pow(xRValue, 2) + Math.pow(yRValue, 2));

            loop();
            {
                if (gamepad1.left_bumper && !changed) {
                    if (motorPower == 1) {
                        while (gamepad1.b) {
                            motorPower = .1;
                        }
                    }
                }
            }
            loop();
            {

                if (gamepad1.left_stick_y > 0) {

                    robot.motorBR.setPower(-motorPower);


                }
                if (gamepad1.left_stick_y < 0) {

                    robot.motorBR.setPower(motorPower);


                } else {

                    robot.motorBR.setPower(0);
                }
            }


            loop();
            {
                if (gamepad1.right_stick_y > 0) {

                    robot.motorBL.setPower(-motorPower);


                }
                if (gamepad1.right_stick_y < 0) {

                    robot.motorBL.setPower(motorPower);


                } else {

                    robot.motorBL.setPower(0);
                }

            }
        }

    }
}



