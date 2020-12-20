package hw13m;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import java.util.LinkedList;
//import hw12.fs.*;

public class MulticastTest{

	@Test
	public void equityTest(){

        StockQuoteObservable s = new StockQuoteObservable();
		TableObserver t= new TableObserver();
		//StockEvent e=new StockEvent("ASDF", 18.69f);


        s.addObserver(t);
		//add 3 observers

        s.notifyObservers(new StockEvent("ASDF", 18.69f));

        assertEquals("ASDF", t.tabledisplayticker());
		//test all observers
	}

}