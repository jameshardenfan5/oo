package hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Arrays;

public class PrimeGeneratorTest {
    @Test
    public void negativeInputswithTryCatch() {

        try{
            PrimeGenerator gen = new PrimeGenerator(-2, -1);
            fail("Negative inputs");
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=-2 to=-1", ex.getMessage());
        }
    }
    @Test
    public void disorderInputswithTryCatch() {

        try {
            PrimeGenerator gen = new PrimeGenerator(3, 2);
            fail("disorder inputs");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=3 to=2", ex.getMessage());
        }
    }
    @Test
    public void sameInputswithTryCatch() {

        try {
            PrimeGenerator gen = new PrimeGenerator(2, 2);
            fail("same inputs");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=2 to=2", ex.getMessage());
        }
    }
    @Test
    public void generatePrimesEighttoNine() {
        PrimeGenerator gen = new PrimeGenerator(8, 9);
        LinkedList<Long> expected=new LinkedList<Long>();
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        assertEquals(expected, actual);
    }
    @Test
    public void generateThreetoFour() {
        PrimeGenerator gen = new PrimeGenerator(3,4);
        LinkedList<Long> expected= new LinkedList<Long>(Arrays.asList(3L));
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        assertEquals(expected, actual);
    }
    @Test
    public void generatePrimesOnetoTwenty() {
        PrimeGenerator gen = new PrimeGenerator(1, 20);
        LinkedList<Long> expected= new LinkedList<Long>(Arrays.asList(2L,3L,5L,7L,11L,13L,17L,19L));
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        assertEquals(expected, actual);
    }
}
