package tools.data;

import java.time.LocalDateTime;

public class Call implements Comparable<Call>{
    private int type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String duration;
    private double cost;

    public int getType() {
        return type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDuration() {
        return duration;
    }

    public double getCost() {
        return cost;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Call o) {
        return this.startTime.compareTo(o.startTime);
    }
}
