package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@XmlRootElement
public class VoteAble {

    private int voteAbleId;
    private Timestamp timeCreated;
    private Timestamp timeUpdated;
    private int likeCount;


    public VoteAble() {

    }

    public VoteAble(int voteAbleId, Timestamp timeCreated, Timestamp timeUpdated, int likeCount) {
        this.voteAbleId = voteAbleId;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
        this.likeCount = likeCount;
    }


    public int getVoteAbleId() {
        return voteAbleId;
    }

    public void setVoteAbleId(int voteAbleId) {
        this.voteAbleId = voteAbleId;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Timestamp timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
