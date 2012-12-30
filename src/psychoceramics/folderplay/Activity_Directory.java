package psychoceramics.folderplay;

import java.io.File;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class Activity_Directory extends Activity implements OnItemClickListener, OnItemLongClickListener {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directory);
        
        ListView list = (ListView) findViewById(R.id.DirectoryStructure);
        list.setAdapter(new Adapter_DirectoryList(this));
        list.setOnItemClickListener(this);
        list.setOnItemLongClickListener(this);
        
        ActionBar ab = getActionBar();
    }

	public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
		File f = (File) list.getItemAtPosition(pos);
		Adapter_DirectoryList adapter = (Adapter_DirectoryList) list.getAdapter();
		if (!adapter.navigate(f)) {
			Intent in = new Intent(this, Activity_MPlayer.class);
			in.putExtra("filename", f.getAbsolutePath());
			startActivity(in);
		}
	}

	public boolean onItemLongClick(AdapterView<?> adapter, View view, int pos, long id) {
		// open dialog
		// if it's a directory, allow Opening or Making Home
		// if its a file, open nothing
		return false;
	}
}