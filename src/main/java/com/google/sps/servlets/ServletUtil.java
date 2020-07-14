package com.google.sps.servlets;
import com.google.gson.Gson;

// Util File for Servlet that defines final entities for youtube party
public class ServletUtil {
    public static final Gson PARSER = new Gson();
    public static enum video_state {
        UNSTARTED(-1), ENDED(0), PLAYING(1), PAUSED(2), BUFFERING(3), CUED(5);
        private int value;
        private video_state(int value){
            this.value = value;
        }
    }
    public static final String DATA_API_KEY = "AIzaSyA6NypfS8qTc_1O73fx2ZP6JwMZdB_FSas";
    public static final String YT_BASE_URL = "https://www.youtube.com/embed/";
    public static final String PLAYLIST_QUERY_PARAMETER = "list=";
    public static final String PRIVATE_ROOM_PATH = "/views/private-room.html";
}