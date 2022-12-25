package Recursion_Backtracing;
import java.util.*;

public class N_Queen {
	
	public static boolean isSafe (int row , int col , char[][] board )
	{
		for (int j=0; j< board.length ; j++)
		{
			if(board[row][j] == 'Q')
			{
				return false;
			}
		}
		
		for (int i=0; i< board.length ; i++)
		{
			if(board[i][col] == 'Q')
			{
				return false;
			}
		}
		
		// Upper Left
		int r = row;
		for(int c = col; c >= 0 && r>= 0; r--, c-- )
		{
			if(board[r][c] == 'Q')
			{
				return false;
			}
			
		}
		
		// Upper Right
			r = row;
			for(int c = col; c < board.length && r>= 0; r--, c++ )
			{
				if(board[r][c] == 'Q')
				{
					return false;
				}
					
			}
			
			// Lower Left
			 r = row;
			for(int c = col; c >= 0 && r < board.length ; r++, c-- )
			{
				if(board[r][c] == 'Q')
				{
					return false;
				}
				
			}
			
			
			// Lower right
			 r = row;
			for(int c = col; c < board.length && r < board.length ; r++, c++ )
			{
				if(board[r][c] == 'Q')
				{
					return false;
				}
				
			}
			
			return true;

	}
	
	
	public static void saveboard (char[][] board, ArrayList <ArrayList<String>> allboard)
	{
		String row = "";
		ArrayList <String> newboard = new ArrayList <> ();
		
		for(int i =0 ; i< board.length ; i++ )
		{
			row = "";
			for(int j=0 ; j< board[0].length ; j++)
			{
				if(board[i][j] == 'Q')
				{
					row += 'Q';
				}
				
				else
				{
					row += '.'; 
				}
				
				
			}
			newboard.add(row);
			
		}
		
		allboard.add(newboard);
	}
	
	public static void helper (char[][] board, ArrayList <ArrayList<String>> allboard , int col)
	{
		if(col == board.length)
		{
			saveboard(board, allboard);
			return;
		}
		
		for(int row=0 ; row < board.length ; row++)
		{
			if(isSafe(row, col , board))
			{
				board[row][col] = 'Q';
				helper(board, allboard , col+1);
				board[row][col] = '.';
			}
		}
	}
	
	
	public static ArrayList <ArrayList<String>> solvequeen (int n)
	{
		ArrayList <ArrayList<String>> allboard = new ArrayList <>();
		char[][] board = new char [n][n];
		
		helper(board, allboard , 0);
		return allboard;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n =4;
		
		System.out.println(solvequeen (n));
		
	}

}
