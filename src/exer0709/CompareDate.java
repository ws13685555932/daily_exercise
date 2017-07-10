package exer0709;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;

/**
 * 利用Comparable接口与Comparator接口进行排序
 * Comparabel接口用于内部排序，即在要排序的类实现接口，定义比较大小的方法
 * Comparator接口用于外部排序，在排序过程中new一个比较器，在比较器中定义两个对象比较大小的规则
 * Created by wangsheng on 2017/7/10.
 *
 */

class DateString implements Comparable<DateString> {
    private String mDate;

    public DateString(String date) {
        mDate = date;
    }

    public int getYear() {
        return Integer.valueOf(mDate.substring(0, 4));
    }

    public int getMonth() {
        return Integer.valueOf(mDate.substring(5, 7));
    }

    public int getDay() {
        return Integer.valueOf(mDate.substring(8, 10));
    }

    public String getDate() {
        return mDate;
    }

    @Override
    public int compareTo(DateString date2) {
        if (getYear() == date2.getYear()) {
            if (getMonth() == date2.getMonth()) {
                if (getDay() > date2.getDay()) {
                    return 1;
                } else if (getDay() == date2.getDay()) {
                    return 0;
                } else {
                    return -1;
                }
            } else if (getMonth() > date2.getMonth()) {
                return 1;
            } else {
                return -1;
            }
        } else if (getYear() > date2.getYear()) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class CompareDate {
    public static void main(String[] args) {

        //Comparable
        DateString date1 = new DateString("2016-09-23");
        DateString date2 = new DateString("2017-09-23");
        DateString date3 = new DateString("2016-09-23");

        List<DateString> list = new ArrayList<>();
        list.add(date1);
        list.add(date2);
        list.add(date3);
        Collections.sort(list);



        //Comparator
        DateString[] dateArr = new DateString[]{
                new DateString("1999-06-23"),
                new DateString("2017-09-23"),
                new DateString("2016-09-23")
        };

        Comparator<DateString> comparator = new Comparator<DateString>() {
            @Override
            public int compare(DateString ds1, DateString ds2) {
                if (ds1.getYear() == ds2.getYear()) {
                    if (ds1.getMonth() == ds2.getMonth()) {
                        if (ds1.getDay() > ds2.getDay()) {
                            return 1;
                        } else if (ds1.getDay() == ds2.getDay()) {
                            return 0;
                        } else {
                            return -1;
                        }
                    } else if (ds1.getMonth() > ds2.getMonth()) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (ds1.getYear() > ds2.getYear()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        Arrays.sort(dateArr,comparator);

        for (DateString dateString : dateArr) {
            System.out.println(dateString.getDate());
        }

    }


}
