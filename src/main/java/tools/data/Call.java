package tools.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Call implements Comparable<Call>{
    private int type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String duration;
    private double cost;

    @Override
    public int compareTo(Call o) {
        return this.startTime.compareTo(o.startTime);
    }
}
