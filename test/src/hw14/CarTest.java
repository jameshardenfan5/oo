package hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    @Test
    public void lambdacomparingmiles(){

        int[] expected = {200000,200001,200009};
        int[] actual = new int[3];
        long count;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2800,1995,200001,"toyota","camry"));
        cars.add(new Car(2800,1995,200009,"toyota","camry"));
        cars.add(new Car(2800,1995,200000,"toyota","camry"));

        Collections.sort(cars,Comparator.comparing((Car car)->car.getMileage()));

        for(count=0;count<cars.size();count++){
            actual[(int)count]=cars.get((int)count).getMileage();
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void lambdacomparingdominations(){

		int[] expected = {0,1,2};
        int[] actual = new int[3];
        long count;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2801,1995,200000,"toyota","camry"));
        cars.add(new Car(2802,1995,200000,"toyota","camry"));
        cars.add(new Car(2800,1996,200000,"toyota","camry"));

        for(count=0;count<cars.size();count++){
            cars.get((int)count).setdomcount(cars);
        }
        Collections.sort(cars,Comparator.comparing((Car car)->car.getdomcount()));
        for(count=0;count<cars.size();count++){
            actual[(int)count]=cars.get((int)count).getdomcount();
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void lambdacomparingprice(){

		float[] expected = {2800,2801,2802};
        float[] actual = new float[3];
        long count;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2801,1995,200000,"toyota","camry"));
        cars.add(new Car(2802,1995,200000,"toyota","camry"));
        cars.add(new Car(2800,1996,200000,"toyota","camry"));

        Collections.sort(cars,Comparator.comparing((Car car)->car.getPrice()));
        for(count=0;count<cars.size();count++){

            actual[(int)count]=cars.get((int)count).getPrice();
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void lambdacomparingyear(){

		int[] expected = {1996,1995,1994};
        int[] actual = new int[3];
        long count;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2801,1994,200000,"toyota","camry"));
        cars.add(new Car(2802,1995,200000,"toyota","camry"));
        cars.add(new Car(2800,1996,200000,"toyota","camry"));

        Collections.sort(cars,Comparator.comparing((Car car)->car.getYear()));
        Collections.reverse(cars);
        for(count=0;count<cars.size();count++){

            actual[(int)count]=cars.get((int)count).getYear();
        }
        assertArrayEquals(expected,actual);
    }
}