//Battleship
//Chloe, Emily, Jayna
//v1


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class model implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
    /**
    *
    *  @author Chloe, Emily, Jayna
    *  @version 1.0.0
    */
    //Properties

    // Timers for help screen and game panel
    /**
    * The 'theTimer' property of type Timer.
    */
    Timer theTimer = new Timer(1000/60, this);
    /**
    * The 'helpTimer' property of type Timer.
    */
    Timer helpTimer = new Timer(1000/60, this);

    //Font
    /**
    * The 'text' property of type Font.
    */
    Font text = null;

    //Frame and Panels
    /**
    * The 'theframe' property of type JFrame.
    */
    JFrame theframe = new JFrame("Battleship");
    /**
    * The 'mainpanel' property of type JPanel.
    */
    JPanel mainpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,0));
    /**
    * The 'gamepanel' property of type apanel.
    */
    apanel gamepanel = new apanel();
    /**
    * The 'homepanel' property of type JPanel.
    */
    JPanel homepanel = new JPanel();
    /**
    * The 'joinpanel' property of type JPanel.
    */
    JPanel joinpanel = new JPanel();
    /**
    * The 'waitingpanel' property of type JPanel.
    */
    JPanel waitingpanel = new JPanel();
    /**
    * The 'gameoverpanel' property of type JPanel.
    */
    JPanel gameoverpanel = new JPanel();
    /**
    * The 'themepanel' property of type thepanel.
    */
    thepanel themepanel = new thepanel();
    /**
    * The 'chatpanel' property of type JPanel.
    */
    JPanel chatpanel = new JPanel();

    //Help Screen Panels
    /**
    * The 'helppanel1' property of type hpanel.
    */
    hpanel helppanel1 = new hpanel();
    /**
    * The 'helppanel2' property of type hpanel.
    */
    hpanel helppanel2 = new hpanel();
    /**
    * The 'helppanel3' property of type hpanel.
    */
    hpanel helppanel3 = new hpanel();

    //Chat Area
    /**
    * The 'textarea' property of type JTextArea.
    */
    JTextArea textarea = new JTextArea();
    /**
    * The 'thescroll' property of type JScrollPane.
    */
    JScrollPane thescroll = new JScrollPane(textarea);
    /**
    * The 'sendfield' property of type JTextField.
    */
    JTextField sendfield = new JTextField();

    //Row dropdown, Col dropdown and Fire
    /**
    * The 'strRow' property of type String[].
    */
    String[] strRow = {"1","2","3","4","5","6","7","8","9","10"};
    /**
    * The 'strCol' property of type String[].
    */
    String[] strCol = {"A","B","C","D","E","F","G","H","I","J"};
    /**
    * The 'rowlist' property of type JComboBox.
    */
    JComboBox rowlist = new JComboBox(strRow);
    /**
    * The 'collist' property of type JComboBox.
    */
    JComboBox collist = new JComboBox(strCol);
    /**
    * The 'startbutton' property of type JButton.
    */
    JButton startbutton = new JButton("START");
    /**
    * The 'firebutton' property of type JButton.
    */
    JButton firebutton = new JButton("FIRE");

    //Home screen
    /**
    * The 'playbutton' property of type JButton.
    */
    JButton playbutton = new JButton("Play");
    /**
    * The 'helpbutton' property of type JButton.
    */
    JButton helpbutton = new JButton("Help");
    /**
    * The 'quitbutton' property of type JButton.
    */
    JButton quitbutton = new JButton("Quit");
    /**
    * The 'battleship' property of type JLabel.
    */
    JLabel battleship = new JLabel("BATTLESHIP");

    //Join screen
    /**
    * The 'username' property of type JTextField.
    */
    JTextField username = new JTextField();
    /**
    * The 'ip' property of type JTextField.
    */
    JTextField ip = new JTextField();
    /**
    * The 'port' property of type JTextField.
    */
    JTextField port = new JTextField("8080");
    /**
    * The 'host' property of type JButton.
    */
    JButton host = new JButton("Host");
    /**
    * The 'join' property of type JButton.
    */
    JButton join = new JButton("Join");
    /**
    * The 'userlabel' property of type JLabel.
    */
    JLabel userlabel = new JLabel("Username");
    /**
    * The 'iplabel' property of type JLabel.
    */
    JLabel iplabel = new JLabel("IP");
    /**
    * The 'portlabel' property of type JLabel.
    */
    JLabel portlabel = new JLabel("Port");
    /**
    * The 'title' property of type JLabel.
    */
    JLabel title = new JLabel("BATTLESHIP");
    /**
    * The 'ssm' property of type SuperSocketMaster.
    */
    SuperSocketMaster ssm = null;

    //Themes
    /**
    * The 'standardbutton' property of type JButton.
    */
    JButton standardbutton = new JButton("Standard");
    /**
    * The 'carsbutton' property of type JButton.
    */
    JButton carsbutton = new JButton("Cars");
    /**
    * The 'spacebutton' property of type JButton.
    */
    JButton spacebutton = new JButton("Space");

    //Help Screen
    /**
    * The 'nextbutton1' property of type JButton.
    */
    JButton nextbutton1 = new JButton("Next");
    /**
    * The 'nextbutton2' property of type JButton.
    */
    JButton nextbutton2 = new JButton("Next");
    /**
    * The 'backbutton1' property of type JButton.
    */
    JButton backbutton1 = new JButton("Back");
    /**
    * The 'backbutton2' property of type JButton.
    */
    JButton backbutton2 = new JButton("Back");
    /**
    * The 'backbutton' property of type JButton.
    */
    JButton backbutton = new JButton("Go Back to Home Screen");


    /**
    * The 'startbuttonh' property of type JButton.
    */
    JButton startbuttonh = new JButton("START");

    /**
    * The 'user1labelh' property of type JLabel.
    */
    
    JLabel user1labelh = new JLabel("Player1", SwingConstants.CENTER);
    /**
    * The 'user2labelh' property of type JLabel.
    */
    
    JLabel user2labelh = new JLabel("Player1", SwingConstants.CENTER);
    /**
    * The 'user3labelh' property of type JLabel.
    */
    JLabel user3labelh = new JLabel("Player1", SwingConstants.CENTER);

    
    /**
    * The 'strRowh' property of type String[].
    */
    String[] strRowh = {"1","2","3","4","5","6","7","8","9","10"};
   
    /**
    * The 'strColh' property of type String[].
    */
    String[] strColh = {"A","B","C","D","E","F","G","H","I","J"};
   
    /**
    * The 'rowlisth' property of type JComboBox.
    */
    JComboBox rowlisth = new JComboBox(strRowh);
    /**
    * The 'collist' property of type JComboBox.
    */
    /**
    * The 'collisth' property of type JComboBox.
    */
    JComboBox collisth = new JComboBox(strColh);
    /**
    * The 'firebutton' property of type JButton.
    */
    /**
    * The 'firebuttonh' property of type JButton.
    */
    JButton firebuttonh = new JButton("FIRE");

    /**
    * The 'textarea' property of type JTextArea.
    */
    /**
    * The 'textareah' property of type JTextArea.
    */
    JTextArea textareah = new JTextArea();
    /**
    * The 'thescroll' property of type JScrollPane.
    */
    /**
    * The 'thescrollh' property of type JScrollPane.
    */
    JScrollPane thescrollh = new JScrollPane(textareah);
    /**
    * The 'sendfield' property of type JTextField.
    */
    /**
    * The 'sendfieldh' property of type JTextField.
    */
    JTextField sendfieldh = new JTextField();

    //Waiting
    /**
    * The 'waitinglabel' property of type JLabel.
    */
    JLabel waitinglabel = new JLabel("Waiting for Host...");

    //Username
    /**
    * The 'strUsername' property of type String.
    */
    String strUsername = "";
    /**
    * The 'user1label' property of type JLabel.
    */
    JLabel user1label = new JLabel("", SwingConstants.CENTER);
    /**
    * The 'user2label' property of type JLabel.
    */
    JLabel user2label = new JLabel("", SwingConstants.CENTER);

    //Quit
    /**
    * The 'gameoverlabel' property of type JLabel.
    */
    JLabel gameoverlabel = new JLabel("Gameover");
    /**
    * The 'quitbutton' property of type JButton.
    */
    /**
    * The 'quitbutton1' property of type JButton.
    */
    JButton quitbutton1 = new JButton("QUIT");

    //Variables for overall game
    /**
    * The 'intClick' property of type int.
    */
    int intClick = 0;
    /**
    * The 'blnConfirmGuess' property of type boolean.
    */
    boolean blnConfirmGuess;
    /**
    * The 'blnWinCheck' property of type boolean.
    */
    boolean blnWinCheck = false;

    public void actionPerformed(ActionEvent evt){
        //clicking play button on home screen
        if(evt.getSource() == playbutton){
            theframe.setContentPane(joinpanel);
            theframe.pack();
            theframe.repaint();
        }
        //clicking help button on home screen
        if(evt.getSource() == helpbutton){
            theframe.setContentPane(helppanel1);
            theframe.pack();
            theframe.repaint();
            helppanel1.intPanel = 1;
        }
        //clicking quit button on home screen
        if(evt.getSource() == quitbutton){
            System.exit(0);
        }
        //clicking back button on first help screen
        if(evt.getSource() == backbutton){
            theframe.setContentPane(homepanel);
            theframe.pack();
            theframe.repaint();
            gamepanel.strMap = controller.reloadMap(gamepanel.strMap);

        }
        //clicking back button on second help screen
        if(evt.getSource() == backbutton1){
            theframe.setContentPane(helppanel1);
            theframe.pack();
            theframe.repaint();
            helppanel1.intPanel = 1;
        }
        //clicking back button on final help screen
        if(evt.getSource() == backbutton2){
            theframe.setContentPane(helppanel2);
            theframe.pack();
            theframe.repaint();
            helppanel2.intPanel = 2;
        }
        //clicking next button on first help screen
        if(evt.getSource() == nextbutton1){
            theframe.setContentPane(helppanel2);
            theframe.pack();
            theframe.repaint();
            helppanel2.intPanel = 2;
        }
        //clicking next button on second help screen
        if(evt.getSource() == nextbutton2){
            theframe.setContentPane(helppanel3);
            theframe.pack();
            theframe.repaint();
            helppanel3.intPanel = 3;
        }
        //chat on help screen
        if(evt.getSource() == sendfieldh){
            textareah.append("Player1: " + sendfieldh.getText() + "\n");
            sendfieldh.setText("");
        }
        //clicking start button on gameplay screen
        if(evt.getSource() == startbutton){
            intClick++;

            //Takes off start button and enables drowndowns and fire button
            gamepanel.removeMouseListener(this);
            gamepanel.removeMouseMotionListener(this);
            collist.setEnabled(true);
            rowlist.setEnabled(true);
            firebutton.setVisible(true);
            firebutton.setEnabled(true);
            startbutton.setVisible(false);

            // Enables fire button for host. (allows host to go first)
            if(gamepanel.intPlayer == (intClick % 2)){
                firebutton.setEnabled(false);
            }

            //Starts the dot/hit/miss maps
            gamepanel.strDotMap1 = controller.startDotMaps(gamepanel.strDotMap1);
            gamepanel.strDotMap2 = controller.startDotMaps(gamepanel.strDotMap2);
            gamepanel.gameStarted = true;
        }
        //clicking the fire button on gameplay screen
        if(evt.getSource() == firebutton){
            intClick++;
            /**
            * The 'strRow' property of type String.
            */
            String strRow = (String)rowlist.getSelectedItem();
            String strCol = (String)collist.getSelectedItem();
            System.out.println(strRow+strCol);

            //Tells the other player that they are attacking them at a certain row and column
            ssm.sendText("OppAttack‰"+strRow+"‰"+strCol);
            if(gamepanel.intPlayer == (intClick % 2)){
                firebutton.setEnabled(false);
            }

        }
        //clicking the host button on join screen
        if(evt.getSource() == host){
            strUsername = username.getText();

            // Prevents players from entering certain usernames
            if(strUsername.equals("joined") || strUsername.equals("play") || strUsername.equals("OppAttack") || strUsername.equals("label")){
                userlabel.setText("Change name");
                username.setText("");
            }else{
                gamepanel.intPlayer = 0;
                ssm = new SuperSocketMaster(Integer.parseInt(port.getText()), this);
                ssm.connect();
                System.out.println(ssm.getMyAddress());
                theframe.setTitle(ssm.getMyAddress());
                theframe.setContentPane(themepanel);
                theframe.pack();
                theframe.repaint();
            }
        }
        //clicking the join button on the join screen
        if(evt.getSource() == join){
            strUsername = username.getText();

            // Prevents players from entering certain usernames
            if(strUsername.equals("joined") || strUsername.equals("play") || strUsername.equals("OppAttack") || strUsername.equals("label")){
                userlabel.setText("Change Name");
                username.setText("");
            }else{
                gamepanel.intPlayer = 1;
                user1label.setText(strUsername);
                ssm = new SuperSocketMaster(ip.getText(), Integer.parseInt(port.getText()), this);
                ssm.connect();
                theframe.setContentPane(waitingpanel);
                theframe.pack();
                theframe.repaint();
                ssm.sendText("joined‰client");
                ssm.sendText("label‰"+strUsername);
            }
        }

        //clicking the standard theme button
        if(evt.getSource() == standardbutton){
            gamepanel.intMapChoice = 1;
            theframe.setContentPane(mainpanel);
            theframe.pack();
            theframe.repaint();
            theframe.requestFocus();
            user1label.setText(strUsername);
            ssm.sendText("play‰standard");
            ssm.sendText("label‰"+strUsername);
        }

        //clicking the cars theme button
        if(evt.getSource() == carsbutton){
            gamepanel.intMapChoice = 2;
            theframe.setContentPane(mainpanel);
            theframe.pack();
            theframe.repaint();
            theframe.requestFocus();
            user1label.setText(strUsername);
            ssm.sendText("play‰cars");
            ssm.sendText("label‰"+strUsername);
        }

        //clicking the space theme button
        if(evt.getSource() == spacebutton){
            gamepanel.intMapChoice = 3;
            theframe.setContentPane(mainpanel);
            theframe.pack();
            theframe.repaint();
            theframe.requestFocus();
            user1label.setText(strUsername);
            ssm.sendText("play‰space");
            ssm.sendText("label‰"+strUsername);
        }

        //Writes messages to the chat area
        if(evt.getSource() == sendfield){
            ssm.sendText(strUsername + "‰" + sendfield.getText());
            textarea.append(strUsername + ": " + sendfield.getText() + "\n");
            sendfield.setText("");
        }

        //clicking on the quit button while in game
        if(evt.getSource() == quitbutton1){
            gamepanel.strMap = controller.reloadMap(gamepanel.strMap);
            System.out.println("quit");
            System.exit(0);
        }

        /** detects for messages from ssm
        **/
        if(evt.getSource() == ssm){
            //ssm message for client to switch to gameplay screen
            /**
            * The 'strChat' property of type String[].
            */
            String[] strChat = ssm.readText().split("‰");

            //communicates the map choice that the host picked to the client
            if(strChat[0].equals("play")){
                if(strChat[1].equals("standard")){
                    gamepanel.intMapChoice = 1;
                }else if(strChat[1].equals("cars")){
                    gamepanel.intMapChoice = 2;
                }else if(strChat[1].equals("space")){
                    gamepanel.intMapChoice = 3;
                }
                theframe.setContentPane(mainpanel);
                theframe.pack();
                theframe.repaint();

                //only lets the host pick a theme after the client has joined
            }else if(strChat[0].equals("joined")){
                if(strChat[1].equals("client")){
                    standardbutton.setEnabled(true);
                    carsbutton.setEnabled(true);
                    spacebutton.setEnabled(true);
                }

                //username of the other player
            }else if(strChat[0].equals("label")){
                user2label.setText(strChat[1]);

                //if the first part of the ssm is "OppAttack". Opponent is sending the player where they guessed/attacked
            }else if(strChat[0].equals("OppAttack")){
                firebutton.setEnabled(true);
                intClick++;

                //Converts the data sent through the ssm to array row/column
                if(strChat[1].equals("1")){
                    gamepanel.intRow = 0;
                }else if(strChat[1].equals("2")){
                    gamepanel.intRow = 1;
                }else if(strChat[1].equals("3")){
                    gamepanel.intRow = 2;
                }else if(strChat[1].equals("4")){
                    gamepanel.intRow = 3;
                }else if(strChat[1].equals("5")){
                    gamepanel.intRow = 4;
                }else if(strChat[1].equals("6")){
                    gamepanel.intRow = 5;
                }else if(strChat[1].equals("7")){
                    gamepanel.intRow = 6;
                }else if(strChat[1].equals("8")){
                    gamepanel.intRow = 7;
                }else if(strChat[1].equals("9")){
                    gamepanel.intRow = 8;
                }else if(strChat[1].equals("10")){
                    gamepanel.intRow = 9;
                }
                if(strChat[2].equals("A")){
                    gamepanel.intCol = 0;
                }else if(strChat[2].equals("B")){
                    gamepanel.intCol = 1;
                }else if(strChat[2].equals("C")){
                    gamepanel.intCol = 2;
                }else if(strChat[2].equals("D")){
                    gamepanel.intCol = 3;
                }else if(strChat[2].equals("E")){
                    gamepanel.intCol = 4;
                }else if(strChat[2].equals("F")){
                    gamepanel.intCol = 5;
                }else if(strChat[2].equals("G")){
                    gamepanel.intCol = 6;
                }else if(strChat[2].equals("H")){
                    gamepanel.intCol = 7;
                }else if(strChat[2].equals("I")){
                    gamepanel.intCol = 8;
                }else if(strChat[2].equals("J")){
                    gamepanel.intCol = 9;
                }
                System.out.println("attacked introw:" + gamepanel.intRow);
                System.out.println("attacked intcol:" + gamepanel.intCol);
                gamepanel.intHit = controller.hitmiss(gamepanel.strMap, gamepanel.intCol, gamepanel.intRow);

                if(gamepanel.intHit == 1){
                    //opponent hit a player boat
                    /**
                    * The 'blnConfirmGuess' property of type boat.
                    */
                    blnConfirmGuess = true;
                    gamepanel.strDotMap1 = controller.updateDotMaps(gamepanel.strDotMap1, blnConfirmGuess, gamepanel.intCol, gamepanel.intRow);

                    //sends a message back to opponent to tell them their guess hit one of the player's boats
                    ssm.sendText("attackResult‰1‰"+gamepanel.intCol+"‰"+gamepanel.intRow);
                }
                if(gamepanel.intHit == 2){
                    // opponent did not hit a player boat
                    /**
                    * The 'blnConfirmGuess' property of type boat.
                    */
                    blnConfirmGuess = false;
                    gamepanel.strDotMap1 = controller.updateDotMaps(gamepanel.strDotMap1, blnConfirmGuess, gamepanel.intCol, gamepanel.intRow);
                    //sends a message back to opponent to tell them their guess did not hit one of the player's boats
                    ssm.sendText("attackResult‰0‰"+gamepanel.intCol+"‰"+gamepanel.intRow);
                }

            }else if(strChat[0].equals("attackResult")&& strChat[1].equals("1")){
                //opponent tells player where the player attacked and that the player has hit a boat
                gamepanel.strDotMap2 = controller.updateDotMaps(gamepanel.strDotMap2, true, Integer.parseInt(strChat[2]), Integer.parseInt(strChat[3]));
                blnWinCheck = controller.checkGameOver(gamepanel.strDotMap2);
                if(blnWinCheck == true){
                    //game is over
                    System.out.println("GAME OVER");

                    //tells the opponent the game is over
                    ssm.sendText("gameover");
                    theframe.setContentPane(gameoverpanel);
                    theframe.pack();
                    theframe.repaint();
                }
                System.out.println("hit");

            }else if(strChat[0].equals("attackResult") && strChat[1].equals("0")){
                //opponent tells player where the player attacked and that the player missed
                gamepanel.strDotMap2 = controller.updateDotMaps(gamepanel.strDotMap2, false, Integer.parseInt(strChat[2]), Integer.parseInt(strChat[3]));

            }else if(strChat[0].equals("gameover")){
                //opponent says game is over
                System.out.println("GAME OVER");
                theframe.setContentPane(gameoverpanel);
                theframe.pack();
                theframe.repaint();

                //chat messages
            }else{
                try{
                    textarea.append(strChat[0] + ": " + strChat[1] + "\n");
                }catch(IndexOutOfBoundsException e){
                    System.out.println("Badly formatted message");
                }

            }

        }
        if(evt.getSource() == theTimer){
            gamepanel.repaint();

        }
        if(evt.getSource() == helpTimer){
            helppanel1.repaint();

        }
    }


    public void keyPressed(KeyEvent evt){
        if(gamepanel.int2px1 < 437 && gamepanel.int2py1 < 540){
            //boat 2 is pressed
            if(gamepanel.blnMove2 == true && evt.getKeyChar() == KeyEvent.VK_R){
                //R was pressed
                //Rotates the 2 boat
                if(gamepanel.blnRot2 == false){
                    gamepanel.blnRot2 = true;
                }else{
                    gamepanel.blnRot2 = false;
                }
            }
        }
        if(gamepanel.int3apx1 < 392 && gamepanel.int3apy1 < 495){
            //the first 3 boat is pressed
            if(gamepanel.blnMove3a == true && evt.getKeyChar() == KeyEvent.VK_R){
                //R was pressed
                //Rotates one of the first 3 boat
                if(gamepanel.blnRot3a == false){
                    gamepanel.blnRot3a = true;
                }else{
                    gamepanel.blnRot3a = false;
                }
            }
        }
        if(gamepanel.int3bpx1 < 392 && gamepanel.int3bpy1 < 495){
            //the second 3 boat is pressed
            if(gamepanel.blnMove3b == true && evt.getKeyChar() == KeyEvent.VK_R){
                //R was pressed
                //Rotates one of the second 3 boat
                if(gamepanel.blnRot3b == false){
                    gamepanel.blnRot3b = true;
                }else{
                    gamepanel.blnRot3b = false;
                }
            }
        }
        if(gamepanel.int4px1 < 392 && gamepanel.int4py1 < 450){
            //the 4 boat is pressed
            if(gamepanel.blnMove4 == true && evt.getKeyChar() == KeyEvent.VK_R){
                //R was pressed
                //Rotates one of the 4 boat
                if(gamepanel.blnRot4 == false){
                    gamepanel.blnRot4 = true;
                }else{
                    gamepanel.blnRot4 = false;
                }
            }
        }
        if(gamepanel.int5px1 < 347 && gamepanel.int5py1 < 405){
            //the 5 boat is pressed
            if(gamepanel.blnMove5 == true && evt.getKeyChar() == KeyEvent.VK_R){
                //R was pressed
                //Rotates one of the 4 boat
                if(gamepanel.blnRot5 == false){
                    gamepanel.blnRot5 = true;
                }else{
                    gamepanel.blnRot5 = false;
                }
            }
        }

        //Help Screen
        if(helppanel1.int2px1 < 437 && helppanel1.int2py1 < 540){
            if(helppanel1.blnMove2 == true && evt.getKeyChar() == KeyEvent.VK_R){

                if(helppanel1.blnRot2 == false){
                    helppanel1.blnRot2 = true;
                }else{
                    helppanel1.blnRot2 = false;
                }
            }
        }
    }

    public void keyTyped(KeyEvent evt){

        //limits the username that the player entered
        if(username.getText().length() > 10 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            /**
            * The 'strusername' property of type String.
            */
            String strusername = username.getText().substring(0, 9);
            username.setText(strusername);
            userlabel.setText("Too Long");
        }else{
            userlabel.setText("Username");
        }

        //Rotates boat 2
        if(gamepanel.int2px1 < 437 && gamepanel.int2py1 < 540){
            if(gamepanel.blnMove2 == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot2 == false){
                    gamepanel.blnRot2 = true;
                }else{
                    gamepanel.blnRot2 = false;
                }
            }
        }

        //Rotates the first 3 boat
        if(gamepanel.int3apx1 < 392 && gamepanel.int3apy1 < 495){
            if(gamepanel.blnMove3a == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot3a == false){
                    gamepanel.blnRot3a = true;
                }else{
                    gamepanel.blnRot3a = false;
                }
            }
        }

        //Rotates the second 3 boat
        if(gamepanel.int3bpx1 < 392 && gamepanel.int3bpy1 < 495){
            if(gamepanel.blnMove3b == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot3b == false){
                    gamepanel.blnRot3b = true;
                }else{
                    gamepanel.blnRot3b = false;
                }
            }
        }

        //Rotates the 4 boat
        if(gamepanel.int4px1 < 392 && gamepanel.int4py1 < 450){
            if(gamepanel.blnMove4 == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot4 == false){
                    gamepanel.blnRot4 = true;
                }else{
                    gamepanel.blnRot4 = false;
                }
            }
        }

        //Rotates the 5 boat
        if(gamepanel.int5px1 < 347 && gamepanel.int5py1 < 405){
            if(gamepanel.blnMove5 == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot5 == false){
                    gamepanel.blnRot5 = true;
                }else{
                    gamepanel.blnRot5 = false;
                }
            }
        }
        //Help Screen
        if(helppanel1.int2px1 < 437 && helppanel1.int2py1 < 540){
            if(helppanel1.blnMove2 == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(helppanel1.blnRot2 == false){
                    helppanel1.blnRot2 = true;
                }else{
                    helppanel1.blnRot2 = false;
                }
            }
        }



    }

    public void keyReleased(KeyEvent evt){
        if(username.getText().length() > 10 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            /**
            * The 'strusername' property of type String.
            */
            String strusername = username.getText().substring(0, 10);
            username.setText(strusername);
            userlabel.setText("Too Long");
        }else{
            userlabel.setText("Username");
        }

        //Rotates boat 2
        if(gamepanel.int2px1 < 437 && gamepanel.int2py1 < 540){
            if(gamepanel.blnMove2 == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot2 == false){
                    gamepanel.blnRot2 = true;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 2, gamepanel.blnRot2);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot2 = false;
                    }
                }else{
                    gamepanel.blnRot2 = false;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 2, gamepanel.blnRot2);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot2 = true;
                    }
                }
            }
        }

        //Rotates the first 3 boat
        if(gamepanel.int3apx1 < 392 && gamepanel.int3apy1 < 495){
            if(gamepanel.blnMove3a == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot3a == false){
                    gamepanel.blnRot3a = true;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 3, gamepanel.blnRot3a);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot3a = false;
                    }
                }else{
                    gamepanel.blnRot3a = false;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 3, gamepanel.blnRot3a);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot3a = true;
                    }
                }
            }
        }

        //Rotates the second 3 boat
        if(gamepanel.int3bpx1 < 392 && gamepanel.int3bpy1 < 495){
            if(gamepanel.blnMove3b == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot3b == false){
                    gamepanel.blnRot3b = true;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 3, gamepanel.blnRot3b);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot3b = false;
                    }
                }else{
                    gamepanel.blnRot3b = false;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 3, gamepanel.blnRot3b);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot3b = true;
                    }
                }
            }
        }

        //Rotates the 4 boat
        if(gamepanel.int4px1 < 347 && gamepanel.int4py1 < 450){
            if(gamepanel.blnMove4 == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot4 == false){
                    gamepanel.blnRot4 = true;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 4, gamepanel.blnRot4);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot4 = false;
                    }
                }else{
                    gamepanel.blnRot4 = false;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 4, gamepanel.blnRot4);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot4 = true;
                    }
                }
            }
        }

        //Rotates the 5 boat
        if(gamepanel.int5px1 < 302 && gamepanel.int5py1 < 405){
            if(gamepanel.blnMove5 == true && evt.getKeyChar() == KeyEvent.VK_R){
                if(gamepanel.blnRot5 == false){
                    gamepanel.blnRot5 = true;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 5, gamepanel.blnRot5);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot5 = false;
                    }
                }else{
                    gamepanel.blnRot5 = false;
                    /**
                    * The 'blnOverlap' property of type boolean.
                    */
                    boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 5, gamepanel.blnRot5);

                    //unrotates the boat because it overlaps something when rotated
                    if(blnOverlap == true){
                        gamepanel.blnRot5 = true;
                    }
                }
            }
        }
        //Help Screen
        //Rotates the help screen boat
        if(helppanel1.int2px1 < 437 && helppanel1.int2py1 < 540){
            if(helppanel1.blnMove2 == true && evt.getKeyChar() == KeyEvent.VK_R){
                //System.out.println("ya");
                if(helppanel1.blnRot2 == false){
                    helppanel1.blnRot2 = true;
                }else{
                    helppanel1.blnRot2 = false;
                }
            }
        }
    }

    public void mouseClicked(MouseEvent evt){

    }

    public void mousePressed(MouseEvent evt){
        gamepanel.intMousex = evt.getX();
        gamepanel.intMousey = evt.getY();

        if(gamepanel.intMousex > gamepanel.int2px1 && gamepanel.intMousex < gamepanel.int2px2 && gamepanel.intMousey > gamepanel.int2py1 && gamepanel.intMousey < gamepanel.int2py2){
            //2 boat was pressed
            gamepanel.blnMove2 = true;
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int2px1, gamepanel.int2py1, gamepanel.blnRot2, 2, true);
            theframe.requestFocus();
        }

        if (gamepanel.intMousex >= gamepanel.int3apx1 && gamepanel.intMousex <= gamepanel.int3apx2 && gamepanel.intMousey >= gamepanel.int3apy1 && gamepanel.intMousey <= gamepanel.int3apy2){
            //3a boat was pressed
            gamepanel.blnMove3a = true;
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int3apx1, gamepanel.int3apy1, gamepanel.blnRot3a, 3, true);
            theframe.requestFocus();
        }


        if (gamepanel.intMousex >= gamepanel.int3bpx1 && gamepanel.intMousex <= gamepanel.int3bpx2 && gamepanel.intMousey >= gamepanel.int3bpy1 && gamepanel.intMousey <= gamepanel.int3bpy2){
            //3b boat was pressed
            gamepanel.blnMove3b = true;
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int3bpx1, gamepanel.int3bpy1, gamepanel.blnRot3b, 3, true);
            theframe.requestFocus();
        }

        if (gamepanel.intMousex >= gamepanel.int4px1 && gamepanel.intMousex <= gamepanel.int4px2 && gamepanel.intMousey >= gamepanel.int4py1 && gamepanel.intMousey <= gamepanel.int4py2){
            //4 boat was pressed
            gamepanel.blnMove4 = true;
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int4px1, gamepanel.int4py1, gamepanel.blnRot4, 4, true);
            theframe.requestFocus();
        }

        if (gamepanel.intMousex >= gamepanel.int5px1 && gamepanel.intMousex <= gamepanel.int5px2 && gamepanel.intMousey >= gamepanel.int5py1 && gamepanel.intMousey <= gamepanel.int5py2){
            //5 boat was pressed
            gamepanel.blnMove5 = true;
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int5px1, gamepanel.int5py1, gamepanel.blnRot5, 5, true);
            theframe.requestFocus();
        }
        //Help Screen
        helppanel1.intMousex = evt.getX();
        helppanel1.intMousey = evt.getY();
        if(helppanel1.intMousex > helppanel1.int2px1 && helppanel1.intMousex < helppanel1.int2px2 && helppanel1.intMousey > helppanel1.int2py1 && helppanel1.intMousey < helppanel1.int2py2){
            //help screen 2 boat was pressed
            helppanel1.blnMove2 = true;
            theframe.requestFocus();
        }
    }

    public void mouseEntered(MouseEvent evt){

    }

    public void mouseExited(MouseEvent evt){

    }

    public void mouseReleased(MouseEvent evt){
        // Records the position of the boats when the mouse releases it
        if(gamepanel.blnMove2 == true){
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int2px1, gamepanel.int2py1, gamepanel.blnRot2, 2, false);
        }
        if(gamepanel.blnMove3a == true){
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int3apx1, gamepanel.int3apy1, gamepanel.blnRot3a, 3, false);
        }
        if(gamepanel.blnMove3b == true){
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int3bpx1, gamepanel.int3bpy1, gamepanel.blnRot3b, 3, false);
        }
        if(gamepanel.blnMove4 == true){
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int4px1, gamepanel.int4py1, gamepanel.blnRot4, 4, false);
        }
        if(gamepanel.blnMove5 == true){
            gamepanel.strMap = controller.updateMap(gamepanel.strMap, gamepanel.int5px1, gamepanel.int5py1, gamepanel.blnRot5, 5, false);
        }

        gamepanel.blnMove2 = false;
        gamepanel.blnMove3a = false;
        gamepanel.blnMove3b = false;
        gamepanel.blnMove4 = false;
        gamepanel.blnMove5 = false;

        //Help Screen
        helppanel1.blnMove2 = false;

    }

    public void mouseDragged(MouseEvent evt){

        gamepanel.intMousex = evt.getX();
        gamepanel.intMousey = evt.getY();
        gamepanel.intMousex = controller.snapToX(gamepanel.intMousex);
        gamepanel.intMousey = controller.snapToY(gamepanel.intMousey);
        gamepanel.intMousex = controller.boundxleft(gamepanel.intMousex);
        gamepanel.intMousey = controller.boundytop(gamepanel.intMousey);

        if(gamepanel.blnMove2 == true){
            //boat 2 is being moved
            /**
            * The 'blnOverlap' property of type boolean.
            */
            boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 2, gamepanel.blnRot2);
            if(blnOverlap == true){
                //boat will overlap something else. no redrawing
            }else{
                //boat will not overlap something else. redrawing
                if(gamepanel.blnRot2 == false){
                    //redrawing the boat horizontally
                    gamepanel.int2px1 = gamepanel.intMousex;
                    gamepanel.int2py1 = gamepanel.intMousey;
                    gamepanel.int2px2 = gamepanel.intMousex + 90;
                    gamepanel.int2py2 = gamepanel.intMousey + 45;
                    gamepanel.int2px2 = controller.boundxright(gamepanel.int2px2);
                    gamepanel.int2py2 = controller.boundybottom(gamepanel.int2py2);
                    gamepanel.int2px1 = gamepanel.int2px2 - 90;
                    gamepanel.int2py1 = gamepanel.int2py2 - 45;
                }else{
                    //redrawing the boat vertically
                    gamepanel.int2px1 = gamepanel.intMousex;
                    gamepanel.int2py1 = gamepanel.intMousey;
                    gamepanel.int2px2 = gamepanel.intMousex + 45;
                    gamepanel.int2py2 = gamepanel.intMousey + 90;
                    gamepanel.int2px2 = controller.boundxright(gamepanel.int2px2);
                    gamepanel.int2py2 = controller.boundybottom(gamepanel.int2py2);
                    gamepanel.int2px1 = gamepanel.int2px2 - 45;
                    gamepanel.int2py1 = gamepanel.int2py2 - 90;
                }
            }
        }
        if(gamepanel.blnMove3a == true){
            //boat 3a is being moved
            /**
            * The 'blnOverlap' property of type boolean.
            */
            boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 3, gamepanel.blnRot3a);
            if(blnOverlap == true){
                //boat will overlap something else. no redrawing
            }else{
                //boat will not overlap something else. redrawing
                if(gamepanel.blnRot3a == false){
                    //redrawing the boat horizontally
                    gamepanel.int3apx1 = gamepanel.intMousex;
                    gamepanel.int3apy1 = gamepanel.intMousey;
                    gamepanel.int3apx2 = gamepanel.intMousex + 135;
                    gamepanel.int3apy2 = gamepanel.intMousey + 45;
                    gamepanel.int3apx2 = controller.boundxright(gamepanel.int3apx2);
                    gamepanel.int3apy2 = controller.boundybottom(gamepanel.int3apy2);
                    gamepanel.int3apx1 = gamepanel.int3apx2 - 135;
                    gamepanel.int3apy1 = gamepanel.int3apy2 - 45;
                }else{
                    //redrawing the boat vertically
                    gamepanel.int3apx1 = gamepanel.intMousex;
                    gamepanel.int3apy1 = gamepanel.intMousey;
                    gamepanel.int3apx2 = gamepanel.intMousex + 45;
                    gamepanel.int3apy2 = gamepanel.intMousey + 135;
                    gamepanel.int3apx2 = controller.boundxright(gamepanel.int3apx2);
                    gamepanel.int3apy2 = controller.boundybottom(gamepanel.int3apy2);
                    gamepanel.int3apx1 = gamepanel.int3apx2 - 45;
                    gamepanel.int3apy1 = gamepanel.int3apy2 - 135;
                }
            }
        }
        if(gamepanel.blnMove3b == true){
            //boat 3b is being moved
            /**
            * The 'blnOverlap' property of type boolean.
            */
            boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 3, gamepanel.blnRot3b);
            if(blnOverlap == true){
                //boat will overlap something else. no redrawing
            }else{
                //boat will not overlap something else. redrawing
                if(gamepanel.blnRot3b == false){
                    //redrawing the boat horizontally
                    gamepanel.int3bpx1 = gamepanel.intMousex;
                    gamepanel.int3bpy1 = gamepanel.intMousey;
                    gamepanel.int3bpx2 = gamepanel.intMousex + 135;
                    gamepanel.int3bpy2 = gamepanel.intMousey + 45;
                    gamepanel.int3bpx2 = controller.boundxright(gamepanel.int3bpx2);
                    gamepanel.int3bpy2 = controller.boundybottom(gamepanel.int3bpy2);
                    gamepanel.int3bpx1 = gamepanel.int3bpx2 - 135;
                    gamepanel.int3bpy1 = gamepanel.int3bpy2 - 45;
                }else{
                    //redrawing the boat vertically
                    gamepanel.int3bpx1 = gamepanel.intMousex;
                    gamepanel.int3bpy1 = gamepanel.intMousey;
                    gamepanel.int3bpx2 = gamepanel.intMousex + 45;
                    gamepanel.int3bpy2 = gamepanel.intMousey + 135;
                    gamepanel.int3bpx2 = controller.boundxright(gamepanel.int3bpx2);
                    gamepanel.int3bpy2 = controller.boundybottom(gamepanel.int3bpy2);
                    gamepanel.int3bpx1 = gamepanel.int3bpx2 - 45;
                    gamepanel.int3bpy1 = gamepanel.int3bpy2 - 135;
                }
            }
        }
        if(gamepanel.blnMove4 == true){
            //boat 4 is being moved
            /**
            * The 'blnOverlap' property of type boolean.
            */
            boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 4, gamepanel.blnRot4);
            if(blnOverlap == true){
                //boat will overlap something else. no redrawing
            }else{
                //boat will not overlap something else. redrawing
                if(gamepanel.blnRot4 == false){
                    //redrawing the boat horizontally
                    gamepanel.int4px1 = gamepanel.intMousex;
                    gamepanel.int4py1 = gamepanel.intMousey;
                    gamepanel.int4px2 = gamepanel.intMousex + 180;
                    gamepanel.int4py2 = gamepanel.intMousey + 45;
                    gamepanel.int4px2 = controller.boundxright(gamepanel.int4px2);
                    gamepanel.int4py2 = controller.boundybottom(gamepanel.int4py2);
                    gamepanel.int4px1 = gamepanel.int4px2 - 180;
                    gamepanel.int4py1 = gamepanel.int4py2 - 45;
                }else{
                    //redrawing the boat vertically
                    gamepanel.int4px1 = gamepanel.intMousex;
                    gamepanel.int4py1 = gamepanel.intMousey;
                    gamepanel.int4px2 = gamepanel.intMousex + 45;
                    gamepanel.int4py2 = gamepanel.intMousey + 180;
                    gamepanel.int4px2 = controller.boundxright(gamepanel.int4px2);
                    gamepanel.int4py2 = controller.boundybottom(gamepanel.int4py2);
                    gamepanel.int4px1 = gamepanel.int4px2 - 45;
                    gamepanel.int4py1 = gamepanel.int4py2 - 180;
                }
            }
        }
        if(gamepanel.blnMove5 == true){
            //boat 5 is being moved
            /**
            * The 'blnOverlap' property of type boolean.
            */
            boolean blnOverlap = controller.checkOverlap(gamepanel.strMap, gamepanel.intMousex, gamepanel.intMousey, 5, gamepanel.blnRot5);
            if(blnOverlap == true){
                //boat will overlap something else. no redrawing
            }else{
                //boat will not overlap something else. redrawing
                if(gamepanel.blnRot5 == false){
                    //redrawing the boat horizontally
                    gamepanel.int5px1 = gamepanel.intMousex;
                    gamepanel.int5py1 = gamepanel.intMousey;
                    gamepanel.int5px2 = gamepanel.intMousex + 225;
                    gamepanel.int5py2 = gamepanel.intMousey + 45;
                    gamepanel.int5px2 = controller.boundxright(gamepanel.int5px2);
                    gamepanel.int5py2 = controller.boundybottom(gamepanel.int5py2);
                    gamepanel.int5px1 = gamepanel.int5px2 - 225;
                    gamepanel.int5py1 = gamepanel.int5py2 - 45;
                }else{
                    //redrawing the boat vertically
                    gamepanel.int5px1 = gamepanel.intMousex;
                    gamepanel.int5py1 = gamepanel.intMousey;
                    gamepanel.int5px2 = gamepanel.intMousex + 45;
                    gamepanel.int5py2 = gamepanel.intMousey + 225;
                    gamepanel.int5px2 = controller.boundxright(gamepanel.int5px2);
                    gamepanel.int5py2 = controller.boundybottom(gamepanel.int5py2);
                    gamepanel.int5px1 = gamepanel.int5px2 - 45;
                    gamepanel.int5py1 = gamepanel.int5py2 - 225;
                }
            }
        }
        //Help Screen
        helppanel1.intMousex = evt.getX();
        helppanel1.intMousey = evt.getY();
        helppanel1.intMousex = controller.snapToX(helppanel1.intMousex);
        helppanel1.intMousey = controller.snapToY(helppanel1.intMousey);
        helppanel1.intMousex = controller.boundxleft(helppanel1.intMousex);
        helppanel1.intMousey = controller.boundytop(helppanel1.intMousey);

        if(helppanel1.blnMove2 == true){
            if(helppanel1.blnRot2 == false){
                helppanel1.int2px1 = helppanel1.intMousex;
                helppanel1.int2py1 = helppanel1.intMousey;
                helppanel1.int2px2 = helppanel1.intMousex + 90;
                helppanel1.int2py2 = helppanel1.intMousey + 45;
                helppanel1.int2px2 = controller.boundxright(helppanel1.int2px2);
                helppanel1.int2py2 = controller.boundybottom(helppanel1.int2py2);
                helppanel1.int2px1 = helppanel1.int2px2 - 90;
                helppanel1.int2py1 = helppanel1.int2py2 - 45;
            }else{
                helppanel1.int2px1 = helppanel1.intMousex;
                helppanel1.int2py1 = helppanel1.intMousey;
                helppanel1.int2px2 = helppanel1.intMousex + 45;
                helppanel1.int2py2 = helppanel1.intMousey + 90;
                helppanel1.int2px2 = controller.boundxright(helppanel1.int2px2);
                helppanel1.int2py2 = controller.boundybottom(helppanel1.int2py2);
                helppanel1.int2px1 = helppanel1.int2px2 - 45;
                helppanel1.int2py1 = helppanel1.int2py2 - 90;
            }
        }else{

        }
    }

    public void mouseMoved(MouseEvent evt){

    }

    public model(){

        text = new Font("arial", Font.BOLD, 20);

        //Main panel
        mainpanel.setPreferredSize(new Dimension(1280, 780));

        //Chat Panel
        chatpanel.setLayout(null);
        chatpanel.setPreferredSize(new Dimension(314,780));

        //Game Panel
        gamepanel.setLayout(null);
        gamepanel.setPreferredSize(new Dimension(966,780));
        gamepanel.addMouseListener(this);
        gamepanel.addMouseMotionListener(this);
        theframe.addKeyListener(this);

        //Chat Area
        thescroll.setSize(238,524);
        thescroll.setLocation(39,66);
        textarea.setEditable(false);
        chatpanel.add(thescroll);

        sendfield.setSize(238,48);
        sendfield.setLocation(39,607);
        sendfield.addActionListener(this);
        chatpanel.add(sendfield);

        //Start button
        startbutton.setSize(163,47);
        startbutton.setLocation(646,607);
        startbutton.setFont(text);
        startbutton.setText("START");
        startbutton.addActionListener(this);
        startbutton.setEnabled(true);
        gamepanel.add(startbutton);

        //Fire button
        firebutton.setSize(163,47);
        firebutton.setLocation(646,607);
        firebutton.setFont(text);
        firebutton.setText("FIRE");
        firebutton.addActionListener(this);
        firebutton.setVisible(false);
        firebutton.setEnabled(false);
        gamepanel.add(firebutton);

        //Row and Column Drop down lists
        rowlist.setSize(163,30);
        rowlist.setLocation(551,83);
        rowlist.addActionListener(this);
        rowlist.setEnabled(false);
        gamepanel.add(rowlist);

        collist.setSize(163,30);
        collist.setLocation(740,83);
        collist.addActionListener(this);
        collist.setEnabled(false);
        gamepanel.add(collist);

        //Username labels
        user1label.setFont(text);
        user1label.setSize(150,50);
        user1label.setLocation(182,83);
        gamepanel.add(user1label);

        //Adding game and chat
        mainpanel.add(gamepanel);
        mainpanel.add(chatpanel);

        //Home Panel
        homepanel.setLayout(null);
        homepanel.setPreferredSize(new Dimension(1280,780));

        //Play, Help, and Quit Button
        playbutton.setSize(497,80);
        playbutton.setLocation(390, 287);
        playbutton.setFont(text);
        playbutton.addActionListener(this);
        homepanel.add(playbutton);

        helpbutton.setSize(497,80);
        helpbutton.setLocation(390, 427);
        helpbutton.setFont(text);
        helpbutton.addActionListener(this);
        homepanel.add(helpbutton);

        quitbutton.setSize(497,80);
        quitbutton.setLocation(390, 567);
        quitbutton.setFont(text);
        quitbutton.addActionListener(this);
        homepanel.add(quitbutton);

        quitbutton1.setSize(497,80);
        quitbutton1.setLocation(390, 567);
        quitbutton1.setFont(text);
        quitbutton1.addActionListener(this);
        gameoverpanel.add(quitbutton1);

        //Battleship  Title
        /**
        * The 'text' property of type Title.
        */
        text = new Font("arial", Font.BOLD, 60);
        battleship.setSize(435, 95);
        battleship.setLocation(447,154);
        battleship.setFont(text);
        homepanel.add(battleship);

        //Join Panel
        joinpanel.setLayout(null);
        joinpanel.setPreferredSize(new Dimension(1280,780));

        //Battleship Title
        title.setSize(435, 95);
        title.setLocation(470,124);
        title.setFont(text);
        joinpanel.add(title);

        //User, IP, Port Labels
        /**
        * The 'text' property of type Labels.
        */
        text = new Font("arial", Font.BOLD, 32);
        userlabel.setSize(310, 51);
        userlabel.setLocation(581, 236);
        userlabel.setFont(text);
        joinpanel.add(userlabel);

        iplabel.setSize(289, 40);
        iplabel.setLocation(500, 410);
        iplabel.setFont(text);
        joinpanel.add(iplabel);

        portlabel.setSize(289, 40);
        portlabel.setLocation(768, 410);
        portlabel.setFont(text);
        joinpanel.add(portlabel);

        //Host and Join Buttons
        host.setSize(251, 80);
        host.setLocation(387, 558);
        host.setFont(text);
        host.addActionListener(this);
        joinpanel.add(host);

        join.setSize(251, 80);
        join.setLocation(677, 558);
        join.setFont(text);
        join.addActionListener(this);
        joinpanel.add(join);

        //Username, IP, and Port Text Fields
        username.setSize(542, 80);
        username.setLocation(386, 280);
        username.setFont(text);
        username.addKeyListener(this);
        joinpanel.add(username);

        ip.setSize(251, 80);
        ip.setLocation(389, 450);
        ip.setFont(text);
        joinpanel.add(ip);

        port.setSize(251, 80);
        port.setLocation(677, 450);
        port.setFont(text);
        joinpanel.add(port);
        port.setEnabled(false);


        //Theme Panel and Buttons
        themepanel.setLayout(null);
        themepanel.setPreferredSize(new Dimension(1280,780));

        standardbutton.setSize(331,106);
        standardbutton.setLocation(622,154);
        standardbutton.addActionListener(this);
        standardbutton.setEnabled(false);
        themepanel.add(standardbutton);

        carsbutton.setSize(331,106);
        carsbutton.setLocation(622,344);
        carsbutton.addActionListener(this);
        carsbutton.setEnabled(false);
        themepanel.add(carsbutton);

        spacebutton.setSize(331,106);
        spacebutton.setLocation(622,533);
        spacebutton.addActionListener(this);
        spacebutton.setEnabled(false);
        themepanel.add(spacebutton);

        //Waiting Panel
        waitingpanel.setLayout(null);
        waitingpanel.setPreferredSize(new Dimension(1280,780));
        text = new Font("arial", Font.BOLD, 60);
        waitinglabel.setSize(650,100);
        waitinglabel.setLocation(330,320);
        waitinglabel.setFont(text);
        waitingpanel.add(waitinglabel);

        //Help
        helppanel1.setLayout(null);
        helppanel1.setPreferredSize(new Dimension(1280,780));
        helppanel1.addMouseListener(this);
        helppanel1.addMouseMotionListener(this);

        helppanel2.setLayout(null);
        helppanel2.setPreferredSize(new Dimension(1280,780));

        helppanel3.setLayout(null);
        helppanel3.setPreferredSize(new Dimension(1280,780));

        //Font
        /**
        * The 'text' property of type Font.
        */
        text = new Font("arial", Font.BOLD, 20);

        //Help Panel 1
        backbutton.setSize(250,100);
        backbutton.setLocation(20,660);
        backbutton.addActionListener(this);
        helppanel1.add(backbutton);

        nextbutton1.setSize(250,100);
        nextbutton1.setLocation(1010,660);
        nextbutton1.addActionListener(this);
        helppanel1.add(nextbutton1);

        startbuttonh.setSize(163,47);
        startbuttonh.setLocation(646,607);
        //firebutton.setFont(text);
        helppanel1.add(startbuttonh);

        user1labelh.setFont(text);
        user1labelh.setSize(150,50);
        user1labelh.setLocation(182,83);
        helppanel1.add(user1labelh);

        //Help Panel 2
        backbutton1.setSize(250,100);
        backbutton1.setLocation(20,660);
        backbutton1.addActionListener(this);
        helppanel2.add(backbutton1);

        nextbutton2.setSize(250,100);
        nextbutton2.setLocation(1010,660);
        nextbutton2.addActionListener(this);
        helppanel2.add(nextbutton2);

        firebuttonh.setSize(163,47);
        firebuttonh.setLocation(646,607);
        //firebutton.setFont(text);
        helppanel2.add(firebuttonh);

        user2labelh.setFont(text);
        user2labelh.setSize(150,50);
        user2labelh.setLocation(182,83);
        helppanel2.add(user2labelh);

        //Help text area
        thescrollh.setSize(238,524);
        thescrollh.setLocation(1005,66);
        textareah.setEditable(false);
        helppanel2.add(thescrollh);

        sendfieldh.setSize(238,48);
        sendfieldh.setLocation(1005,607);
        sendfieldh.addActionListener(this);
        helppanel2.add(sendfieldh);

        //Help Drop down lists
        rowlisth.setSize(163,30);
        rowlisth.setLocation(551,83);
        rowlisth.addActionListener(this);
        helppanel2.add(rowlisth);

        collisth.setSize(163,30);
        collisth.setLocation(740,83);
        collisth.addActionListener(this);
        helppanel2.add(collisth);

        //Help Panel 3
        backbutton2.setSize(250,100);
        backbutton2.setLocation(20,660);
        backbutton2.addActionListener(this);
        helppanel3.add(backbutton2);

        user3labelh.setFont(text);
        user3labelh.setSize(150,50);
        user3labelh.setLocation(182,83);
        helppanel3.add(user3labelh);

        //Waiting Panel
        gameoverpanel.setLayout(null);
        gameoverpanel.setPreferredSize(new Dimension(1280,780));
        text = new Font("arial", Font.BOLD, 60);
        gameoverlabel.setSize(650,100);
        gameoverlabel.setLocation(460,320);
        gameoverlabel.setFont(text);
        gameoverpanel.add(gameoverlabel);

        //The Frame
        theframe.setContentPane(homepanel);
        theframe.pack();
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setResizable(false);
        theframe.setVisible(true);

        //Timer
        theTimer.start();
        helpTimer.start();
    }

    public static void main(String[] args){
        new model();
    }
}
