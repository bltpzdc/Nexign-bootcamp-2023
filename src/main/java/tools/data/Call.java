package tools.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Call {
    private int type;
    private String startTime;
    private String endTime;
    private String duration;
    private double cost;
}
