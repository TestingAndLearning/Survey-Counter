package javaexe;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//Menu = 0
//Cells = 1

public class Start extends StateBasedGame
{
	public static final String exename = "Survey Counter";
	public static final int menu = 0;
	public static final int cells = 1;
	
	public Start(String appname)
	{
		super(appname);
		this.addState(new Menu(menu));
		this.addState(new Cells(cells));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException
	{
		this.getState(menu).init(gc, this);
		this.getState(cells).init(gc, this);
		this.enterState(menu);
	}
	
	// Creating Window
	//setDisplayMode true for fullscreen
	public static void main(String[] args)
	{
		
		AppGameContainer appgc;
		
		try
		{
			appgc = new AppGameContainer(new Start(exename));
			appgc.setDisplayMode(480, 490, false);
			
			appgc.start();
		}
			catch(SlickException e)
			{
				e.printStackTrace();
			}
		
	}
}
