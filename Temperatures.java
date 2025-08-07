import java.util.Scanner;
public class Temperatures {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Temperature Converion");
		System.out.println("-----------");
		System.out.print("Enter temperature value:  ");
		double value = scanner.nextDouble();
		System.out.println("Select input unit: ");
		System.out.println(" 1). celsius\n2. Fahrenheit\n3. Kelvin");
		int fromUnit = scanner.nextInt();
		System.out.println("Select output unit: ");
		System.out.println(" 1). celsius\n2. Fahrenheit\n3. Kelvin");
        int toUnit = scanner.nextInt();
         double result = convertTemperature(value, fromUnit, toUnit);
         System.out.printf("Convert temperture: %.2f\n", result);
         
         scanner.close();
	}
	public static double convertTemperature(double value, int from, int to) {
		double tempInCelsius;
	switch(from) {
	case 1:
		tempInCelsius =value;
		break;
	case 2:
		tempInCelsius = (value - 32)*5/9;
		break;
	case 3:
		tempInCelsius = value - 273.15;
		break;
	default:
		throw new IllegalArgumentException("INvalid input unit");
	}
	
	switch(to) {
	case 1:
		return tempInCelsius;
	case 2:
		return (tempInCelsius * 9/5) + 32;
	case 3:
		return tempInCelsius +273.15;
		default:
			throw new IllegalArgumentException("INvalid output unit");
	}
	}

}
