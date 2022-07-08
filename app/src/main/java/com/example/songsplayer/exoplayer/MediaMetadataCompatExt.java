package com.example.songsplayer.exoplayer;

import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;

import com.example.songsplayer.data.entities.Song;

public class MediaMetadataCompatExt {
    public static Song toSong(MediaMetadataCompat value) {
        MediaDescriptionCompat compDesc = value.getDescription();
        if(compDesc.getMediaId() == null){
            return null;
        }
        return new Song(compDesc.getMediaId() == null ? "" : compDesc.getMediaId(),
                compDesc.getTitle().toString(),
                compDesc.getSubtitle().toString(),
                compDesc.getMediaUri().toString(),
                compDesc.getIconUri().toString());
    }
}
