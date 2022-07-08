package com.example.songsplayer.exoplayer.callbacks;

import android.support.v4.media.MediaMetadataCompat;

public interface PlayerPrepared {
    void callback(MediaMetadataCompat itemToPlay);
}
