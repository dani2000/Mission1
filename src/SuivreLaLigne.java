import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class SuivreLaLigne {
	private double Lumiere, Correction, VitesseC,VitesseB;
	public static float[]sample;
	
	public SuivreLaLigne(){
		sample = new float[1];

	}
	
	public void suivreLigne(EV3LargeRegulatedMotor roueDroite, EV3LargeRegulatedMotor roueGauche,SampleProvider color){
		
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
	}
}
