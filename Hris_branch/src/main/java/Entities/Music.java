package Entities;

import java.util.ArrayList;

public class Music implements Item {

    private String Artist;
    private Integer Year;
    private String Format;
    private String Genre;
    private String Name;


    public Music(){}


    @Override
    public String getGenre() {
        return Genre;
    }

    @Override
    public String getFormat() {
        return Format;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public Integer getYear() {
        return Year;
    }

    @Override
    public String getArtist() {
        return Artist;
    }

    @Override
    public void setGenre(String genre) {
        this.Genre=genre;
    }

    @Override
    public void setFormat(String format) {
       this.Format=format;
    }

    @Override
    public void setName(String name) {
        this.Name=name;
    }

    @Override
    public void setYear(Integer year) {
       this.Year=year;
    }

    public void setArtist(String artist) {
        this.Artist = artist;
    }

}
