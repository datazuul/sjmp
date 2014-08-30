package sjmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
public class Action {

    JFileChooser FileChooser = new JFileChooser();
    Mp3Filter filter = new Mp3Filter();
    PlsFilter PlsFilter = new PlsFilter();
    ArrayList listSong = new ArrayList();
    int statusPlay = 0;
    int duration = 1;
    Player player;
    sjmp.Player ply;
    File song, mp3;
    FileOutputStream fos;
    FileInputStream fis;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    String artis, album, year, title, info, bitrate, samplerate, channels,
            comment;
    ID3v1Tag id3;
    MPEGAudioFrameHeader mp3header;

    /** method adding multiple mp3 files using MultiSelection Mode
     *  and convert multiple files to arraylist
     * @param frame
     */
    public void addFile(JFrame frame) {
        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileChooser.setFileFilter(filter);
        FileChooser.setMultiSelectionEnabled(true);
        int fileValid = FileChooser.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        else if(fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File[] file = FileChooser.getSelectedFiles();
            listSong.addAll(Arrays.asList(file));
        }
    }

    public void addFolder(JFrame frame) {
        FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        FileChooser.setAcceptAllFileFilterUsed(false);
        int fileValid = FileChooser.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        else if(fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File[] files = FileChooser.getSelectedFile().
                    listFiles(new ScanDir());
           listSong.addAll(Arrays.asList(files));
        }
    }


    /** method adding singel mp3 file
     *  the only convert one file to playlist arraylist
     * @param frame
     */

    public void openFile(JFrame frame) {
        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileChooser.setFileFilter(filter);
        FileChooser.setMultiSelectionEnabled(false);
        int fileValid = FileChooser.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        if(fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File file = FileChooser.getSelectedFile();
            listSong.add(file);
        }
    }

    /** method read arraylist by returning arraylist value
     *
     * @return
     */
    public ArrayList getListSong() {
        return listSong;
    }

    /** remove selected song in Jlist
     *  then convert it to arraylist index
     * @param index
     */
    public void deleteFile(int index) {
        listSong.remove(index);
    }

    /** remove all content in arraylist (listSong)
     *
     */
    public void deletePlaylist () {
        listSong.removeAll(listSong);
    }

    /** save arraylist to temporary file in same folder
     *  with SJMP JAR
     */

    public void saveList(){
        try {
            fos = new FileOutputStream("song.list");
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < listSong.size(); i++){
                File tmp = (File) listSong.get(i);
                oos.writeObject(tmp);
            }
            oos.close();
        }
        catch (Exception e)
        {
            
        }
    }

    /** Method save as Playlist to a file using in spesific location
     *  write all content in arraylist to a file
     * @param frame
     */

    public void saveAsPlaylist(JFrame frame) {
        FileChooser.setFileFilter(PlsFilter);
        FileChooser.setMultiSelectionEnabled(false);
        int Valid = FileChooser.showSaveDialog(frame);
        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        else if (Valid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File pls = FileChooser.getSelectedFile();
            try {
            fos = new FileOutputStream(pls+".list");
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < listSong.size(); i++){
                File tmp = (File) listSong.get(i);
                oos.writeObject(tmp);
            }
            oos.close();
        }
        catch (Exception e)
        {
            
        }
        }
    }



    public void readList() {
        try {
            fis = new FileInputStream("Song.list");
            ois = new ObjectInputStream(fis);
            File tmp;
            while ((tmp = (File) ois.readObject()) != null) {
                listSong.add(tmp);
            }
            if ((tmp = (File) ois.readObject()) == null) {
                listSong.isEmpty();
            }
        ois.close();
        } catch (Exception e) {
        }
     }

    /** Method read arraylist in file at spesific location
     *  then write it to Arraylist Component (JList)
     * @param frame
     */

    public void openPls(JFrame frame) {
        FileChooser.setFileFilter(PlsFilter);
        FileChooser.setMultiSelectionEnabled(false);
        int Valid = FileChooser.showOpenDialog(frame);
        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        if(Valid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File pls = FileChooser.getSelectedFile();
            try {
            fis = new FileInputStream(pls);
            ois = new ObjectInputStream(fis);
            File tmp;
            while ((tmp = (File) ois.readObject()) != null) {
                listSong.add(tmp);
            }
            if ((tmp = (File) ois.readObject()) == null) {
                listSong.isEmpty();
            }
        ois.close();
        } catch (Exception e) {
        }
        }
    }

    /** read mp3 filename then convert it to String
     *
     * @return
     */
    public String getTitle() {
        return song.getName();
    }

    /** Method convert selected index to mp3 location then read ID3tag
     *  and all mp3 info including Bitrate, Sample rate and Audio channels
     * @param index
     */
    public void setNewSong(int index) {
        song = (File) listSong.get(index);
        try {
            player = Manager.createPlayer(song.toURL());
            mp3 = song;
            id3 = new ID3v1Tag(mp3);
            artis = id3.getArtist();
            title = id3.getTitle();
            album = id3.getAlbum();
            year = id3.getYear();
            mp3header = new MPEGAudioFrameHeader(song);
            bitrate = String.valueOf(mp3header.getBitRate());
            samplerate = String.valueOf(mp3header.getSampleRate());
            channels = mp3header.getChannelMode();
        } catch (Exception ex) {
            
        }
    }

    /** Method play mp3 and convert mp3 length from long to int
     * 
     * @param index
     */

    public void playMusic(int index) {
        if (statusPlay == 0) {
            setNewSong(index);
        } else if (statusPlay == 1) {
            player.stop();
            setNewSong(index);
        }
        player.start();
        statusPlay = 1;
        player.realize();
        player.addControllerListener(new ControllerListener() {

            @Override
            public void controllerUpdate(ControllerEvent event) {
                if (event instanceof RealizeCompleteEvent) {
                    double dur = player.getDuration().getSeconds();
                    duration = (int) Math.floor(dur);
                }
            }
        });
    }

    /**  Method Pause Playing mp3 then set a value for playing status
     *
     */
    public void pauseMusic() {
        player.stop();
        statusPlay = 2;
    }

    /** Method Stop Playing mp3 then set a value for playing status
     *
     */
    public void stopMusic() {
        player.stop();
        player.close();
        statusPlay = 0;
    }

    /** return song totaltime/length value to Integer
     * 
     * @return
     */
    public int getPlayerDuration() { 
        return duration;
    }

    public void readID3(int index) {
        song = (File) listSong.get(index);
        try {
            id3 = new ID3v1Tag(song);
            artis = id3.getArtist();
            title = id3.getTitle();
            album = id3.getAlbum();
            year = id3.getYear();
            mp3header = new MPEGAudioFrameHeader(song);
            bitrate = String.valueOf(mp3header.getBitRate());
            samplerate = String.valueOf(mp3header.getSampleRate());
            channels = mp3header.getChannelMode();
        } catch (Exception ex) {

        }
    }

    /** return ID3Tag And another info value to String
     *
     * @return
     */
    public String getID3() {
        info = "<html><b>Title : </b>" + title +
                "<p><b>Artist : </b>" + artis +
                "<p><b>Album : </b>" + album +
                "<p><b>Year : </b>" + year +
                "<p><b>Bitrate : </b>" + bitrate + " kbps" +
                "<p><b>Sample Rate : </b>" + samplerate + " Hz" +
                "<p><b>Channels : </b>" + channels
                + "<b>FileSize : </b>" + (song.length() / 1024) + " KB"
                + "<p><b>Location : </b>"
                + song.getAbsolutePath();
        return info;
    }
}