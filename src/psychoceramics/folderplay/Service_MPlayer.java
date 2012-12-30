package psychoceramics.folderplay;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.*;

public class Service_MPlayer extends IntentService implements MediaPlayer.OnErrorListener {
	
	private MediaPlayer player;

	public Service_MPlayer(String name) {
		super(name);
	}

	public boolean onError(MediaPlayer mp, int what, int extra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void onHandleIntent(Intent in) {
		// TODO Auto-generated method stub
		
	}

}
