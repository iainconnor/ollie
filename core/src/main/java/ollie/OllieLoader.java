package ollie;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.CursorLoader;
import ollie.query.ResultQuery;

public class OllieLoader extends CursorLoader {
	final ForceLoadContentObserver forceLoadContentObserver;
	ResultQuery query;

	public OllieLoader ( Context context, ResultQuery query ) {
		super(context);
		this.query = query;
		this.forceLoadContentObserver = new ForceLoadContentObserver();
	}

	@Override
	public Cursor loadInBackground () {
		Cursor cursor = query.fetchCursor();

		if ( cursor != null ) {
			cursor.getCount();
			cursor.registerContentObserver(forceLoadContentObserver);
		}

		return cursor;
	}
}
