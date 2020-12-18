package hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarTest {

	private static ArrayList<Car> cars;

    @BeforeAll
    public static void fixture(){

		cars = new ArrayList<Car>();
		Car car1=new Car(2801,1995,200001,"toyota","camry");
		Car car2=new Car(2802,1995,200001,"toyota","camry");
		Car car3=new Car(2800,1996,200001,"toyota","camry");
		Car car4=new Car(2800,1995,200002,"toyota","camry");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
	}

	private String[] carToStringArray(Car car){

		String[] array={car.getMake(),car.getModel(),Integer.toString(car.getYear())};

		return array;
	}

	@Test
	public void VerifyCarEqualityWithMakeModelYear(){
		
		String[] expected={"toyota","camry","1995"};
		Car actual=new Car(2800,1995,200000,"toyota","camry");

		assertArrayEquals(expected,carToStringArray(actual));

		Car car5=new Car(2800,1995,200000,"toyota","camry");

		assertArrayEquals(carToStringArray(car5),carToStringArray(actual));
	}

    @Test
    public void comparingmiles(){

        int[] expected = {200001,200001,200001,200002};

        Collections.sort(cars,new MileageComparator());

        int[] actual = new int[4];

        actual[0]=cars.get(0).getMileage();
        actual[1]=cars.get(1).getMileage();
        actual[2]=cars.get(2).getMileage();
        actual[3]=cars.get(3).getMileage();

        assertArrayEquals(expected,actual);
    }

    @Test
    public void comparingdominations(){

        int[] expected = {0,1,1,2};

		cars.get(0).setdomcount(cars);
		cars.get(1).setdomcount(cars);
		cars.get(2).setdomcount(cars);
		cars.get(3).setdomcount(cars);
        Collections.sort(cars,new ParetoComparator());

        int[] actual = new int[4];

        actual[0]=cars.get(0).getdomcount();
        actual[1]=cars.get(1).getdomcount();
        actual[2]=cars.get(2).getdomcount();
        actual[3]=cars.get(3).getdomcount();

        assertArrayEquals(expected,actual);
    }

    @Test
    public void comparingprice(){

        int[] expected = {2800,2800,2801,2802};

        Collections.sort(cars,new PriceComparator());

        int[] actual = new int[4];

        actual[0]=(int)cars.get(0).getPrice();
        actual[1]=(int)cars.get(1).getPrice();
        actual[2]=(int)cars.get(2).getPrice();
        actual[3]=(int)cars.get(3).getPrice();

        assertArrayEquals(expected,actual);

    }

    @Test
    public void comparingyear(){

        int[] expected = {1996,1995,1995,1995};

        Collections.sort(cars,new PriceComparator());

        int[] actual = new int[4];

        actual[0]=cars.get(0).getYear();
        actual[1]=cars.get(1).getYear();
        actual[2]=cars.get(2).getYear();
        actual[3]=cars.get(3).getYear();

        assertArrayEquals(expected,actual);
    }

}