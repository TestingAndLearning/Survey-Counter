package javaexe;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState
{
	Image Start;
	Image Exit;
	Image CPCBG; 
	
	boolean startMouse = false;
	
	public Menu(int state)
	{
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{

		Exit = new Image("res/Exit.png");
		Start = new Image("res/Start.png");
		CPCBG = new Image("res/CPCBG.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		CPCBG.draw(0, 0);
		g.drawString("CCPC " + gc.getHeight(), 50, 50);
		g.drawString("Survey Counter", 50, 80);
		Start.draw(50,200);
		Exit.draw(50,300);
		g.drawString(Mouse.getX() + " " + Mouse.getY(), 300, 10);
		
		//TODO make mouse coordinates match buttons, not just static numbers
		if (startMouse == true)
		{
			g.drawString("**", 300, 50);
			if(startMouse == false)
			{
				g.clear();
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//Start Button
		if((posX>50 && posX<261)&&(posY>225 && posY<276))
		{
			if(Mouse.isButtonDown(0))
			{
				sbg.enterState(1);
			}
		}
		
		//Mouseover Text in corner. 
		if((posX>50 && posX<261)&&(posY>225 && posY<276))
		{
			startMouse = true;
		}
		else
		{
			startMouse = false;
		}
			
		
		//Exit Button
		if((posX>50 && posX<261)&&(posY>125 && posY<176))
		{
			//0 for first mouse button, 1 for right click
			if(Mouse.isButtonDown(0))
			{
				System.exit(0);
			}
		}
	}
	
	public int getID()
	{
		return 0;
	}
}
