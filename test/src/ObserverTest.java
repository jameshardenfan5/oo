package hw13option;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ObserverTest{


	@Test
	public void equityTest(){
        StockQuoteObservable s = new StockQuoteObservable();
		PieChartObserver p=new PieChartObserver();

        s.addObserver(p);
        s.changeQuote("ASDF", 28.69f);
        assertEquals("ASDF", p.piedisplayticker());
        assertEquals(28.69f, p.piedisplayquote());
        s.changeQuote("FDSA", 1.695f);
        assertEquals("FDSA", p.piedisplayticker());
        assertEquals(1.695f, p.piedisplayquote());
	}
	@Test
	public void dowjonesTest(){
        DJIAQuoteObservable j = new DJIAQuoteObservable();
		TableObserver t= new TableObserver();

        j.addObserver(t);
        j.changeQuote(29646.4f);
        assertEquals(29646.4f, t.tabledisplaydjia());
        j.changeQuote(29646.39f);
        assertEquals(29646.39f, t.tabledisplaydjia());
	}



}
