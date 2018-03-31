// Don't forget to import the midi package.
import javax.sound.midi.*;

public class MiniMiniMusicApp {

  public static void main(String[] args) {
    MiniMiniMusicApp mini = new MiniMiniMusicApp();
    mini.play();
  } // close main

  public void play() {
    try {

     /**
      * Get a Sequencer and open it (so we can use it... a Sequencer doesn't come already open).
      */
      Sequencer player = MidiSystem.getSequencer();
      player.open();

     /**
      * Don't worry about the arguments to the Sequence constructor. 
      */
      Sequence seq = new Sequence(Sequence.PPQ, 4);


     /**
      * Ask the Sequencer for a Track. Remember, the Track lives in the Sequence, and the MIDI
      * data lives in the Track.
      */
      Track track = seq.createTrack();

     /**
      * Put some MIDIEvents into the Track. This part is mostly "Ready-bake" code. The only thing 
      * you'll have to care about are the arguments to the setMessage() method, and the arguments
      * to the MIDIEvent constructor. We'll look at those arguments on the next page.
      */
      ShortMessage a = new ShortMessage();    // Make a Message
      a.setMessage(144, 1, 44, 100);          // This message says, "start playing note `44`"
     /**
      * The instructions are in the message, but the MIDIEvent adds the moment in time when the
      * instruction should be triggered. This MIDIEvent says to trigger message `a` at the first
      * beat (beat 1).
      */
      MidiEvent noteOn = new MidiEvent(a, 1);
     /**
      * A Track holds all the MIDIEvent objects. The sequence organizes them according to when each
      * event is supposed to happen, and then the Sequencer plays them back in that order. You can 
      * have lots of events happening at the exact same moment in time. For example, you might want
      * two notes played simultaneously, or even different instruments playing different sounds at
      * the same time.
      */
      track.add(noteOn);

      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, 44, 100);
      MidiEvent noteOff = new MidiEvent(b, 16);
      track.add(noteOff);

     /**
      * Give the Sequence to the Sequencer (like putting the CD in the CD player). 
      */
      player.setSequence(seq);

     /**
      * Invoke start() on the Sequencer (like pushing PLAY).
      */
      player.start();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  } // close play
} // close class
