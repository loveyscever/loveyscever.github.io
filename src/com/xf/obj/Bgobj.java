package com.xf.obj;

import java.awt.*;

//±³¾°Àà
public class Bgobj extends GameObj{
    public void painSelf(Graphics g){
        super.painSelf(g);
        //yÖáÒÆ¶¯
        y+=speed;
        if (y>=0){
            y=-1866;
        }
    }
    public Bgobj(){
        super();
    }
    public Bgobj(Image image,int x,int y,double speed){
        super(image,x,y,speed);

    }
}
