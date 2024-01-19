package SeleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotClass {
	
	public static void test() throws AWTException {
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_KP_DOWN);
		robot.keyPress(KeyEvent.VK_TAB);
	}

}