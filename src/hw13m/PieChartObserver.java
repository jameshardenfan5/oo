package hw13m;

public class PieChartObserver implements DJIAQuoteObserver,StockQuoteObserver{

	private String stockticker;
	private float djia,quote;

    public void updateDJIA(DJIAEvent x){

			this.djia=x.getDJIA();
	}

	public void updateStock(StockEvent y){

        this.stockticker=y.getTicker();
        this.quote=y.getQuote();
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
