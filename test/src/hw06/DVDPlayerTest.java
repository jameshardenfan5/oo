package hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DVDPlayerTest{

	@Test
	public void SingletonTest(){

		DVDPlayer instance1=DVDPlayer.getInstance();
		DVDPlayer instance2=DVDPlayer.getInstance();
		assertEquals(instance1, instance2);
	}

	@Test
	public void openCloseButtonPushedwhileclose(){

		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
		DVDPlayer.getInstance().openCloseButtonPushed();
		assertEquals(DVDPlayer.getInstance().getState(),DrawerOpen.getInstance());
	}

	@Test
	public void PlayButtonPushedwhileClose(){

		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
		DVDPlayer.getInstance().playButtonPushed();
		assertEquals(DVDPlayer.getInstance().getState(),DrawerClosedPlaying.getInstance());
	}

	@Test
	public void StopButtonPushedwhilePlaying(){

		DVDPlayer.getInstance().changeState(DrawerClosedPlaying.getInstance());
		DVDPlayer.getInstance().stopButtonPushed();
		assertEquals(DVDPlayer.getInstance().getState(),DrawerClosedNotPlaying.getInstance());
	}
}