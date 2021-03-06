/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.android.camera.app;

import android.content.Context;


/**
 * A singleton class which provides application level utility
 * classes.
 */
public class AppManagerFactory {

    private static AppManagerFactory sFactory;

    public static synchronized AppManagerFactory getInstance(Context ctx) {
        if (sFactory == null) {
            sFactory = new AppManagerFactory(ctx.getApplicationContext());
        }
        return sFactory;
    }

    private PanoramaStitchingManager mPanoramaStitchingManager;
    private PlaceholderManager mGcamProcessingManager;

    /** No public constructor. */
    private AppManagerFactory(Context ctx) {
        mPanoramaStitchingManager = new PanoramaStitchingManager(ctx);
        mGcamProcessingManager = new PlaceholderManager(ctx);
    }

    public PanoramaStitchingManager getPanoramaStitchingManager() {
        return mPanoramaStitchingManager;
    }

    public PlaceholderManager getGcamProcessingManager() {
        return mGcamProcessingManager;
    }
}
