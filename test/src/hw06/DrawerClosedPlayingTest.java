package hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DrawerClosedPlayingTest{

	@Test
	public void SingletonTest(){

		DrawerClosedPlaying instance1=DrawerClosedPlaying.getInstance();
		DrawerClosedPlaying instance2=DrawerClosedPlaying.getInstance();

		assertEquals(instance1, instance2);
	}

	@Test
	public void OpenCloseButtonPushedwhileplaying(){

		DVDPlayer.getInstance().changeState(DrawerClosedPlaying.getInstance());
		DrawerClosedNotPlaying.getInstance().openCloseButtonPushed();
		assertEquals(DVDPlayer.getInstance().getState(),DrawerOpen.getInstance());
	}

	@Test
	public void PlayButtonPushedwhilePlaying(){

		DVDPlayer.getInstance().changeState(DrawerClosedPlaying.getInstance());

		final ByteArrayOutputStream outContent=new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		DrawerClosedPlaying.getInstance().playButtonPushed();
		assertEquals("state:playing",outContent.toString());
	}

	@Test
	public void StopButtonPushedwhilePlaying(){

		DVDPlayer.getInstance().changeState(DrawerClosedPlaying.getInstance());
		DrawerClosedPlaying.getInstance().stopButtonPushed();
		assertEquals(DVDPlayer.getInstance().getState(),DrawerClosedNotPlaying.getInstance());
	}
}
