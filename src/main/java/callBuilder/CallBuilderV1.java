package callBuilder;

import tools.data.Call;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CallBuilderV1 implements CallBuilder {
    private DateTimeFormatter formatterToLocalDate = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private DateTimeFormatter formatterToStringDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public Call createCall(String[] fields) {
        Call call = new Call();
        call.setType(Integer.parseInt(fields[0]));
        LocalDateTime startTime = toLocalDate(fields[2]);
        LocalDateTime endTime = toLocalDate(fields[3]);
        Duration duration = Duration.between(startTime, endTime);
        call.setStartTime(startTime);
        call.setEndTime(endTime);
        call.setDuration(formatDuration(duration));
        double costPerMinute = getCostPerMinute(Integer.parseInt(fields[4]));
        call.setCost(((duration.getSeconds() / 60) + 1)*costPerMinute);
        return call;
    }

    private LocalDateTime toLocalDate(String time){
        return LocalDateTime.parse(time, formatterToLocalDate);
    }

    private String toStringDate(LocalDateTime time){
        return time.format(formatterToStringDate);
    }

    private String formatDuration(Duration duration){
        long seconds = duration.getSeconds();
        long HH = seconds / 3600;
        long MM = (seconds % 3600) / 60;
        long SS = seconds % 60;
        return String.format("%02d:%02d:%02d", HH, MM, SS);
    }

    private double getCostPerMinute(int tariff){
        switch (tariff){
            case 3 : {return 1.5;}
            case 6 : {return 1;}
            case 11 : {return 1.5;}
            default : {return 0;}
        }
    }
}
