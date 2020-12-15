package hw11;

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
    public void comparingmiles(){

        int[] expected = {200000,200001,200009};
        int[] actual = new int[3];
        int i;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2800,1995,200001,"toyota","camry"));
        cars.add(new Car(2800,1995,200009,"toyota","camry"));
        cars.add(new Car(2800,1995,200000,"toyota","camry"));

        Collections.sort(cars,new MileageComparator());

        for(i=0;i<cars.size();i++){

            actual[i]=cars.get(i).getMileage();
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void comparingdominations(){

		int[] expected = {0,1,2};
        int[] actual = new int[3];
        int i;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2801,1995,200000,"toyota","camry"));
        cars.add(new Car(2802,1995,200000,"toyota","camry"));
        cars.add(new Car(2800,1996,200000,"toyota","camry"));

        for(i=0;i<cars.size();i++){

            cars.get(i).setdomcount(cars);
        }
        Collections.sort(cars,new ParetoComparator());
        for(i=0;i<cars.size();i++){

            actual[i]=cars.get(i).getdomcount();
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void comparingprice(){

		float[] expected = {2800,2801,2802};
        float[] actual = new float[3];
        int i;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2801,1995,200000,"toyota","camry"));
        cars.add(new Car(2802,1995,200000,"toyota","camry"));
        cars.add(new Car(2800,1996,200000,"toyota","camry"));

        Collections.sort(cars,new PriceComparator());
        for(i=0;i<cars.size();i++){

            actual[i]=cars.get(i).getPrice();
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void comparingyear(){

		int[] expected = {1996,1995,1994};
        int[] actual = new int[3];
        int i;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2801,1994,200000,"toyota","camry"));
        cars.add(new Car(2802,1995,200000,"toyota","camry"));
        cars.add(new Car(2800,1996,200000,"toyota","camry"));

        Collections.sort(cars,new YearComparator());
        //Collections.reverse(cars);
        for(i=0;i<cars.size();i++){

            actual[i]=cars.get(i).getYear();
        }
        assertArrayEquals(expected,actual);
    }

}