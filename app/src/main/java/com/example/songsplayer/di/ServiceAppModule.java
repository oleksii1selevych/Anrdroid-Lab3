package com.example.songsplayer.di;


import android.content.Context;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.android.scopes.ServiceScoped;
import com.example.songsplayer.data.remote.MusicDatabase;

@Module
@InstallIn(ServiceComponent.class)
public final class ServiceAppModule {

    @ServiceScoped
    @Provides
    public static MusicDatabase provideMusicDatabase(@ApplicationContext Context context){
        return new MusicDatabase(context);
    }

    @ServiceScoped
    @Provides
    public static AudioAttributes provideAudioAttributes(){
       return new AudioAttributes.Builder().setContentType(C.CONTENT_TYPE_MUSIC).setUsage(C.USAGE_MEDIA).build();
    }

    @ServiceScoped
    @Provides
    public static SimpleExoPlayer provideExoPlayer(@ApplicationContext Context context, AudioAttributes audioAttributes){
        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer.Builder(context).build();
        simpleExoPlayer.setAudioAttributes(audioAttributes, true);
        simpleExoPlayer.setHandleAudioBecomingNoisy(true);
        return simpleExoPlayer;
    }

    @ServiceScoped
    @Provides
    public static DefaultDataSourceFactory provideDataSourceFactory(@ApplicationContext Context context){
        return new DefaultDataSourceFactory(context, Util.getUserAgent(context, "lab3"));
    }
}
