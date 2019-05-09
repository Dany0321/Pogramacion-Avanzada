/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.ImageIcon;

/**
 *
 * @author Estudiantes
 */
public class Meme {

    private ImageIcon imgn;

    
    public Meme(int dulce) {
        switch (dulce) {
            case 1:
                imgn = new ImageIcon("img/1.png");                
                break;
            case 2:
                imgn = new ImageIcon("img/2.png");
                break;
            case 3:
                imgn = new ImageIcon("img/3.png");
                break;
            case 4:
                imgn = new ImageIcon("img/4.png");
                break;
            case 5:
                imgn = new ImageIcon("img/5.png");
                break;

        }
    }

    public ImageIcon getImgn() {
        return imgn;
    }
    
    

}
