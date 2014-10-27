package ollie;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;

abstract public class OllieAdapter<T extends Model, ViewType extends View> extends CursorAdapter {
	protected Class<T> modelClass;

	public OllieAdapter(Class<T> modelClass, Context context) {
		super(context, null, false);
		this.modelClass = modelClass;
	}

	public abstract void bindView(ViewType itemView, Context context, T item);

	@SuppressWarnings("unchecked")
	@Override
	public void bindView ( View view, Context context, Cursor cursor ) {
		try {
			T instance = modelClass.newInstance();
			instance.load(cursor);
			bindView((ViewType) view, context, instance);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
