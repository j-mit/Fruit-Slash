import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class orange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orange extends Fruit
{
    /**
     * Moving the banana. 
     */ 
    int num=0;
    int x=2,y=-2;
    int flag=0;
    static int loop=0,ht;
    
    Orange()
    {
     super(FruitType.ORANGE);
    }
    
    public void act() 
    {
        setLocation(getX(), getY() +y);
        ht=100;//till what height can fruit travel
        if(getY()<=ht)
        {
            num++;
            loop=Greenfoot.getRandomNumber(2);
            if(loop==0)//loop - how much dist to move after reaching a particular height(ht)
            {  
             move(-20);   
            }
            else
            {
             move(20);   
            }
            flag=1;
            x=x*(2);
            y=y*(-2);
        }
        
        if(flag==1 && getY()==0)
        {
            getImage().setTransparency(0);
            flag=0;
        }
        if(getX()<=10 || getX()>=590)
        {
            move(-25);
            x=0;
        }
        //make the orange disappear
        if(getY()>=490 && num>0)
           getWorld().removeObject(this);

    }    
    
    /**
     * Pop this orange.
     */
    public void pop(FruitNinja fn) 
    {
        Greenfoot.playSound("cut.mp3");
        fn.count(10,fn);
        GreenfootImage orange = new GreenfootImage("orangeCut.png");
        setImage(orange);
        //Greenfoot.delay(10);
        //getWorld().removeObject(this);
    }   
}
