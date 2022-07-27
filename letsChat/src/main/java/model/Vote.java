package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vote {

    private int voteAbleId;
    private boolean isVote;
    private String userName;

    public Vote() {

    }


    public Vote(int voteAbleId, boolean isVote, String userName) {
        this.voteAbleId = voteAbleId;
        this.isVote = isVote;
        this.userName = userName;
    }

    public int getVoteAbleId() {
        return voteAbleId;
    }

    public void setVoteAbleId(int voteAbleId) {
        this.voteAbleId = voteAbleId;
    }

    public boolean isVote() {
        return isVote;
    }

    public void setVote(boolean vote) {
        isVote = vote;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
