package com.example.songsplayer.di;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import com.example.songsplayer.R;
import com.example.songsplayer.adapters.SwipeSongAdapter;
import com.example.songsplayer.exoplayer.MusicServiceManager;
import com.google.android.datatransport.runtime.dagger.Provides;

@Module
@InstallIn(SingletonComponent.class)
public final class MainAppModule {

    @Singleton
    @Provides
    public static MusicServiceManager provideMusicServiceConnection(@ApplicationContext Context context){
        return new MusicServiceManager(context);
    }

    @Singleton
    @Provides
    public static SwipeSongAdapter provideSwipeSongAdapter(){
        return new SwipeSongAdapter();
    }

    @Singleton
    @Provides
    public static RequestManager provideGlideInstance(@ApplicationContext Context context){
        return Glide.with(context).setDefaultRequestOptions(
                new RequestOptions().placeholder(R.drawable.default_music_icon)
                .error(R.drawable.ic_baseline_alarm_24)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        );
    }
}
