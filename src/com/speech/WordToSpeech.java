package com.speech;

import com.sun.speech.freetts.FreeTTS;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
import javax.sound.sampled.AudioFileFormat.Type;

public class WordToSpeech {


    public static void main(String[] args) {

        FreeTTS freetts;
        AudioPlayer audioPlayer = null;
        String voiceName = "kevin16";

        System.out.println();
        System.out.println("Using voice: " + voiceName);


        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice helloVoice = voiceManager.getVoice(voiceName);

        if (helloVoice == null) {
            System.err.println(
                    "Cannot find a voice named "
                            + voiceName + ".  Please specify a different voice.");
            System.exit(1);
        }


        helloVoice.allocate();


        audioPlayer = new SingleFileAudioPlayer("D://Projects//WebAppl//web//Subway",Type.WAVE);

        helloVoice.setAudioPlayer(audioPlayer);



        helloVoice.speak("Subway");



        /* Clean up and leave.
         */
        helloVoice.deallocate();
//don't forget to close the audioplayer otherwise file will not be saved
        audioPlayer.close();
        System.exit(0);
    }
}