package dev.bnayagrawal.prospring5.chapter6.common;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {

    private Long id;
    private Long singerId;
    private String title;
    private Date releaseDate;

    public Album() {}

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", singerId=" + singerId +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public Album(Long id, Long singerId, String title, Date releaseDate) {
        this.id = id;
        this.singerId = singerId;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSingerId() {
        return singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
