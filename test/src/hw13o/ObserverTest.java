package hw13o;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ObserverTest{


	@Test
	public void equityTest(){
        StockQuoteObservable s = new StockQuoteObservable();
		TableObserver t= new TableObserver();
		PieChartObserver p=new PieChartObserver();
		ThreeDimensionObserver d=new ThreeDimensionObserver();

        s.addObserver(t);
        s.addObserver(p);
        s.addObserver(d);
        s.changeQuote("ASDF", 28.69f);
        assertEquals("ASDF", t.tabledisplayticker());
        assertEquals("ASDF", p.piedisplayticker());
        assertEquals("ASDF", d.threedimdisplayticker());
        assertEquals(28.69f, t.tabledisplayquote());
        assertEquals(28.69f, p.piedisplayquote());
        assertEquals(28.69f, d.threedimdisplayquote());
        s.changeQuote("FDSA", 1.695f);
        assertEquals("FDSA", t.tabledisplayticker());
        assertEquals("FDSA", p.piedisplayticker());
        assertEquals("FDSA", d.threedimdisplayticker());
        assertEquals(1.695f, t.tabledisplayquote());
        assertEquals(1.695f, p.piedisplayquote());
        assertEquals(1.695f, d.threedimdisplayquote());
	}
	@Test
	public void dowjonesTest(){
        DJIAQuoteObservable j = new DJIAQuoteObservable();
		TableObserver t= new TableObserver();
		PieChartObserver p=new PieChartObserver();
		ThreeDimensionObserver d=new ThreeDimensionObserver();

        j.addObserver(t);
        j.addObserver(p);
        j.addObserver(d);
        j.changeQuote(29646.4f);
        assertEquals(29646.4f, t.tabledisplaydjia());
        assertEquals(29646.4f, p.piedisplaydjia());
        assertEquals(29646.4f, d.threedimdisplaydjia());
        j.changeQuote(29646.39f);
        assertEquals(29646.39f, t.tabledisplaydjia());
        assertEquals(29646.39f, p.piedisplaydjia());
        assertEquals(29646.39f, d.threedimdisplaydjia());
	}



}
