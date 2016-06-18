/*import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.TachoMotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Old {

	public static void main(String[] args) {
		
		float Distance;
		double Lumiere, VitesseC, VitesseB,Correction;
		EV3LargeRegulatedMotor roueDroite = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor roueGauche = new EV3LargeRegulatedMotor(MotorPort.B);
		
		// TODO Auto-generated method stub
		SampleProvider color = new EV3ColorSensor(SensorPort.S3).getRedMode();
		SampleProvider Dis = new EV3UltrasonicSensor(SensorPort.S4).getDistanceMode();
		float[] sample = new float[color.sampleSize()];
		float[] sampleD = new float[Dis.sampleSize()];
		EV3LargeRegulatedMotor[] syncList = new EV3LargeRegulatedMotor[1];
		syncList[0] = roueDroite;

		roueDroite.forward();
		roueGauche.forward();
		while (true) {
			
			color.fetchSample(sample, 0);
			Lumiere = sample[0];

			Correction = (Lumiere - 0.405) * 0.2;
			VitesseC = ((Correction * -1) + 0.2) * roueDroite.getMaxSpeed();
			VitesseB = ((Correction * 1) + 0.2) * roueGauche.getMaxSpeed();

			roueDroite.setSpeed((float) VitesseC);
			roueGauche.setSpeed((float) VitesseB);
			Delay.msDelay(16);
			roueDroite.forward();
			roueGauche.forward();
			if(roueDroite.getTachoCount() >= 1000){
				roueGauche.stop();
				roueDroite.stop();
				roueDroite.rotate(385);
				Dis.fetchSample(sampleD, 0);
				
				if(sampleD[0] <= 60){
				
					Dis.fetchSample(sampleD, 0);
					Distance = sampleD[0];
					roueGauche.synchronizeWith(syncList);
					roueGauche.setSpeed(100);
					roueDroite.setSpeed(100);
					
					roueGauche.startSynchronization();
					roueGauche.rotate((int)((Distance*100)/(5.6*3.14)*360));
					roueDroite.rotate((int)((Distance*100)/(5.6*3.14)*360));
					roueGauche.endSynchronization();
					}
				
				roueDroite.rotate(-385);
				roueDroite.resetTachoCount();
			}
		}
	}

}*/