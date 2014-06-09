import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class FruitNinja extends World 
{
    Counter counter = new Counter("Score: ");
    static int x=0;
    static int xc=0;
    //static int sc=0;
    Instructions ins;
    Game game;
    Score s;
    boolean c = true;
    public static boolean z = false;
    public static int num=0, num1=0;
    Double d;
    public FruitNinja()
    {    
        super(600, 500, 1);
        this.showStartScreen();
    }
               
    public void showStartScreen(){
        game = new Game();
        ins = new Instructions();
        addObject(ins,300, 250);
        addObject(game,300,423);
        
    }
    
    public void removeInstructions(){
        this.removeObject(game);
        this.removeObject(ins);
    }
    
    
    public void act() 
    {
       if(game.getReset()==1) 
        reset();  
    }
    
    public void reset()
    {
        if(c==true)
        {
         MouseInfo m = Greenfoot.getMouseInfo();
         if(m != null && Greenfoot.mousePressed(null)) {
            int x = m.getX();
            int y = m.getY();
            addObject(new Katna(), x, y);
            c=false;
        }
    }
        if(z==true){
        if(Greenfoot.getRandomNumber(300) < 3) {
            xc=Greenfoot.getRandomNumber(600);
            if(xc>=20 && xc<=580)           // so that fruit does'nt go out of the screen
            {
                x=Greenfoot.getRandomNumber(4);                 
              switch(x)
              {           
                case 0:
                    addObject(new Bomb(), xc, 500);
                    //break;
                case 1:
                  addObject(FruitFactory.create(FruitType.APPLE),xc, 500);
                  break;
                case 2:
                  addObject((FruitFactory.create(FruitType.BANANA)),xc, 500);
                  break;
                case 3:
                  addObject((FruitFactory.create(FruitType.ORANGE)),xc, 500);
                  break;
              }
              if((counter.getValue()>0 && counter.getValue()%200==0) && num==0 )
              {
                num=1;
                addObject(BonusFactory.create(BonusType.DOUBLE), xc,500);
              }

            }   
            
            if((counter.getValue()>0 && counter.getValue()%200!=0 && counter.getValue()%100==0) && num1==0 )
              {
                num1=1;
                addObject(BonusFactory.create(BonusType.EXTRA), 0,Greenfoot.getRandomNumber(500));
              }
        }
    }
    }
    public void count(int score, FruitNinja fn)
    {
      num=0;
      num1=0;
      counter.add(score);      //score on the screen being incremented
      s = new Score();   
      s.addScore(score,fn);       //score on final display
    }
    

    public void gameOver() 
    {
        removeObject(counter);
        addObject(new GameOver(), 300, 250);
        addObject(new ScoreBoard(s.getScore()), getWidth()/2, getHeight()/2);
        s.setScore(0);
        Greenfoot.playSound("pop.wav");
        Greenfoot.stop();
        game.setReset(0);
    }


    public void populate()
    {
        addObject(counter, 100, 460);
    }  
    
}
