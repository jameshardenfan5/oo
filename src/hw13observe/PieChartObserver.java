package hw13observe;

import java.util.Observable;
import java.util.Observer;

public class PieChartObserver implements Observer{

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

	public String piedisplayticker(){

		return stockticker;
	}

	public float piedisplaydjia(){

		return djia;
	}
	public float piedisplayquote(){

		return quote;
	}
}