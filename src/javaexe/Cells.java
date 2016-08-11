package javaexe;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Cells extends BasicGameState
{
	int rows = 24;
	int cols = 8;
	//int cell[][] = new int[rows][cols];
	int[][] cell = 
		{
			{0, 1, 2, 3, 4, 5, 6, 0},
			{1, 0, 0, 0, 0, 0, 0, 0},
			{2, 0, 0, 0, 0, 0, 0, 0},
			{3, 0, 0, 0, 0, 0, 0, 0},
			{4, 0, 0, 0, 0, 0, 0, 0},
			{5, 0, 0, 0, 0, 0, 0, 0},
			
			{6, 0, 0, 0, 0, 0, 0, 0},
			{7, 0, 0, 0, 0, 0, 0, 0},
			{8, 0, 0, 0, 0, 0, 0, 0},
			{9, 0, 0, 0, 0, 0, 0, 0},
			{10, 0, 0, 0, 0, 0, 0, 0},
			
			{11, 0, 0, 0, 0, 0, 0, 0},
			{12, 0, 0, 0, 0, 0, 0, 0},
			{13, 0, 0, 0, 0, 0, 0, 0},
			{14, 0, 0, 0, 0, 0, 0, 0},
			{15, 0, 0, 0, 0, 0, 0, 0},
			
			{16, 0, 0, 0, 0, 0, 0, 0},
			{17, 0, 0, 0, 0, 0, 0, 0},
			{18, 0, 0, 0, 0, 0, 0, 0},
			{19, 0, 0, 0, 0, 0, 0, 0},
			{20, 0, 0, 0, 0, 0, 0, 0},
			
			{21, 0, 0, 0, 0, 0, 0, 0},
			{22, 0, 0, 0, 0, 0, 0, 0},
			{23, 0, 0, 0, 0, 0, 0, 0},
		};
	int x = 0;
	int y = 0;
	
	//For moving the stuff down and inputting values
	int cX = 0;
	int cY = 0;
	int sheets = 0;
	
	public Cells(int state)
	{
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		
	}
	
	/*
	How the cells were generated: 
	1. Get size of screen. 
	2. Come up with number of rows and columns. 
	3. Figure out size of block/cell. Block width is screen_width/column. Block height is screen_height/row.
	4. Use for loop, looping over number of rows and columns to create cells. 
	
	for (int r = 0 ; r < row_size; r++) 
	{
			for (int c = 0 ; c < col_size; c++) 
			{
				//Draw a rectangle at position (c*col_size, r*row_size) with size (col_size, row_size) 
				//Draw the text of the cell's value at position (c*col_size, r*row_size)
				//If r == y && c == x draw the rectangle in a darker color
	 		}
	}
	
	This loop draws a column, then moves to the next row and draws the column for that row. 
	*/
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		//This is the bottom fill color. 
		g.setColor(Color.gray);
		g.fillRect(gc.getHeight()/rows, gc.getWidth()/cols, gc.getHeight(), gc.getWidth());
		g.setColor(Color.white);
		g.fillRect(0, 0, gc.getHeight(), gc.getWidth());
		
		//Draws grey rectangles, vertical then horizontal fill. 
		g.setColor(Color.gray);
		g.fillRect(0, gc.getHeight()/rows, gc.getWidth()/cols, (gc.getHeight() - (gc.getHeight()/rows)));
		g.fillRect(gc.getWidth()/cols, 0, gc.getWidth() - (gc.getWidth()/cols), (gc.getHeight()/rows));
		
		for (int r = 1 ; r <= (rows); r++) 
		{
				for (int c = 1 ; c <= (cols); c++) 
				{
			
				//This draws the cells
				g.setColor(Color.black);
				g.drawRect(0, 0, c* (gc.getWidth()/(cols)) , r* (gc.getHeight()/(rows))); 
				//Draw the text of the cell's value at position (c*col_size, r*row_size)
				String cellString = "       ";
				cellString = Integer.toString(cell[r-1][c-1]);
				//This draws the strings in cells
				g.drawString(cellString, ((c-1)*(gc.getWidth()/(cols)))+(gc.getWidth()/(cols*5/2)), (r-1)*(gc.getHeight()/(rows)));
				
				//This draws the bolded horizontal line, then vertical line
				g.fillRect(0, gc.getHeight()/(rows)-3, c*(gc.getWidth()/(cols)), 3);
				g.fillRect(gc.getWidth()/(cols), 0, 3, r*(gc.getHeight()/(rows)));
				}
		}
		
		
		
		//For moving box down and inputs
		g.setColor(Color.red);
		g.drawRect((0+cX)*(gc.getWidth()/cols), (0+cY)*(gc.getHeight()/rows), gc.getWidth()/cols, gc.getHeight()/rows);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_NUMPAD1) && cY < rows-1 )
		{
			cell[cY+1][1]++;
			cX = 1;
			cY++;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD2) && cY < rows-1 )
		{
			cell[cY+1][2]++;
			cX = 2;
			cY++;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD3) && cY < rows-1 )
		{
			cell[cY+1][3]++;
			cX = 3;
			cY++;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD4) && cY < rows-1 )
		{
			cell[cY+1][4]++;
			cX = 4;
			cY++;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD5) && cY < rows-1 )
		{
			cell[cY+1][5]++;
			cX = 5;
			cY++;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD6) && cY < rows-1 )
		{
			cell[cY+1][6]++;
			cX = 6;
			cY++;
		}
		
		if(input.isKeyPressed(Input.KEY_NUMPAD0) && cY < rows-1 )
		{
			cell[cY+1][7]++;
			cX = 7;
			cY++;
		}
		
		//Resets and adds to sheet number, which is cell[0][0]
		if(input.isKeyPressed(Input.KEY_ENTER) && cY == rows-1)
		{
			cX = 0;
			cY = 0;
			cell[cY][0]++;
		}

	}
	
	//play (cells) is 1
	public int getID()
	{
		return 1;
	}
	
}
