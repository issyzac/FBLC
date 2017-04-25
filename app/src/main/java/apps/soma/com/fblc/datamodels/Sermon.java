package apps.soma.com.fblc.datamodels;

/**
 * Created by issy on 4/24/17.
 */

public class Sermon {

    String sermon_title; //This is the title of the sermon
    String sermon_description; //This is the description of the sermon
    String sermon_youtube_id; //ID of the youtube video of the sermon

    public Sermon(){

    }

    public Sermon(String title, String subtitle){
        this.sermon_title  = title;
        this.sermon_description = subtitle;
    }

    public String getSermon_title() {
        return sermon_title;
    }

    public void setSermon_title(String sermon_title) {
        this.sermon_title = sermon_title;
    }

    public String getSermon_description() {
        return sermon_description;
    }

    public void setSermon_description(String sermon_description) {
        this.sermon_description = sermon_description;
    }

    public String getSermon_youtube_id() {
        return sermon_youtube_id;
    }

    public void setSermon_youtube_id(String sermon_youtube_id) {
        this.sermon_youtube_id = sermon_youtube_id;
    }
}
