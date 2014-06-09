import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.Random;
/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor implements MessageObserver
{
    //GreenfootImage g;
    static String msg;
   
    public Message()
    {
    }
    
    public void update(int score, FruitNinja fw){
        Show sh = new Show();
        if(score>=250 && score<=300){
         msg=" You are a CUTTER!! ";
         sh.display(msg,fw);
        }
        else if(score>=500 && score<=550){
         msg=" You are a CHEF!!!! ";
         sh.display(msg,fw);
        }
        else if(score>=750 && score<=800){
         msg=" you are a BUTCHER!! ";
         sh.display(msg,fw);
        }
        else if(score>=1000 && score<=1050){
         msg=" You are a NINJA!!!! ";
         sh.display(msg,fw);
        }
        else if(score>=1250 && score<=1300){
         msg=" You are a SAMURAI!! ";
         sh.display(msg,fw);
        }
        else if(score>=1500 && score<=1550){
         msg=" PLEASE!! Leave Some FRUITS For OTHERS !! ";
         sh.display(msg,fw);
        }
     }   
    }
