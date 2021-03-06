package Client;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by parsahejabi on 6/21/17.
 */
public class Post implements Comparable,Serializable {
    static public final String POST_NAME = "Post";
    Profile owner;
    Date uploadDate;
    File image;
    ArrayList<Profile> liked;
    ArrayList<Comment> comments;
    String caption;
    boolean canComment;

    @Override
    public int compareTo(Object o) {
        return uploadDate.compareTo(((Post) o).uploadDate);
    }

    Post(Profile owner, File image, String  caption, boolean canComment)
    {
        this.uploadDate = new Date(System.currentTimeMillis());
        this.owner = owner;
        liked = new ArrayList<>();
        this.canComment = canComment;
        if(canComment)
            comments = new ArrayList<>();
        else
            comments = new ArrayList<>(0);
        this.image = image;
        this.caption = caption;
    }

}
