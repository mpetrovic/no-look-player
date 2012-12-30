package psychoceramics.folderplay;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class Activity_MPlayer extends Activity implements ServiceConnection, GestureDetector.OnGestureListener {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.player);
	}

	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	// we use this to move up or down by folder or song
	// every fling will change the song being played
	// should be relative to 'up' (check gravity for this)
	public boolean onFling(MotionEvent down, MotionEvent up, float velX, float velY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	// we use this to scroll slowly through the list of albums or songs
	// the song will not be changed
	public boolean onScroll(MotionEvent down, MotionEvent move, float distX, float distY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	// quick tap
	// pauses or resumes playback
	public boolean onSingleTapUp(MotionEvent e) {
		Intent in = new Intent(this, Service_MPlayer.class);
		in.putExtra("command", "playback_toggle");
		startService(in);
		return false;
	}

	public void onServiceConnected(ComponentName arg0, IBinder arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onServiceDisconnected(ComponentName arg0) {
		// TODO Auto-generated method stub
		
	}

}
