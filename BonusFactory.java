import greenfoot.*;
/**
 * Write a description of class BonusFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BonusFactory extends Actor
{
   
    public static Bonus create(BonusType select) {
		Bonus bonus = null;
		switch (select) {
    		case DOUBLE:
    			bonus = new Double();
    			break;
    
    		case EXTRA:
    			bonus = new Extra();
    			break;
    
		}
		return bonus;
	}
}
