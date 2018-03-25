import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.io.File;

class playMusic {
	playMusic() {
		String bgm = "DECISIVE_BATTLE.wav";
		String alert = "Emergency.wav";
		try {
			Clip clip1 = AudioSystem.getClip();
			Clip clip2 = AudioSystem.getClip();
			AudioInputStream in1 = AudioSystem.getAudioInputStream(new File(bgm));
			AudioInputStream in2 = AudioSystem.getAudioInputStream(new File(alert));
			clip1.open(in1);
			clip2.open(in2);
			FloatControl control1 = (FloatControl)clip1.getControl(FloatControl.Type.MASTER_GAIN);
			FloatControl control2 = (FloatControl)clip2.getControl(FloatControl.Type.MASTER_GAIN);
			controlByLinearScalar(control1, 2.0);
			controlByLinearScalar(control2, 0.4);
			clip1.loop(3);
			clip2.loop(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void controlByLinearScalar(FloatControl control, double linearScalar) {
		control.setValue((float)Math.log10(linearScalar) * 20);
	}
}