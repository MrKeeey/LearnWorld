package LearnWithBook.chapter11;

import javax.sound.midi.*;
import java.util.Scanner;

public class MiniMusicCmdLine {
    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        String str1, str2;

        Scanner scanner = new Scanner(System.in);
        str1 = scanner.nextLine();
        str2 = scanner.nextLine();

        if (str1 == null && str2 == null) {
            System.out.println("You forgot to write arguments for instruments. Try again!");
        } else {
            int instrument = Integer.parseInt(str1);
            int note = Integer.parseInt(str2);
            mini.play(instrument, note);
        }
    }

    public void play(int instrument, int note){
        try {

            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1, instrument,0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,note,100);
            MidiEvent noteON = new MidiEvent(a, 1);
            track.add(noteON);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,note,100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}