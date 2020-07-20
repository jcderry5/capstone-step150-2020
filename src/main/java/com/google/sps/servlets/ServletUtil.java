package com.google.sps.servlets;
import com.google.gson.Gson;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

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
    //Path to the join room page
    public static final String JOIN_ROOM_PATH = "/views/join-room.html";
    //Path to private room with query for room ID
    public static final String PRIVATE_ROOM_PATH_WITH_QUERY = "/views/private-room.html?roomId=";
    public static final String REDIRECT_ROOM_PATH_WITH_QUERY = "/views/redirect-page.html?id=";
    //The query title for the room id
    public static String INPUTTED_ID_TAG = "roomId";
    //Title of the Room Entity in the datastore
    public static final String ROOM_ENTITY = "Room";
    //Gson parser
    public static final Gson PARSER = new Gson();
    //API key for the Youtube Data API
    public static final String DATA_API_KEY = "AIzaSyA6NypfS8qTc_1O73fx2ZP6JwMZdB_FSas";
    //Base url for youtube embed videos
    public static final String YT_BASE_URL = "https://www.youtube.com/embed/";
    //The query parameter for the Youtube playlist id
    public static final String PLAYLIST_QUERY_PARAMETER = "list=";
    //String reresenting the json content type
    public static final String JSON_CONTENT_TYPE = "application/json";
    //Appengine Uerservice instance
    public static final UserService USER_SERVICE = UserServiceFactory.getUserService();
    //String representing the html content type
    public static final String HTML_CONTENT_TYPE = "text/html";
    //String representing the base Url youtube data api endpoint
    public static final String YT_DATA_API_BASE_URL = "https://www.googleapis.com/youtube/v3/playlistItems?key=";
    //String representing the parameters of the Youtube data api endpoint
    public static final String YT_DATA_API_PARAMETERS = "&part=contentDetails&playlistId=";
}
