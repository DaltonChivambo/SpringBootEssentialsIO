package dvx.company.springboot.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component //return string, another annotation is @service
//We need enable annotation processors, on settings, and add plugin lombok
public class DateUtil {
    public String formatLocalDateToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
