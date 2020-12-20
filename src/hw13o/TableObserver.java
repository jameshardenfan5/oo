package hw13o;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer{

	private String stockticker;
	private float djia,quote;

    public void update(Observable o,Object arg){

	    if(arg instanceof StockEvent){

            this.stockticker=((StockEvent)arg).getTicker();
            this.quote=((StockEvent)arg).getQuote();
        }

        else if(arg instanceof DJIAEvent){

			this.djia=((DJIAEvent)arg).getDJIA();
		}
	}

	public String tabledisplayticker(){

		return stockticker;
	}

	public float tabledisplaydjia(){

		return djia;
	}
	public float tabledisplayquote(){

		return quote;
	}
}