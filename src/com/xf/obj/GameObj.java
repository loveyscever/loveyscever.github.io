package com.xf.obj;

import com.xf.mian.GameWin;

import java.awt.*;

//游戏物体的父类
public class GameObj {
    Image image;//图片
    int x;//x，y轴
    int y;
    int w;//宽高；
    int h;
    double speed;//速度
    GameWin gameWin;//窗口对象

    public GameObj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speed = speed;
        this.gameWin = gameWin;
    }

    public GameObj() {
        super();
    }

    public GameObj(Image image, int x, int y, double speed) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(int x, int y) {
        super();
        this.x=x;
        this.y=y;
    }

    //绘制自身
    public void painSelf(Graphics g){
        g.drawImage(image,x,y,null);
    }

    //获取自身矩形,检查碰撞
    public Rectangle setres(){
        return new Rectangle(x,y,w,h);
    }
    public Image getImage() {
        return image;
    }

    public Rectangle getRes()
    {
        return new Rectangle(x,y,w,h);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getGameWin() {
        return gameWin;
    }

    public void setGameWin(GameWin gameWin) {
        this.gameWin = gameWin;
    }

    @Override
    public String toString() {
        return "GameObj{" +
                "image=" + image +
                ", x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                ", speed=" + speed +
                ", gameWin=" + gameWin +
                '}';
    }
}
