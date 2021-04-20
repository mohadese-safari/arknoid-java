package model;

import java.util.Objects;

public class Player implements Comparable<Player>{

    private int score;
    private String username;

    public Player(String username) {
        score = 0;
        this.username = username;
    }

    public Player(String username, int score) {
        this.score = score;
        this.username = username;
    }

    public String toString() {
        return username + ":" + score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }  

    @Override
    public int compareTo(Player other) {
        if (this.getScore() > other.getScore()) {
            return 1;
        } else if (this.getScore() < other.getScore()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
       
}
