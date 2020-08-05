package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.sps.data.*;

/** Servlet that Synchronizes the video's state and timestamp */
@WebServlet("/sync-room")
public final class SyncServlet extends HttpServlet {
    private static final String UPDATE_STATE_PARAMETER = "userState";
    private static final String ROOM_ID_PARAMETER = "roomId";
    private static final String VIDEO_TIMESTAMP_PARAMETER = "timeStamp";
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        long roomId = Long.parseLong(req.getParameter(ROOM_ID_PARAMETER));
        Room syncRoom = Room.fromRoomId(roomId);

        if(syncRoom == null || syncRoom.getVideos() == null || syncRoom.getVideos().isEmpty()){
            res.setStatus(410);
            return;
        }
        String responseBody = roomToVideoJson(syncRoom);
        res.setContentType(ServletUtil.JSON_CONTENT_TYPE);
        res.getWriter().println(responseBody);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        long roomId = Long.parseLong(req.getParameter(ROOM_ID_PARAMETER));
        Room syncRoom = Room.fromRoomId(roomId);
        Video.VideoState newState = Video.VideoState.fromInt(Integer.parseInt(req.getParameter(UPDATE_STATE_PARAMETER)));
        long currentVideoTimestamp = Long.parseLong(req.getParameter(VIDEO_TIMESTAMP_PARAMETER));
        updateRoomVideos(syncRoom, newState, currentVideoTimestamp);

        syncRoom.toDatastore();

        res.setStatus(200);
    }

    //Takes a Room in and turns its current video into a JSON String with the necessary attributes
    public static String roomToVideoJson(Room room){
        return ServletUtil.PARSER.toJson(room.getCurrentVideo());
    }

    //Updates the videos the videos queue in the room depending on the newState parameter
    public static void updateRoomVideos(Room room, Video.VideoState newState, long currentVideoTimestamp){
        if(newState == Video.VideoState.ENDED){
            room.changeCurrentVideo();
        } 
        else {
            room.updateCurrentVideoState(newState, currentVideoTimestamp);
        }
    }
}
