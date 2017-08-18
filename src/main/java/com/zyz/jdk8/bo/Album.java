package com.zyz.jdk8.bo;

import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/8/18
 * Time: 下午3:36
 * To change this template use File | Settings | File Templates.
 */

public class Album {
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
}
