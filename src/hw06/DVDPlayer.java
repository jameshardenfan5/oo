package hw06;

public class DVDPlayer{

	private State state;
	private static DVDPlayer instance = null;

	private DVDPlayer() {

		state=DrawerClosedNotPlaying.getInstance();
	}
	
	public static DVDPlayer getInstance(){

		if(instance==null)
			instance=new DVDPlayer();
		return instance;
	}

	public void changeState(State state){

		this.state=state;
	}

	public State getState(){

		return state;
	}

	public void openCloseButtonPushed(){

		state.openCloseButtonPushed();
	}

	public void playButtonPushed(){

		state.playButtonPushed();
	}

	public void stopButtonPushed(){

		state.stopButtonPushed();
	}

	public void open(){

		System.out.println("action:open");
	}

	public void close(){

		System.out.println("action:close");
	}

	public void play(){

		System.out.println("action:play");
	}

	public void stop(){

		System.out.println("action:stop");
	}
}
