package hw13o;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import java.util.LinkedList;
//import hw12.fs.*;

public class ObserverTest{

	@Test
	public void equityTest(){
        StockQuoteObservable s = new StockQuoteObservable();
		TableObserver t= new TableObserver();


        s.addObserver(t);
		//add 3 observers

        s.changeQuote("ASDF", 28.69f);

        assertEquals("ASDF", t.tabledisplayticker());
		//test all observers
	}

}