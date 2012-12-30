package psychoceramics.folderplay;

import java.io.File;
import java.lang.reflect.Array;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Adapter_DirectoryList extends BaseAdapter implements ListAdapter {
	
	private File files[];
	private File current;
	
	public Adapter_DirectoryList(Activity act) {
		super();
		current = new File(""); // get this from preferences
	}
	
	public boolean navigate(File dest) {
		if (dest.isDirectory()) {
			current = dest;
			updateFileList();
			return true;
		}
		return false;
	}

	private void updateFileList() {
		files = current.listFiles();
		notifyDataSetChanged();
	}

	public int getCount() {
		return Array.getLength(files);
	}

	public Object getItem(int i) {
		return files[i];
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getItemViewType(int position) {
		return 0;
	}

	public View getView(int i, View convert, ViewGroup parent) {
		TextView view;
		if (convert != null) {
			view = (TextView) convert;
		}
		else {
			view = new TextView(null);
			view.setGravity(Gravity.CENTER_VERTICAL);
			view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 48));
		}
		view.setText(files[i].getName());
		int draw = R.drawable.folder;
		if (!files[i].isDirectory()) {
			draw = R.drawable.file;
		}
		view.setCompoundDrawablesWithIntrinsicBounds(draw, 0, 0, 0);
		return view;
	}

	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		return Array.getLength(files) == 0;
	}

	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	public boolean areAllItemsEnabled() {
		return true;
	}

	public boolean isEnabled(int arg0) {
		return true;
	}

}
