import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CloseToBoundaryA {
	public static void main(String[] args) throws IOException {
		double[] inputArray = { 0, 0.000027535691114583473, 0.004070137715896128,
				0.18242552380635635, 0.2689414213699951, 0.425557483188341, 0.47178002201963243,
				0.5, 0.5768852611320463, 0.6813537337890256, 0.7858349830425586, 0.8797431375322491,
				0.9993891206405656, 1, 1 };

		double[] outputArray = new double[inputArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			double a = inputArray[i];
			double output = (-1 * (a - 0.5) * (a - 0.5)) + 0.25;
			outputArray[i] = output;
		}

		PrintWriter writer = new PrintWriter(new FileWriter("outputBoundary.txt"));

		for (int i = 0; i < outputArray.length; i++) {
			writer.println("Input: " + inputArray[i] + " Output: " + outputArray[i]);
		}

		writer.close();
	}
}
