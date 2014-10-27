/*
 * Copyright (C) 2014 Michael Pardo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ollie.query;

import android.database.Cursor;
import ollie.Model;
import rx.Observable;

import java.util.List;

public interface ResultQuery extends ExecutableQuery {
	<T extends Model> List<T> fetch();

	<T extends Model> T fetchSingle();

	<T> T fetchValue(Class<T> type);

	<T extends Model> Observable<List<T>> observable();

	<T extends Model> Observable<T> observableSingle();

	<T> Observable<T> observableValue(Class<T> type);

	Cursor fetchCursor();
}
