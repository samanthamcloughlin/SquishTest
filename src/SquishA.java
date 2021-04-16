import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SquishA {
	public static void main(String[] args) throws IOException {
		double[] inputArray = { -1337.1337, -10.5, -5.5, -1.5, -1, -0.3, -0.113, 0, 0.31,
				0.76, 1.3, 1.99, 7.4, 160, 1337 };

		double[] outputArray = new double[inputArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			double a = inputArray[i];
			double output = (Math.atan(a)/(Math.PI)) + 0.5;
			outputArray[i] = output;
		}

		PrintWriter writer = new PrintWriter(new FileWriter("outputSquish.txt"));

		for (int i = 0; i < outputArray.length; i++) {
			writer.println("Input: " + inputArray[i] + " Output: " + outputArray[i]);
		}

		writer.close();
	}
}
