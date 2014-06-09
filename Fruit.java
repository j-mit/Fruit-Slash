import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Fruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruit extends Actor implements Observer
{
    /**
     * Act - do whatever the Fruit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
   public Fruit()
   {
   }
    
   public Fruit(FruitType select) {
        this.select = select;
    }
    

    // Do subclass level processing in this method
    private FruitType select = null;

    public FruitType getChoice() {
        return select;
    }

    public void setChoice(FruitType select) {
        this.select = select;
    }
    
    public void update(Fruit f, FruitNinja fn)
    {
     GreenfootImage img = f.getImage();
     String fruitName = img.toString();
     if(fruitName.contains("apple"))
     {
      Apple a = new Apple();
      a.pop(fn);
     }
     else if(fruitName.contains("banana"))
     {
      Banana b = new Banana();
      b.pop(fn);
     }
     else if(fruitName.contains("orange"))
     {
      Orange o = new Orange();
      o.pop(fn);
     }  
    }
    
}
