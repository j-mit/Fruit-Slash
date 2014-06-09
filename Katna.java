import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A dart is used to pop balloons.
 * 
 * @author Poul Henriksen
 */
public class Katna extends Actor implements Subject
{
    /**
     * Make the dart follow the mouse and check for mouseclicks.
     */
    static boolean shadowImagery = true;
    static int count=0;
    Fruit f;
    Bonus bon;
    Observer obs;

    public void Katna(Observer obs)
    {
        this.obs=obs;
    }
    public void notifyObservers(Fruit f, FruitNinja fn)
        {
            obs.update(f, fn);
        }
        
    public void act() 
    {   
        if(Greenfoot.mousePressed(this))
        {
          getImage().setTransparency(200);
        }
        else if(Greenfoot.mouseClicked(this))
        {
          getImage().setTransparency(0);
        }
        
        // Follow the mouse
        if(Greenfoot.mouseDragged(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            
            if (shadowImagery==true){
               getWorld().addObject(new Shadow(getImage()),getX(),getY());}
            
            setLocation(mouse.getX(), mouse.getY());
        }
        
        
        if(Greenfoot.mouseDragged(null)) {
            Fruit f = (Fruit) getOneIntersectingObject( Fruit.class);
            obs=new Fruit();
            if(f!= null) {
                FruitNinja fn = (FruitNinja)getWorld();
                //System.out.println(fn);
                notifyObservers(f, fn);
                //Greenfoot.delay(20);
                fn.removeObject(f);
            }
        }
                     
        
        if(Greenfoot.mouseDragged(null)) {     
            Bonus b = (Bonus) getOneIntersectingObject(Bonus.class);
            bon=new Bonus();
            if(b != null) {
                FruitNinja fn = (FruitNinja)getWorld();
                bon.call(b,fn);
                fn.removeObject(b);
            }
        }
        
        if(Greenfoot.mouseDragged(null)) {
            Bomb bm = (Bomb) getOneIntersectingObject( Bomb.class);
            if(bm != null) {
                bm.pop();
                ((FruitNinja) getWorld()).gameOver();
            }
        }
    }    
    
}
