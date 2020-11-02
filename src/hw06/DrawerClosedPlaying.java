package hw06;

public class DrawerClosedPlaying implements State{

	private DrawerClosedPlaying(){

	}

	private static DrawerClosedPlaying instance=null;

	public static DrawerClosedPlaying getInstance(){

		if(instance==null)
			instance=new DrawerClosedPlaying();
		return instance;
	}

	public void openCloseButtonPushed(){

		DVDPlayer.getInstance().stop();
		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
		DVDPlayer.getInstance().open();
		DVDPlayer.getInstance().changeState(DrawerOpen.getInstance());
	}

	public void playButtonPushed(){

		System.out.print("state:playing");
	}

	public void stopButtonPushed(){

		DVDPlayer.getInstance().stop();
		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
	}
}