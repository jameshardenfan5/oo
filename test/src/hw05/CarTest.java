package hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {

	private String[] carToStringArray(Car car){

		String[] array={car.getMake(),car.getModel(),Integer.toString(car.getYear())};

		return array;
	}

	@Test
	public void VerifyCarEqualityWithMakeModelYear(){
		
		String[] expected={"toyota","camry","1995"};
		Car actual=new Car(2800,1995,200000,"toyota","camry");

		assertArrayEquals(expected,carToStringArray(actual));

		Car car2=new Car(2800,1995,200000,"toyota","camry");

		assertArrayEquals(carToStringArray(car2),carToStringArray(actual));
	}
}
