import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SquishTest {
	public static void main(String[] args) throws IOException {
		double[] inputDoubleArray = { -1337.1337, -10.5, -5.5, -1.5, -1, -0.3, -0.113, 0, 0.31,
				0.76, 1.3, 1.99, 7.4, 160, 1337 };

		String[] outputArray = new String[inputDoubleArray.length];

		for (int i = 0; i < inputDoubleArray.length; i++) {
			double a = inputDoubleArray[i];
			String output = "";
			String num;

			// make everything positive
			if (a < 0) {
				num = "" + a * -1;
			} else {
				num = "" + a;
			}

			// make everything to the thousands place (well, the assignment says hundreds
			// place but the input array has to the thousands
			if (a < 10 && a > -10) {
				num = "000" + num;
			} else if (a < 100 && a > -100) {
				num = "00" + num;
			} else if (a < 1000 & a > -1000) {
				num = "0" + num;
			}

			// get rid of the decimal point
			// if its negative, flip the size of the number (0->9, 1->8, ... 9->0)
			for (int index = 0; index < num.length(); index++) {
				if (num.charAt(index) != '.') {
					int currentNum = Integer.parseInt("" + num.charAt(index));
					if (a < 0) {
						output += (9 - currentNum);
					} else {
						output += currentNum;
					}
				}
			}

			// add 0.1 to the front of the negative ones, 0.2 to the front of positive ones
			if (a < 0) {
				output = "0.1" + output;
			} else {
				output = "0.2" + output;
			}

			// add to the outputArray
			outputArray[i] = output;
		}

		PrintWriter writer = new PrintWriter(new FileWriter("outputSquish.txt"));

		for (int i = 0; i < outputArray.length; i++) {
			writer.println("Input: " + inputDoubleArray[i] + " Output: " + outputArray[i]);
		}

		writer.close();
	}
}
