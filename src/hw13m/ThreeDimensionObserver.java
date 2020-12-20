package hw13m;

public class ThreeDimensionObserver implements DJIAQuoteObserver,StockQuoteObserver{

	private String stockticker;
	private float djia,quote;

    public void updateDJIA(DJIAEvent x){

			this.djia=((DJIAEvent)x).getDJIA();
	}

	public void updateStock(StockEvent y){

        this.stockticker=((StockEvent)y).getTicker();
        this.quote=((StockEvent)y).getQuote();
	}

	public String threedimdisplayticker(){

		return stockticker;
	}

	public float threedimdisplaydjia(){

		return djia;
	}

	public float threedimdisplayquote(){

		return quote;
	}
}