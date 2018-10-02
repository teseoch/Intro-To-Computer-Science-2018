public class GameOfLife
{
	public static void initalize(boolean[][] alive, double aliveProbability)
	{
		int n = alive.length;

		for(int  i = 0; i < n; ++i)
		{
			for(int  j = 0; j < n; ++j)
			{
				alive[i][j] = Math.random() < aliveProbability;
			}
		}

		// alive[0][0] = true;
		// alive[1][0] = true;
		// alive[2][0] = true;
		// alive[2][1] = true;
		// alive[2][3] = true;

		// alive[4][4] = true;
		// alive[4][5] = true;
		// alive[5][5] = true;
		// alive[5][4] = true;
	}

	public static void print(boolean[][] alive)
	{
		int n = alive.length;

		for(int  i = 0; i < n; ++i)
		{
			for(int  j = 0; j < n; ++j)
			{
				if(alive[i][j])
				{
					System.out.print('\u2B1B');
				}
				else
				{
					System.out.print("  ");
				}
			}

			// System.out.println("");
			System.out.print("\n");
		}
	}

	public static boolean get(boolean[][] alive, int i, int j)
	{
		int n = alive.length;

		if(i < 0)
			i = n - 1;
		if(j < 0)
			j = n - 1;

		if( i >= n)
			i = 0;

		if( j >= n)
			j = 0;

		return alive[i][j];
	}

	public static int countAlive(boolean[][] alive, int indexI, int indexJ)
	{
		int n = alive.length;


		int startI = indexI - 1;
		int startJ = indexJ - 1;

		int endI = indexI + 1;
		int endJ = indexJ + 1;

		int counter = 0;
		for(int i = startI; i <= endI; ++i)
		{
			for(int j = startJ; j <= endJ; ++j)
			{
				if(i == indexI && j == indexJ)
					continue;

				if(get(alive,i,j))
					counter++;
			}
		}

		return counter;
	}

	public static void update(boolean[][] alive)
	{
		int n = alive.length;
		boolean[][] newAlive = new boolean[n][n];

		for(int  i = 0; i < n; ++i)
		{
			for(int  j = 0; j < n; ++j)
			{
				int aliveNeighs = countAlive(alive, i, j);

				if(alive[i][j])
				{
					if(aliveNeighs < 2)
					{
						newAlive[i][j] = false;
					}
					else if(aliveNeighs == 2 || aliveNeighs == 3)
					{
						newAlive[i][j] = true;
					}
					else
					{
						//more than 3
						newAlive[i][j] = false;
					}
				}
				else //the cell is dead
				{
					if(aliveNeighs == 3)
					{
						newAlive[i][j] = true;
					}
					else
					{
						newAlive[i][j] = false;
					}
				}
			}
		}

		for(int  i = 0; i < n; ++i)
		{
			for(int  j = 0; j < n; ++j)
			{
				alive[i][j] = newAlive[i][j];
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int n = 90;
		double probability = 0.1;

		boolean[][] alive = new boolean[n][n];

		initalize(alive, probability);

		while(true)
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();


			print(alive);
			update(alive);

			Thread.sleep(100);

		}

		// System.out.println("8x8 " + countAlive(alive, 8, 8));
		// System.out.println("8x9 " + countAlive(alive, 8, 9));
		// System.out.println("1x2 " + countAlive(alive, 1, 2));
		// System.out.println("0x0 " + countAlive(alive, 0, 0));
	}
}