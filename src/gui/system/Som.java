package gui.system;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Som {

    private Clip clip;
    private URL somURL[]= new URL[30];

    public Som(){

        somURL[0]=getClass().getResource("/sons/UltimaFronteira.wav");
        somURL[1]=getClass().getResource("/sons/cursor.wav");
        somURL[2]=getClass().getResource("/sons/andando.wav");


    }

    public void pegarArquivo(int i){

        try{

            AudioInputStream ais= AudioSystem.getAudioInputStream(somURL[i]);
            clip= AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {

        }
    }

    public void play(){

        clip.start();
    }

    public  void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){

        clip.stop();
    }
}
