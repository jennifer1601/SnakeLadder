/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.*;
import java.io.*;

/**
 *
 * @author User
 */
public class Sounds {

    public static void hop() {
        try {
            InputStream is = Sounds.class.getClassLoader().getResourceAsStream("Sound/jump.wav");
            AudioPlayer.player.start(is);
        } catch (Exception e) {
            System.out.println("LOLOL");
        }
    }

    public static void snake() {
        try {
            InputStream is = Sounds.class.getClassLoader().getResourceAsStream("Sound/lose.wav");
            AudioPlayer.player.start(is);
        } catch (Exception e) {
            System.out.println("LOLOL");
        }
    }

    public static void ladder() {
        try {
            InputStream is = Sounds.class.getClassLoader().getResourceAsStream("Sound/stair.wav");
            AudioPlayer.player.start(is);
        } catch (Exception e) {
            System.out.println("LOLOL");
        }
    }

    public static void cheer() {
        try {
            InputStream is = Sounds.class.getClassLoader().getResourceAsStream("Sound/cheer.wav");
            AudioPlayer.player.start(is);
        } catch (Exception e) {
            System.out.println("LOLOL");
        }
    }

    
}
