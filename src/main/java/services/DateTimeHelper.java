/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Admin
 */
public class DateTimeHelper {
    //gói java.time
    //Calendar là một lớp trong Java được sử dụng để thao tác với 
    //ngày, tháng, năm và thời gian
    // còn có thể hỗ trợ để thêm, bớt hoặc lấy các thành phần của Date
    // năm, tháng, ngày, giờ, phút, giây
    // để khởi tạo đối tượng Calendar có thể sử dụng phương thức tĩnh getInstance()
    // có thể sử dụng các hằng số được định nghĩa trong Calendar để lấy thông tin
    //phương thức set() dùng để thiết lập Date
    //phương thức add() để thêm hoặc bớt một khoảng thời gian
    //before(), after(), compareTo() so sánh hai đối tượng Calendar
    //để định dạng 1 đối tượng Calendar thành String thông qua lớp SimpleDateFormat
    //để thiết lập múi giờ cho Calendar sử dụng lớp TimeZone

    //getInstance(), set(), add(), before, after, compareTo, SimpleDateFormat, TimeZone

    public static void main(String[] args) throws ParseException {
        Calendar cld = Calendar.getInstance();

        //lấy thời gian cụ thể hiện tại của Calendar
//        System.out.println(cld.getTime());
//        cld.set(cld.YEAR, 2019);
        //year-month-day
        //Hai lưu ý khi set MONTH
        //sử dụng calendar.tháng
        //tháng sẽ bắt đầu từ 0
        //+1
//        cld.set(cld.MONTH, cld.SEPTEMBER);
//        System.out.println(cld.MONTH);
//        System.out.println(cld.getTime());
// khi mà mọi người cho người dùng truyền date vào trang web -> auto truyền vào Servlet
//dưới dạng String. Và mọi người sẽ phải parse về dạng Date 
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy/dd HH:mm:ss");
        System.out.println("Ngay gio hien tai: " + sdf.format(cld.getTime()));

        //thêm 10 ngày vào ngày hiện tại
        cld.add(Calendar.DAY_OF_MONTH, -10);
        System.out.println("Ngay gio hien tai: " + sdf.format(cld.getTime()));

        Calendar cld2 = Calendar.getInstance();
        cld2.set(Calendar.YEAR, 2022);

        //11/10/2022 truoc 11/10/2024
        //before trả về true nếu cld xảy ra trước cld2
        if (cld.before(cld2)) {
            System.out.println("Ngay 11/10/2024 khong truoc ngay 11/10/2022");
        } else {
            System.out.println("Ngay 11/10/2024 truoc ngay 11/10/2022");
        }

        //LocalDate: đại diện cho một Date(ngày-tháng-năm) mà không có Time
        //LocalTime: đại diện cho Time(giờ-phút-giây) mà không có Date
        //LocalDateTime: đại diện cho Date và Time 
        //ZonedDateTime: đại diện cho DateTime có múi giờ
        //Instant: đại diện cho 1 điểm thời gian(timestemp) trong hệ thống Unix thời gian
        //(epoch)
        //Duration: Đo khoảng thời gian theo giờ phút giây
        //Period: đo khoảng thời gian theo ngày tháng năm
        //DateTimeFormatter: định dạng ngày và giờ thành chuỗi và ngược lại

        //khởi tạo LocalTime
        LocalTime startTime = LocalTime.of(10, 30, 0);//10:30 AM
        LocalTime endTime = LocalTime.of(12, 45, 30);//12:45:30 AM
        //Tính toán Duration giữa 2 thời gian
        Duration dr = Duration.between(startTime, endTime);
        //Hiển thị khoảng thời gian 
        System.out.println(dr);
        //lấy giờ, phút, giây từ Duration
        long hour = dr.toHours();
        long minute = dr.toMinutes() % 60;
        long second = dr.toSecondsPart();
        System.out.println(minute);
        System.out.println(second);
        //sử dụng DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yyyy/dd HH:mm:ss");

        //Tạo LocalDate và LocalTime
        LocalDate ld = LocalDate.of(2024, 12, 25);  //25/12/2024
        LocalTime lt = LocalTime.of(21, 45, 0); //21:45:00 PM
        //Tạo LocalDateTime
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        //Áp dụng DateTimeFormatter vào LocalDateTime
        String dateTimeFormat = ldt.format(dtf);
        System.out.println(dateTimeFormat);

        //so sánh hai LocalDateTime
        LocalDateTime ldt2 = LocalDateTime.of(ld, startTime);

        if (ldt.isBefore(ldt2)) {
            System.out.println("9 giờ 45 phút tối xảy ra trước 10 giờ 30 phút sáng");

        } else {
            System.out.println("9 giờ 45 phút tối xảy ra sau 10 giờ 30 phút sáng");
        }

        //in ra Thứ trong tuần sử dụng phương thức getDayNameOfWeek
        //int a = Calendar.DAY_OF_WEEK;
        //Tạo đối tượng Date với thời gian hiện tại
        Date a = new Date();
        String b = getDayNameOfWeek(a);
        System.out.println(b);

        //java.util.Date : biểu thị thời gian chung trong Java, phù hợp cho các
        //tác vụ xử lý thời gian không sử dụng database
        //nó lưu trữ cả ngày và thời gian
        //Date: Ngày\tháng\năm
        //Time: Giờ\phút\giây
        //java.sql.Date : Được thiết kế để làm việc với SQL(database)
        //chỉ lưu Date, không lưu time
        //Time mặc định: 00:00:00
    }

    //Lấy ra thứ trong tuần
    public static String getDayNameOfWeek(Date a) {
        Calendar calendar = Calendar.getInstance();
        //Nếu truyền vào java.util.Date thì sử dụng thêm 2 lệnh dưới
        calendar.setTime(a);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

//        Trong Calendar, các ngày trong tuần được đánh số từ 1 đến 7, với:
//1: Chủ Nhật 
//2: Thứ Hai 
//3: Thứ Ba 
//4: Thứ Tư 
//5: Thứ Năm 
//6: Thứ Sáu 
//7: Thứ Bảy 
//Nên phải sử dụng cẩn thận với điều kiện switch case vì còn lệch múi giờ và quy ước
//của quốc gia định nghĩa thứ 
//Bài Tập thêm: Yêu cầu xây dựng lại phương thức getDayNameOfWeek sao cho điều kiện chuẩn nhất
//với mọi trường hợp. 
        switch (dayOfWeek) {
            case 1:
                return "Thu Hai";
            case 2:
                return "Thu Ba";
            case 3:
                return "Thu Tu";
            case 4:
                return "Thu Nam";
            case 5:
                return "Thu Sau";
            case 6:
                return "Thu Bay";
            case 7:
                return "Chu Nhat";
        }
        return "Loi lay thu trong tuan";
    }


    //Một số phương thức thêm khi làm việc với DateTime
    //Biến String thành Date
    public static Date toDate(String value, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(value);
    }

    //Reset Time
    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    //Chuyển đổi từ sqlDate thành utilDate
    public static Date toDateUtil(java.sql.Date d) {
        Date x = new Date(d.getTime());
        x = removeTime(x);
        return x;
    }

    //Chuyển đổi từ utilDate thành sqlDate
    public static java.sql.Date toDateSql(Date d) {
        d = removeTime(d);
        return new java.sql.Date(d.getTime());
    }

    // trả về ngày trong tuần (theo dạng số) của đối tượng Date được truyền vào
    public static int getDayofWeek(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    //Phương thức này cộng thêm một số ngày nhất định (days) vào ngày ban đầu (d) và trả về đối tượng Date mới sau khi đã cộng ngày.
    public static Date addDays(Date d, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    //Phương thức này tạo danh sách các ngày trong khoảng thời gian từ ngày bắt đầu(from) đến ngày kết thúc (to), và trả về một danh sách các đối tượng java.sql.Date.
    public static ArrayList<java.sql.Date>
    getDateList(java.sql.Date from, java.sql.Date to) {
        ArrayList<java.sql.Date> dates = new ArrayList<>();
        int days = 0;
        Date e_from = toDateUtil(from);
        Date e_to = toDateUtil(to);
        while (true) {
            Date d = DateTimeHelper.addDays(e_from, days);
            dates.add(toDateSql(d));
            days++;
            if (d.compareTo(e_to) >= 0) {
                break;
            }
        }
        return dates;
    }

    //Phương thức này so sánh hai ngày a và b theo kiểu java.sql.Date, và trả về kết quả so sánh.
    //0 nếu hai ngày bằng nhau,
    //-1 nếu e_a nhỏ hơn e_b,
    //1 nếu e_a lớn hơn e_b.
    public static int compare(java.sql.Date a, java.sql.Date b) {

        Date e_a = toDateUtil(a);
        Date e_b = toDateUtil(b);
        System.out.println(a + " " + b + " " + e_a.compareTo(e_b));
        return e_a.compareTo(e_b);
    }

    //Phương thức này tính toán số ngày từ một ngày cụ thể (d) đến ngày hiện tại.
    //Bằng phương pháp logic thông thường, không dùng hàm có sẵn
    public static float getDaystoCurrent(java.sql.Date d) {
        Date e = new Date(d.getTime());
        Date current = new Date();
        long diff = current.getTime() - e.getTime();
        return ((float) diff / (1000 * 60 * 60 * 24));
    }

    // Kiểm tra nếu thời gian cần kiểm tra (target) nằm giữa thời gian start và end
    public static boolean isBetweenTime(LocalDateTime target, LocalDateTime start, LocalDateTime end) {
        return (target.isAfter(start) || target.isEqual(start)) &&
                (target.isBefore(end) || target.isEqual(end));
    }
}
