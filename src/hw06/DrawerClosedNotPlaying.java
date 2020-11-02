package hw06;

public class DrawerClosedNotPlaying implements State{

	private DrawerClosedNotPlaying(){

	}

	private static DrawerClosedNotPlaying instance = null;

	public static DrawerClosedNotPlaying getInstance(){

		if(instance==null){
			instance=new DrawerClosedNotPlaying();
		}
		return instance;
	}

	public void openCloseButtonPushed(){

		DVDPlayer.getInstance().open();
		DVDPlayer.getInstance().changeState(DrawerOpen.getInstance());
	}

	public void playButtonPushed(){

		DVDPlayer.getInstance().play();
		DVDPlayer.getInstance().changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed(){

		System.out.print("state:stopped");
	}
}
