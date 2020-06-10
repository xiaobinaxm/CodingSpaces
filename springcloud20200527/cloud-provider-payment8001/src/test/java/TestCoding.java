import java.time.ZonedDateTime;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/1 10:57
 */
public class TestCoding {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();//默认时区
        System.out.println(now);//2020-06-01T10:58:56.638+08:00[Asia/Shanghai]

    }
}
