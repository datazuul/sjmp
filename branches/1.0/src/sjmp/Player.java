package sjmp;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Time;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Player extends javax.swing.JFrame {

    /** Setting Look and Feel to Nimbus
     *  Set location to center screen
     *  Disable mute/unmute Button & Volume Slider
     *  Load Saved Playlist
     */
    public Player() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
          Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x = screenSize.width / 4;//change 4 to 2 if apps doesn't show in center
        y = screenSize.height / 4;//
        initComponents();
        this.setLocation(x,y);
        action.readList();
        updateList();
        btnVolume.setEnabled(false);
        vlmSlide.setEnabled(false);
		seekBar.setEnabled(false);
		
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trayPopup = new java.awt.PopupMenu();
        Show = new java.awt.MenuItem();
        Play = new java.awt.MenuItem();
        Pause = new java.awt.MenuItem();
        Stop = new java.awt.MenuItem();
        Next = new java.awt.MenuItem();
        Prev = new java.awt.MenuItem();
        Quit = new java.awt.MenuItem();
        btnOpen = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSong = new javax.swing.JList();
        lblSong = new javax.swing.JLabel();
        lblPls = new javax.swing.JLabel();
        btnVolume = new javax.swing.JToggleButton();
        lblInfo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        vlmSlide = new javax.swing.JSlider();
        lblVolume = new javax.swing.JLabel();
        seekBar = new javax.swing.JSlider();
        lblTime = new javax.swing.JLabel();
        sjmpMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuOpen = new javax.swing.JMenuItem();
        menuClose = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSeparator = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        menuNav = new javax.swing.JMenu();
        menuPlay = new javax.swing.JMenuItem();
        menuPause = new javax.swing.JMenuItem();
        menuStop = new javax.swing.JMenuItem();
        menuPrev = new javax.swing.JMenuItem();
        menuNext = new javax.swing.JMenuItem();
        menuJump = new javax.swing.JMenuItem();
        menuPls = new javax.swing.JMenu();
        menuAdd = new javax.swing.JMenuItem();
        menuAdddir = new javax.swing.JMenuItem();
        menuRemove = new javax.swing.JMenuItem();
        menuRemAll = new javax.swing.JMenuItem();
        openList = new javax.swing.JMenuItem();
        saveList = new javax.swing.JMenuItem();
        menuMoveUp = new javax.swing.JMenuItem();
        menuMoveDown = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        ChangeLog = new javax.swing.JMenuItem();
        AboutBox = new javax.swing.JMenuItem();

        trayPopup.setLabel("popupMenu1");

        Show.setLabel("Show");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });
        trayPopup.add(Show);
        trayPopup.addSeparator();
        Play.setLabel("Play");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });
        trayPopup.add(Play);

        Pause.setLabel("Pause");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });
        trayPopup.add(Pause);

        Stop.setLabel("Stop");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
        trayPopup.add(Stop);

        Next.setLabel("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        trayPopup.add(Next);

        Prev.setLabel("Prev");
        Prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevActionPerformed(evt);
            }
        });
        trayPopup.add(Prev);
        trayPopup.addSeparator();
        Quit.setLabel("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        trayPopup.add(Quit);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SJMP (Simple Java MP3 Player)");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-open-folder.png"))); // NOI18N
        btnOpen.setToolTipText("Play Single File");
        btnOpen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOpen.setBorderPainted(false);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/list-add.png"))); // NOI18N
        btnAdd.setToolTipText("Add Mp3 to Playlist");
        btnAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusCycleRoot(true);
        btnAdd.setMaximumSize(new java.awt.Dimension(32, 32));
        btnAdd.setMinimumSize(new java.awt.Dimension(32, 16));
        btnAdd.setPreferredSize(new java.awt.Dimension(24, 24));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/list-remove.png"))); // NOI18N
        btnRemove.setToolTipText("Remove Selected Mp3 From Playlist");
        btnRemove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRemove.setBorderPainted(false);
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRemove.setFocusCycleRoot(true);
        btnRemove.setPreferredSize(new java.awt.Dimension(32, 32));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media-skip-backward.png"))); // NOI18N
        btnPrev.setToolTipText("Play Previous Song");
        btnPrev.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrev.setBorderPainted(false);
        btnPrev.setPreferredSize(new java.awt.Dimension(48, 32));
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media-playback-stop.png"))); // NOI18N
        btnStop.setToolTipText("Stop Song");
        btnStop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnStop.setBorderPainted(false);
        btnStop.setPreferredSize(new java.awt.Dimension(48, 48));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media-playback-start.png"))); // NOI18N
        btnPlay.setToolTipText("Start/Resume Song");
        btnPlay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPlay.setBorderPainted(false);
        btnPlay.setFocusCycleRoot(true);
        btnPlay.setPreferredSize(new java.awt.Dimension(56, 56));
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media-playback-pause.png"))); // NOI18N
        btnPause.setToolTipText("Pause Current Playing Song");
        btnPause.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPause.setBorderPainted(false);
        btnPause.setPreferredSize(new java.awt.Dimension(48, 48));
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media-skip-forward.png"))); // NOI18N
        btnNext.setToolTipText("Play Next Song");
        btnNext.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNext.setBorderPainted(false);
        btnNext.setPreferredSize(new java.awt.Dimension(48, 32));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        listSong.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listSong.setToolTipText("List of Song's");
        listSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSongMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listSongMouseReleased(evt);
            }
        });
        listSong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listSongKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listSong);

        lblSong.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblSong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSong.setText("Select File To Play");
        lblSong.setToolTipText("Song File Name");
        lblSong.setPreferredSize(new java.awt.Dimension(320, 32));

        lblPls.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblPls.setText("Playlist");
        lblPls.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        btnVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unmute.png"))); // NOI18N
        btnVolume.setToolTipText("Mute / Unmute Volume\n");
        btnVolume.setContentAreaFilled(false);
        btnVolume.setPreferredSize(new java.awt.Dimension(24, 24));
        btnVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolumeActionPerformed(evt);
            }
        });

        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MP3 Info");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setPreferredSize(new java.awt.Dimension(64, 21));

        vlmSlide.setToolTipText("Adjust Player Volume");
        vlmSlide.setValue(100);
        vlmSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vlmSlideMouseClicked(evt);
            }
        });
        vlmSlide.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                vlmSlideMouseDragged(evt);
            }
        });

        lblVolume.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVolume.setToolTipText("Display Volume Value");

        seekBar.setPaintLabels(true);
        seekBar.setPaintTicks(true);
        seekBar.setSnapToTicks(true);
        seekBar.setValue(0);
        seekBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seekBarMouseClicked(evt);
            }
        });
        seekBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                seekBarMouseDragged(evt);
            }
        });

        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sjmpMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0)));

        menuFile.setText("File");
        menuFile.setFont(new java.awt.Font("Tahoma", 1, 12));

        menuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-open-folder.png"))); // NOI18N
        menuOpen.setText("Open");
        menuOpen.setToolTipText("Open & Play Single Mp3 File");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenActionPerformed(evt);
            }
        });
        menuFile.add(menuOpen);

        menuClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dialog-close.png"))); // NOI18N
        menuClose.setText("Close");
        menuClose.setToolTipText("Stop Currently Playing & Clear Playlist");
        menuClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloseActionPerformed(evt);
            }
        });
        menuFile.add(menuClose);

        jMenuItem1.setText("Properties");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuFile.add(jMenuItem1);
        menuFile.add(menuSeparator);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application-exit.png"))); // NOI18N
        menuExit.setText("Exit");
        menuExit.setToolTipText("Exit Program");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        sjmpMenu.add(menuFile);

        menuNav.setText("Navigate");
        menuNav.setFont(new java.awt.Font("Tahoma", 1, 12));

        menuPlay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, 0));
        menuPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/start.png"))); // NOI18N
        menuPlay.setText("Play");
        menuPlay.setToolTipText("Play Song");
        menuPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPlayActionPerformed(evt);
            }
        });
        menuNav.add(menuPlay);

        menuPause.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        menuPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png"))); // NOI18N
        menuPause.setText("Pause");
        menuPause.setToolTipText("Pause Song");
        menuPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPauseActionPerformed(evt);
            }
        });
        menuNav.add(menuPause);

        menuStop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, 0));
        menuStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stop.png"))); // NOI18N
        menuStop.setText("Stop");
        menuStop.setToolTipText("Stop Playing Song");
        menuStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStopActionPerformed(evt);
            }
        });
        menuNav.add(menuStop);

        menuPrev.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, 0));
        menuPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backward.png"))); // NOI18N
        menuPrev.setText("Previous");
        menuPrev.setToolTipText("Play Previous Song In Playlist");
        menuPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPrevActionPerformed(evt);
            }
        });
        menuNav.add(menuPrev);

        menuNext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, 0));
        menuNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forward.png"))); // NOI18N
        menuNext.setText("Next");
        menuNext.setToolTipText("Play Next Song In Playlist");
        menuNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNextActionPerformed(evt);
            }
        });
        menuNav.add(menuNext);

        menuJump.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, 0));
        menuJump.setText("Jump To..");
        menuJump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJumpActionPerformed(evt);
            }
        });
        menuNav.add(menuJump);

        sjmpMenu.add(menuNav);

        menuPls.setText("Playlist");
        menuPls.setFont(new java.awt.Font("Tahoma", 1, 12));

        menuAdd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD, 0));
        menuAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mnu-add.png"))); // NOI18N
        menuAdd.setText("Add");
        menuAdd.setToolTipText("Add MP3 File To Playlist");
        menuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddActionPerformed(evt);
            }
        });
        menuPls.add(menuAdd);

        menuAdddir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK));
        menuAdddir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-open-folder.png"))); // NOI18N
        menuAdddir.setText("Add Folder");
        menuAdddir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdddirActionPerformed(evt);
            }
        });
        menuPls.add(menuAdddir);

        menuRemove.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT, 0));
        menuRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mnu-remove.png"))); // NOI18N
        menuRemove.setText("Remove");
        menuRemove.setToolTipText("Remove Selected MP3 From Playlist");
        menuRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveActionPerformed(evt);
            }
        });
        menuPls.add(menuRemove);

        menuRemAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT, java.awt.event.InputEvent.CTRL_MASK));
        menuRemAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-clear.png"))); // NOI18N
        menuRemAll.setText("Remove All");
        menuRemAll.setToolTipText("Clear Playlist");
        menuRemAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemAllActionPerformed(evt);
            }
        });
        menuPls.add(menuRemAll);

        openList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK));
        openList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/openPls.png"))); // NOI18N
        openList.setText("Open Playlist File");
        openList.setToolTipText("Open Saved Playlist");
        openList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openListActionPerformed(evt);
            }
        });
        menuPls.add(openList);

        saveList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        saveList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/savePls.png"))); // NOI18N
        saveList.setText("Save Playlist To");
        saveList.setToolTipText("Save Playlist To Specific Location");
        saveList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveListActionPerformed(evt);
            }
        });
        menuPls.add(saveList);

        menuMoveUp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP, java.awt.event.InputEvent.ALT_MASK));
        menuMoveUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow-up.png"))); // NOI18N
        menuMoveUp.setText("Move Up");
        menuMoveUp.setToolTipText("Move Selected Song Up");
        menuMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMoveUpActionPerformed(evt);
            }
        });
        menuPls.add(menuMoveUp);

        menuMoveDown.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, java.awt.event.InputEvent.ALT_MASK));
        menuMoveDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow-down.png"))); // NOI18N
        menuMoveDown.setText("Move Down");
        menuMoveDown.setToolTipText("Move Selected Song Down");
        menuMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMoveDownActionPerformed(evt);
            }
        });
        menuPls.add(menuMoveDown);

        sjmpMenu.add(menuPls);

        menuAbout.setText("Help");
        menuAbout.setFont(new java.awt.Font("Tahoma", 1, 12));

        ChangeLog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.SHIFT_MASK));
        ChangeLog.setText("Changelog");
        ChangeLog.setToolTipText("Display Application Changelog Features");
        ChangeLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeLogActionPerformed(evt);
            }
        });
        menuAbout.add(ChangeLog);

        AboutBox.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        AboutBox.setText("About");
        AboutBox.setToolTipText("Display Application Info");
        AboutBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutBoxActionPerformed(evt);
            }
        });
        menuAbout.add(AboutBox);

        sjmpMenu.add(menuAbout);

        setJMenuBar(sjmpMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPls, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
            .addComponent(lblSong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vlmSlide, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lblVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(seekBar, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSong, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTime)
                    .addComponent(lblPls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seekBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnPrev, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnStop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vlmSlide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnPlay, 0, 0, Short.MAX_VALUE)
                                        .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(btnVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Simple MP3 Player Written in Java And Swing");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // TODO add your handling code here:
        sjmpPause();
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
       sjmpAdd();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        sjmpRemove();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        sjmpNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        sjmpPlay();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        sjmpStop();
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        sjmpPrev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        // TODO add your handling code here:
       sjmpOpen();
    }//GEN-LAST:event_menuOpenActionPerformed

    private void menuCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCloseActionPerformed
        // TODO add your handling code here:
        if (action.statusPlay == 1) {
        action.stopMusic();
        timer.cancel();
        seekBar.setValue(0);
        }
        action.deletePlaylist();
        updateList();
        menuClose.setEnabled(false);
    }//GEN-LAST:event_menuCloseActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
            if (action.statusPlay == 1) {
                action.stopMusic();
                action.player.close();
            }
            updateList();
            action.saveList();
            System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddActionPerformed
        // TODO add your handling code here:
       sjmpAdd();
    }//GEN-LAST:event_menuAddActionPerformed

    private void menuRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveActionPerformed
        // TODO add your handling code here:
        sjmpRemove();
    }//GEN-LAST:event_menuRemoveActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        // TODO add your handling code here:
       sjmpOpen();

    }//GEN-LAST:event_btnOpenActionPerformed

    private void menuRemAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemAllActionPerformed
        // TODO add your handling code here:
        sjmpRemAll();
    }//GEN-LAST:event_menuRemAllActionPerformed

    private void menuPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPlayActionPerformed
        // TODO add your handling code here:
        sjmpPlay();
    }//GEN-LAST:event_menuPlayActionPerformed

    private void menuPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPauseActionPerformed
        // TODO add your handling code here:
        sjmpPause();
    }//GEN-LAST:event_menuPauseActionPerformed

    private void menuStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStopActionPerformed
        // TODO add your handling code here:
        sjmpStop();
    }//GEN-LAST:event_menuStopActionPerformed

    private void menuPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrevActionPerformed
        // TODO add your handling code here:
        sjmpPrev();
    }//GEN-LAST:event_menuPrevActionPerformed

    private void menuNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNextActionPerformed
        // TODO add your handling code here:
        sjmpNext();
    }//GEN-LAST:event_menuNextActionPerformed

    private void btnVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolumeActionPerformed
        // TODO add your handling code here:
        if (btnVolume.isSelected()) {
            action.player.getGainControl().setMute(true);
            btnVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mute.png")));
        }
        else {
            action.player.getGainControl().setMute(false);
            btnVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unmute.png")));
        }

    }//GEN-LAST:event_btnVolumeActionPerformed

    private void saveListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveListActionPerformed
        // TODO add your handling code here:
        action.saveAsPlaylist(this);
    }//GEN-LAST:event_saveListActionPerformed

    private void openListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openListActionPerformed
        // TODO add your handling code here:
        action.openPls(this);
        updateList();
    }//GEN-LAST:event_openListActionPerformed

    private void listSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSongMouseClicked
        // TODO add your handling code here:
        int mc1 = 1;
        int mc2 = 2;
        int btn = 1;
        if(mc2 == evt.getClickCount() && btn == evt.getButton()) {
			if (action.statusPlay == 2) {
			sjmpStop();
            play(listSong.getSelectedIndex());
			}
			else {
			play(listSong.getSelectedIndex());
			}
        }
        else if(mc1 == evt.getClickCount() && btn == evt.getButton()) {
            showInfo();
        }
    }//GEN-LAST:event_listSongMouseClicked

    private void listSongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSongMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger()){
                JPopupMenu Pmenu;
                Pmenu = new JPopupMenu();
                JMenuItem popupPlay = new JMenuItem("Play");
				JMenuItem popupResume = new JMenuItem("Resume");
                JMenuItem popupPause = new JMenuItem("Pause");
                JMenuItem popupStop = new JMenuItem("Stop");
                JMenuItem popupId3 = new JMenuItem("Edit Info");
                JMenuItem popupRemove = new JMenuItem("Remove");
                JMenuItem popupUP = new JMenuItem("Move Up");
                JMenuItem popupDOWN = new JMenuItem("Move Down");
                Pmenu.add(popupPlay);
                if (action.statusPlay == 1) {
                    popupPause.setEnabled(true);
                    Pmenu.add(popupPause);
                    popupStop.setEnabled(true);
                    Pmenu.add(popupStop);
                }
				else if (action.statusPlay == 2) {
					popupResume.setEnabled(true);
					Pmenu.add(popupResume);
                }
                Pmenu.add(popupId3);
                Pmenu.add(popupRemove);
                Pmenu.add(popupUP);
                Pmenu.add(popupDOWN);
                Pmenu.show(evt.getComponent(), evt.getX(), evt.getY());
                popupPlay.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupPlayActionPerformed(evt);
                    }

                    private void popupPlayActionPerformed(ActionEvent evt) {
                        if (action.statusPlay == 2) {
                            sjmpStop();
                            sjmpPlay();
                        }
                        else {
                        sjmpPlay();
                        }
                }
                });
				
				popupResume.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupResumeActionPerformed(evt);
                    }

                    private void popupResumeActionPerformed(ActionEvent evt) {
						sjmpPlay();
                }
                });

                popupPause.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupPauseActionPerformed(evt);
                    }
                    private void popupPauseActionPerformed(ActionEvent evt) {
                        sjmpPause();
                        }
                    });
                
                popupStop.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupStopActionPerformed(evt);
                    }
                    private void popupStopActionPerformed(ActionEvent evt) {
                        sjmpStop();
                        }
                    });

                popupId3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupId3ActionPerformed(evt);
                    }
                    private void popupId3ActionPerformed(ActionEvent evt) {
                        showId3Form();
                        }
                    });
                    
                popupRemove.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupRemoveActionPerformed(evt);
                    }

                    private void popupRemoveActionPerformed(ActionEvent evt) {
                        sjmpRemove();
                }
                });

                popupUP.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupUPActionPerformed(evt);
                    }

                    private void popupUPActionPerformed(ActionEvent evt) {
                        sjmpMoveUp();
                }
                });

                popupDOWN.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                    popupDOWNActionPerformed(evt);
                    }

                    private void popupDOWNActionPerformed(ActionEvent evt) {
                        sjmpMoveDown();
                }
                });
                
        }
    }//GEN-LAST:event_listSongMouseReleased

    private void AboutBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutBoxActionPerformed
        // TODO add your handling code here:
        About ab = new About(this, rootPaneCheckingEnabled);
        ab.setLocationRelativeTo(this);
        ab.setVisible(true);
    }//GEN-LAST:event_AboutBoxActionPerformed

    private void ChangeLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeLogActionPerformed
        // TODO add your handling code here:
        Changelog cl = new Changelog(this, rootPaneCheckingEnabled);
        cl.setLocationRelativeTo(this);
        cl.setVisible(true);
    }//GEN-LAST:event_ChangeLogActionPerformed

    private void vlmSlideMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vlmSlideMouseDragged
        // TODO add your handling code here:
        int slideValue = vlmSlide.getValue();
        String volValue = String.valueOf(slideValue);
        Float volumeVal = Float.parseFloat(volValue) / 100f;
        action.player.getGainControl().setLevel(volumeVal);
        lblVolume.setText("" + slideValue);
    }//GEN-LAST:event_vlmSlideMouseDragged

    private void menuMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMoveDownActionPerformed
        // TODO add your handling code here:
        sjmpMoveDown();
    }//GEN-LAST:event_menuMoveDownActionPerformed

    private void menuMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMoveUpActionPerformed
        // TODO add your handling code here:
        sjmpMoveUp();
    }//GEN-LAST:event_menuMoveUpActionPerformed

    private void vlmSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vlmSlideMouseClicked
        // TODO add your handling code here:
        int btn = 1;
        int mc = 1;
        if (evt.getButton() == btn && evt.getClickCount() == mc) {
            int slideValue = vlmSlide.getValue();
            String volValue = String.valueOf(slideValue);
            Float volumeVal = Float.parseFloat(volValue) / 100f;
            action.player.getGainControl().setLevel(volumeVal);
            lblVolume.setText("" + slideValue);
        }
    }//GEN-LAST:event_vlmSlideMouseClicked

    private void seekBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seekBarMouseDragged
        // TODO add your handling code here:
        int slideValue = seekBar.getValue();
        Double val = (double) slideValue;
        action.player.setMediaTime(new Time(val));
        timespend = (int) Math.floor(val);
        time = action.getPlayerDuration() - timespend;
    }//GEN-LAST:event_seekBarMouseDragged

    private void seekBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seekBarMouseClicked
        // TODO add your handling code here:
        int btn = 1;
        int mc = 1;
        if (evt.getButton() == btn && evt.getClickCount() == mc) {
            int slideValue = seekBar.getValue();
            Double val = (double) slideValue;
            action.player.setMediaTime(new Time(val));
            timespend = (int) Math.floor(val);
            time = action.getPlayerDuration() - timespend;
        }
    }//GEN-LAST:event_seekBarMouseClicked

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        // TODO add your handling code here:
        sjmpPlay();
        tray.displayMessage("Play", "Now Playing : " + action.getTitle(), TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_PlayActionPerformed

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        // TODO add your handling code here:
        sjmpPause();
        tray.displayMessage("Pause", "Paused : " + action.getTitle(), TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_PauseActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        // TODO add your handling code here:
        sjmpStop();
    }//GEN-LAST:event_StopActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        sjmpNext();
        tray.displayMessage("Play", "Now Playing : " + action.getTitle(), TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_NextActionPerformed

    private void PrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevActionPerformed
        // TODO add your handling code here:
        sjmpPrev();
        tray.displayMessage("Play", "Now Playing : " + action.getTitle(), TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_PrevActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        // TODO add your handling code here:
        this.show();
       // tray.getPopupMenu().disable();
       // systray.remove(tray);
    }//GEN-LAST:event_ShowActionPerformed

    private void menuAdddirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdddirActionPerformed
        // TODO add your handling code here:
        action.addFolder(this);
        updateList();
    }//GEN-LAST:event_menuAdddirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        song = listSong.getLeadSelectionIndex();
        showId3Form();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuJumpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJumpActionPerformed
        // TODO add your handling code here:
        showJumpForm();
    }//GEN-LAST:event_menuJumpActionPerformed

    private void listSongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listSongKeyPressed
        // TODO add your handling code here:
        int idx = listSong.getSelectedIndex();
        if (evt.getKeyCode() == 10) {
            //System.out.println(evt.getKeyCode())
            play(idx);
        }
    }//GEN-LAST:event_listSongKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Player().setVisible(true);
            }
        });
    }

    public void clearList() {
        listSong.removeAll();
    }

    public void updateList() {
        arl = action.getListSong();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < arl.size(); i++) {
            int j = i + 1;
            model.add(i, j + " | " + ((File) arl.get(i)).getName());
        }
        listSong.setModel(model);
        action.saveList();
    }

    /** Play Selected Song
     *  Convert selected index in Jlist (listSong)
     *  to Arraylist index (listSong in class action)
     * @param idx
     */

    public void play(int idx) {
        if (action.statusPlay == 1) {
            action.stopMusic();
            timer.cancel();
            timespend = 0;
        }
        index = idx;
        arl = getList();
        int lastIndex = arl.size();
        if (index > lastIndex){
            index = 0;
        }
        else if (index < 0) {
            index = lastIndex;
        }
        timer.cancel();
        listSong.setSelectedIndex(index);
        action.playMusic(index);
        btnVolume.setEnabled(true);
        vlmSlide.setEnabled(true);
		seekBar.setEnabled(true);
        lblSong.setText("Now Playing :  " + action.getTitle());
        second = 1;
        startCount();
     }

    /** Using timer to delay JMF realizing/buffering the Player
     *  When Timer reach 0 then really start playing mp3
     *  also set progress bar maximum value to mp3 length/total time
     */
    public void startCount() {  
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                if (second > 0) {
                    second--;
                }
                else {
                    timer.cancel();
                    time = action.getPlayerDuration() - timespend;
                    seekBar.setMinimum(0);
                    seekBar.setMaximum(action.getPlayerDuration());
                    countDuration();
                }
            }
        }, delay, period);
    }
    /** Using timer to countdown playing mp3
     *  when timer reach 0 (mp3 totaltime/length)
     *  then start playing next mp3 in playlist
     *  this method also displaying elapsed time and total mp3 time to progress bar
     */
    public void countDuration() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
         public void run(){
             if (time > 0) {
                 time--;
                 timespend++; // elapsed time (integer)
                 String sec = Integer.toString(timespend % 60); //convert elapsed time (seconds)
                 if (Integer.parseInt(sec) < 10) {
                     sec = "0" + sec;       //condition adding 0 when elapsed time < 10
                 }
                 else {
                     sec = "" + sec;
                 }
                 String min = Integer.toString((timespend % 3600) / 60); // convert elapsed time (minutes)
                 totalTime = action.getPlayerDuration(); //
                 minute = totalTime / 60;                // convert mp3 length to Time Format
                 mp3Minutes = String.valueOf(minute);    //
                 seconds = totalTime - (minute * 60);
                 if (seconds < 10) {
                     mp3Second = "0" + seconds;
                 }
                 else {
                     mp3Second = "" + seconds;
                 }
                 seekBar.setValue(timespend);
                 lblTime.setText(min + " : " + sec + " / " + mp3Minutes + " : " + mp3Second);
                 lblInfo.setText(action.getID3());
             }
             else {
                 timer.cancel();
                 timespend = 0;
                 play(index + 1); //autoplay next mp3 in playlist
             }
         }
        },delay, period);

    }
    
    private void sjmpOpen() {
       action.deletePlaylist();
       action.openFile(this);
       updateList();
       index = 0;
       play(index);
       menuClose.setEnabled(true);
    }

    private void sjmpAdd() {
       action.addFile(this);
       updateList();
       listSong.setSelectedIndex(0);
       menuClose.setEnabled(true);
    }

    private void sjmpRemove() {
        action.deleteFile(listSong.getSelectedIndex());
        updateList();
        listSong.setSelectedIndex(listSong.getLeadSelectionIndex());
    }

    private void sjmpPrev() {
        timespend = 0;
        play(index - 1);
    }

    public void sjmpStop() {
        action.stopMusic();
        timer.cancel();
        timespend = 0;
        seekBar.setValue(0);
        seekBar.setEnabled(false);
        vlmSlide.setEnabled(false);
        lblSong.setText("");
        lblInfo.setText("");
        lblTime.setText("");
    }

    private void sjmpPlay() {
        play(listSong.getSelectedIndex());
        menuClose.setEnabled(true);
    }

    private void sjmpPause() {
        action.pauseMusic();
        timer.cancel(); // pause elapsed time and progress bar
        lblSong.setText("Paused");
    }

    private void sjmpNext() {
        timespend = 0; // reset elapsed time
        play(index+1);
    }

    private void sjmpMoveUp() {
        Collections.swap(action.listSong, listSong.getSelectedIndex(), (listSong.getSelectedIndex() - 1));
        updateList();
        listSong.setSelectedIndex(listSong.getLeadSelectionIndex() - 1);
    }

    private void sjmpMoveDown() {
        Collections.swap(action.listSong, listSong.getSelectedIndex(), (listSong.getSelectedIndex() + 1));
        updateList();
        listSong.setSelectedIndex(listSong.getLeadSelectionIndex() + 1);
    }

    private void sjmpRemAll() {
        action.deletePlaylist();
        clearList();
        updateList();
    }

    

    private void sendtoTray() {
        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/systray.png"));
        Image img = icon.getImage();
        tray = new TrayIcon(img, times, trayPopup);
        tray.setImageAutoSize(true);
        systray = SystemTray.getSystemTray();
        try {
            systray.add(tray);
        } catch (Exception e) {
        }

    }

    private void showId3Form() {
        Id3Form id3f = new Id3Form();
        Component add = id3f.addComponentListener(listSong);
        id3f.setLocationRelativeTo(this);
        id3f.setVisible(true);
    }

    private void showJumpForm() {
        JumpForm jmpmenu = new JumpForm(this);
        jmpmenu.setLocationRelativeTo(this);
        jmpmenu.setVisible(true);
    }

    public int getSong() {
        return song;
    }

    public ArrayList getList() {
        return arl;
    }

    public void goTime(Double jumptime) {
        try {
        Double total = (double) action.getPlayerDuration();
        if (jumptime > total) {
            return;
        }
        else {
        action.player.setMediaTime(new Time(jumptime));
        timespend = (int) Math.floor(jumptime);
        time = action.getPlayerDuration() - timespend;
        }
        }
        catch (Exception e) {
            
        }
    }

     public void goTrack(int idx) {
        try {
        if (action.statusPlay == 2) {
            sjmpStop();
            play(idx);
        }
        else {
            play(idx);
            }
        }
        catch (Exception e) {
            
        }
    }

    private void showInfo() {
        //lblInfo.addComponentListener((ComponentListener) listSong);
        song = listSong.getSelectedIndex();
        action.readID3(song);
        lblInfo.setText(action.getID3());
    }

    Action action = new Action();
    Float volume;
    int song, second, time, timespend, index, totalTime, minute, seconds, x, y;
    int delay = 0;
    int period = 1000;
    String mp3Minutes, mp3Second, times;
    Timer timer = new Timer();
    ArrayList arl = new ArrayList();
    SystemTray systray;
    TrayIcon tray;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutBox;
    private javax.swing.JMenuItem ChangeLog;
    private java.awt.MenuItem Next;
    private java.awt.MenuItem Pause;
    private java.awt.MenuItem Play;
    private java.awt.MenuItem Prev;
    private java.awt.MenuItem Quit;
    private java.awt.MenuItem Show;
    private java.awt.MenuItem Stop;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnStop;
    private javax.swing.JToggleButton btnVolume;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblPls;
    private javax.swing.JLabel lblSong;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblVolume;
    public javax.swing.JList listSong;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenuItem menuAdd;
    private javax.swing.JMenuItem menuAdddir;
    private javax.swing.JMenuItem menuClose;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuJump;
    private javax.swing.JMenuItem menuMoveDown;
    private javax.swing.JMenuItem menuMoveUp;
    private javax.swing.JMenu menuNav;
    private javax.swing.JMenuItem menuNext;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuPause;
    private javax.swing.JMenuItem menuPlay;
    private javax.swing.JMenu menuPls;
    private javax.swing.JMenuItem menuPrev;
    private javax.swing.JMenuItem menuRemAll;
    private javax.swing.JMenuItem menuRemove;
    private javax.swing.JPopupMenu.Separator menuSeparator;
    private javax.swing.JMenuItem menuStop;
    private javax.swing.JMenuItem openList;
    private javax.swing.JMenuItem saveList;
    private javax.swing.JSlider seekBar;
    private javax.swing.JMenuBar sjmpMenu;
    private java.awt.PopupMenu trayPopup;
    private javax.swing.JSlider vlmSlide;
    // End of variables declaration//GEN-END:variables

}