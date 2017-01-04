package com.muatik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by mustafaatik on 04/01/17.
 */
@Entity
public class PollOption {

    @Id
    @GeneratedValue
    private long id;

    private long votes;
//
//    @Version
//    private long version;

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long increase() {
        votes++;
        return getVotes();
    }
}
