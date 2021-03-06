/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodius;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 *
 * @author Lehel
 */
public class Enemy2Sprite extends _Sprite
{

    private int c = 0;
    private int state = 1;
    
    public Enemy2Sprite(PApplet p, PVector pos) 
    {
        super(p, pos);
        
        this.img = p.loadImage("enemy.png");
        this.sprites = new PImage[5];
        int x = 8,y = 130, w =35 , h = 35;
        
        for (int i=0;i<sprites.length;i++)
        {
            this.sprites[i] = this.img.get(x+i*w, y, w, h);
            this.sprites[i].resize(w*2, h*2);
        }
    }
    
    public void render(float w, float h)
    {
        if(c == 0) state = 1;
        else if(c == sprites.length-1) state = -1;
        if(p.frameCount % 10 == 0 && state == 1)
        {
            c++;
        }
        else if(p.frameCount % 10 == 0 && state == -1)
        {
            c--;
        }
        p.pushMatrix();
        //p.scale(state, 1);
        p.image(sprites[c],pos.x-w-5,pos.y-h-35);
        p.popMatrix();
    }
    
}

