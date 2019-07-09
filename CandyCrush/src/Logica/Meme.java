/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Estudiantes
 */
public class Meme {

    private BufferedImage imgn;

    
    public Meme(int dulce) throws IOException {
        switch (dulce) {
            case 1:
                imgn = ImageIO.read(getClass().getResource("/Imagenes/1.png"));                
                break;
            case 2:
                imgn = ImageIO.read(getClass().getResource("/Imagenes/2.png"));  
                break;
            case 3:
                imgn = ImageIO.read(getClass().getResource("/Imagenes/3.png"));  
                break;
            case 4:
                imgn = ImageIO.read(getClass().getResource("/Imagenes/4.png"));  
                break;
            case 5:
                imgn = ImageIO.read(getClass().getResource("/Imagenes/5.png"));  
                break;
            default:
                System.out.println("no sirvo");

        }
    }

    public BufferedImage getImgn() {
        return imgn;
    }
    
    

}
