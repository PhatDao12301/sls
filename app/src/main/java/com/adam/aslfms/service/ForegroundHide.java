/**
 * This file is part of Simple Last.fm Scrobbler.
 * <p/>
 * https://github.com/tgwizard/sls
 * <p/>
 * Copyright 2011 Simple Last.fm Scrobbler Team
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.adam.aslfms.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.adam.aslfms.R;
import com.adam.aslfms.SettingsActivity;

public class ForegroundHide extends Service {

    Context ctx = this;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent i, int flags, int startId) {
        //Bundle extras = i.getExtras();


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(ctx)
                        .setLargeIcon(BitmapFactory.decodeResource(ctx.getResources(),
                                R.mipmap.ic_launcher))
                        .setContentTitle("")
                        .setSmallIcon(R.mipmap.ic_notify)
                        .setContentText("");
        Intent targetIntent = new Intent(ctx, SettingsActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0, targetIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);


        this.startForeground(14619, builder.build());

        this.stopForeground(true);
        return Service.START_NOT_STICKY;
    }
}
