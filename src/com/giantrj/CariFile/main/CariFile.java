/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.giantrj.CariFile.main;

import com.giantrj.CariFile.UI.MainUI;
import javax.swing.WindowConstants;

/**
 *
 * @author PCMASTERRACE
 */
public class CariFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainUI mainui = new MainUI();
        mainui.setLocationRelativeTo(null);
        mainui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainui.setVisible(true);        
    }
    
}
