package br.ufba.mata62.eleicoestransparentes;

import android.app.Activity;
import android.content.Intent;
//import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

	//MediaPlayer minhaMusica;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		//minhaMusica = MediaPlayer.create(Splash.this, R.raw.splashsound);
		//minhaMusica.start();
		
		Thread timer = new Thread()
		{

			@Override
			public void run() {
				try
				{
					sleep(3000);
				}
				catch (InterruptedException e)
				{
					e.getStackTrace();
				}
				finally
				{
					Intent abreAtividadeInicio = new Intent("android.intent.action.MENUINICIAL");
					startActivity(abreAtividadeInicio);
				}
			}
			
		};
		
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
		//minhaMusica.stop();
	}
	
	
	
}
