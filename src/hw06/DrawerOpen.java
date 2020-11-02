package hw06;

public class DrawerOpen implements State{

	private DrawerOpen(){

	}

	private static DrawerOpen instance=null;

	public static DrawerOpen getInstance(){

		if(instance==null)
			instance=new DrawerOpen();
		return instance;
	}

	public void openCloseButtonPushed(){

		DVDPlayer.getInstance().close();
		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
	}

	public void playButtonPushed(){

		DVDPlayer.getInstance().close();
		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
		DVDPlayer.getInstance().play();
		DVDPlayer.getInstance().changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed(){

		System.out.print("state:open");
	}
}
