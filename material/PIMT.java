public class PIMT
{
	public static void main(String[] args) {
		int tossedPoints = 0;
		int insideCircle = 0;

		while(true)
		{
			tossedPoints++;

			double x = 2*Math.random() - 1;
			double y = 2*Math.random() - 1;

			double r = Math.sqrt(x*x + y*y);

			if(r <= 1)
			{
				insideCircle++;
			}

			double approxPi = (4.0 * insideCircle) / tossedPoints;
			System.out.println("approx pi " + approxPi);
		}

	}
}