package com.allstate.entities;

import com.allstate.enums.Action;
import com.allstate.enums.Result;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    private int id;
    private int version;
    private User user;
    private Action action;
    private Result result;
    private int userPoints;
    private String userCards;
    private int dealerPoints;
    private String dealerCards;
    private int bet;
    private Date created;
    private Date modified;

    public Transaction() {
    }
    public Transaction(Action action, String userCards,String dealerCards,int userPoints, int dealerPoints, int bet, User user) {
        this.action = action;
        this.userCards = userCards;
        this.dealerCards = dealerCards;
        this.userPoints = userPoints;
        this.dealerPoints = dealerPoints;
        this.bet = bet;
        this.user = user;
    }

    @Id
    @GeneratedValue
    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    @Version
    public int getVersion() { return version; }
    public void setVersion(int version) {
        this.version = version;
    }

    @Enumerated(EnumType.STRING)
    public Action getAction() {
        return action;
    }
    public void setAction(Action action) {
        this.action = action;
    }

    @Enumerated(EnumType.STRING)
    public Result getResult() {
        return result;
    }
    public void setResult(Result result) {
        this.result = result;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
