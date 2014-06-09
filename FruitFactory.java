import greenfoot.*;
/**
 * Write a description of class FruitInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FruitFactory extends Actor
{   
   
   public static Fruit create(FruitType select) {
		Fruit fruit = null;
		switch (select) {
    		case APPLE:
    			fruit = new Apple();
    			break;
    
    		case BANANA:
    			fruit = new Banana();
    			break;
    
    		case ORANGE:
    			fruit = new Orange();
    			break;
		}
		return fruit;
	}
	
}