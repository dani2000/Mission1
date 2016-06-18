import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class Main {
	public static void main(String[] args) {
		
		SuivreLaLigne l = new SuivreLaLigne();
		Tourner t = new Tourner();
		Calage c = new Calage();
		Frapper f = new Frapper();
		AvancerEtReculer ar = new AvancerEtReculer();
		EV3MediumRegulatedMotor moteurFrappe = new EV3MediumRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor roueDroite = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor roueGauche = new EV3LargeRegulatedMotor(MotorPort.B);
		
		SampleProvider color = new EV3ColorSensor(SensorPort.S3).getRedMode();
		SampleProvider Dis = new EV3UltrasonicSensor(SensorPort.S4).getDistanceMode();
		
		float[] sampleC = new float[color.sampleSize()];
		float[] sampleD = new float[Dis.sampleSize()];
		EV3LargeRegulatedMotor[] syncList = new EV3LargeRegulatedMotor[1];
		syncList[0] = roueDroite;
		
		c.Calage(roueDroite, roueGauche, color);
		while(true){
			l.SuivreLigne(roueDroite, roueGauche, color);
			t.TournerDroit(roueDroite, roueGauche);
			ar.Avancer(roueDroite, roueGauche, Dis);
			f.Frapper(moteurFrappe);
			ar.Reculer(roueDroite, roueGauche, Dis);
			t.TournerGauche(roueDroite, roueGauche);
		}
	}

}
