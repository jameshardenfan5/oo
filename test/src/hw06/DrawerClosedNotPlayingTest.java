package hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class DrawerClosedNotPlayingTest{

	@Test
	public void SingletonTest(){

		DrawerClosedNotPlaying instance1=DrawerClosedNotPlaying.getInstance();
		DrawerClosedNotPlaying instance2=DrawerClosedNotPlaying.getInstance();

		assertEquals(instance1, instance2);
	}

	@Test
	public void OpenCloseButtonPushedwhileStop(){

		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
		DrawerClosedNotPlaying.getInstance().openCloseButtonPushed();
		assertEquals(DVDPlayer.getInstance().getState(),DrawerOpen.getInstance());
	}

	@Test
	public void testPlayButtonPushedwhileStop(){

		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());
		DrawerClosedNotPlaying.getInstance().playButtonPushed();
		assertEquals(DVDPlayer.getInstance().getState(),DrawerClosedPlaying.getInstance());
	}

	@Test
	public void StopButtonPushedwhileStop(){

		DVDPlayer.getInstance().changeState(DrawerClosedNotPlaying.getInstance());

		final ByteArrayOutputStream outContent=new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		DrawerClosedNotPlaying.getInstance().stopButtonPushed();
		assertEquals("state:stopped",outContent.toString());
	}
}
