package com.unique.app.util;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.util <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/16 <br/>
 */
public class DataUtils {


    public static String getPathUrl(Context context, Intent data) {

        String pathUri = null;
        Uri queryUri = data.getData();
        Cursor cursor = context.getContentResolver().query(queryUri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
        if (cursor != null) {

            while (cursor.moveToNext()) {
                pathUri = cursor.getString(0);
            }
            cursor.close();
        }
        return pathUri;
    }

    public static File getPathFile(Context context, Intent data) {
        String pathUrl = getPathUrl(context, data);
        if (pathUrl != null) {
            return new File(getPathUrl(context, data));
        }
        return null;
    }

}
