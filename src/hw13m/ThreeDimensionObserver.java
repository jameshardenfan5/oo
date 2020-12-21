package hw13m;

public class ThreeDimensionObserver implements DJIAQuoteObserver,StockQuoteObserver{

	private String stockticker;
	private float djia,quote;

    public void updateDJIA(DJIAEvent x){

			this.djia=x.getDJIA();
	}

	public void updateStock(StockEvent y){

        this.stockticker=y.getTicker();
        this.quote=y.getQuote();
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
