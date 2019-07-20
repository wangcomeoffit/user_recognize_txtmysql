package user_recognize_txt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static final String TIME="yyyyMMddHHmmss";
    public static String getTimestampDate(String timestamp){
        String str;
        SimpleDateFormat unix_time=new SimpleDateFormat(TIME);
        str=unix_time.format(new Date(Long.valueOf(timestamp+"000")));
        //此处增加"000"是因为Date类中，传入的时间单位为毫秒。
        return str;
    }

    public static void main(String[] args) {
        DateTest dateTest = new DateTest();
        String s = dateTest.getTimestampDate("1491729543");
        System.out.println(s);
    }

}
