package LearnWithBook.chapter12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {

    static JFrame frame = new JFrame("My First Music Video");
    static DrawPanel m1;

    public static void main(String[] args) {
        MiniMusicPlayer3 miniplayer = new MiniMusicPlayer3();
        miniplayer.go();
    }

    public void setUpGui() {
        m1 = new DrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(m1);
        frame.getContentPane().add(BorderLayout.CENTER, m1);
        frame.setSize(400, 400);
        //frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(m1, new int[] {127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //int r = 0;
            for (int i = 0; i < 60; i +=4) {
                int r = (int)((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public MidiEvent makeEvent(int commnd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage shrtmsg = new ShortMessage();
            shrtmsg.setMessage(commnd, chan, one, two);
            event = new MidiEvent(shrtmsg, tick);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }

    class DrawPanel extends JPanel implements ControllerEventListener {

        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            frame.repaint();
        }

        public void paintComponents(Graphics g) {
            if (msg) {

                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                Color randomColor = new Color(red, green, blue);
                g.setColor(randomColor);
                //g.setColor(new Color(red, green, blue));

                int x = (int) ((Math.random() * 250) + 10);
                int y = (int) ((Math.random() * 250) + 10);
                int width = (int) ((Math.random() * 80) + 10);
                int height = (int) ((Math.random() * 80) + 10);
                g.fillRect(x, y, width, height);

                msg = false;
            }
        }
    }
}
