import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends Actor
{
    static int i=0; 
    public Game (){
        GreenfootImage image = getImage();
        image.scale(75,75);
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this)){
        setReset(1);
        FruitNinja world=(FruitNinja)getWorld();
        world.z=true;
        world.removeInstructions();
        world.setPaintOrder(ScoreBoard.class, Katna.class, Apple.class, Counter.class);
        world.populate();
        
     }
    }
    
    public int getReset()
    {
        return i;
    }
    
    public void setReset(int i)
    {
        this.i = i;
    }
    
}
