package TheAvengers;
import robocode.*;

import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Tony - a robot by (your name here)
 */
public class Tony extends TeamRobot
{

	public void run() {
		
		setColors(Color.red,Color.black,Color.yellow);
		setBulletColor(Color.blue);
		setScanColor(Color.blue);
		
		while(true) {

			
			// Replace the next 4 lines with any behavior you would like
			setTurnRight(2000);
			setAhead(40000);	
				
			//turnGunRight(50);		
			turnGunLeft(45);	
			execute();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double distance = e.getDistance();
		double gunTurnAmt = normalRelativeAngle(e.getBearing() + (getHeading() - getRadarHeading()));
        setTurnGunRight(gunTurnAmt);
		if(distance<60){
			fire(6);
			
			return;
		} 
		if(distance<120){
			fire(3);
			fire(1);
			return;
		}
		if(distance<200){
			fire(2);
			fire(1);
			return;
		}
		if(distance>200){
			fire(1);
			fire(1);
			return;
		}
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//setTurnRight(3000);
		setBack(5000);
		execute();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		back(250);
		//setTurnRight(60);
		//setAhead(300);
		execute();

		
	}	
	
	public void onHitRobot(HitRobotEvent e) {
		//setTurnRight(10000);
		//setBack(10000);
		back(30);
		execute();
		//ahead(100);
	}
	
	public double normalRelativeAngle(double angle) {
		if (angle > -180 && angle <= 180) {
			return angle;
		}
		double fixedAngle = angle;
	
		while (fixedAngle <= -180) {
			fixedAngle += 360;
		}
		while (fixedAngle > 180) {
			fixedAngle -= 360;
		}
		return fixedAngle;
	}
}
