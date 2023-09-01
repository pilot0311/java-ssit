package days20;

import java.util.Date;

public class Extest {

    public static void main(String[] args) {
        int year = 2023;
        int month = 8;

        int dayOfWeek = getDayOfWeek(year, month, 1);
        int lastDay = getLastDay(year, month);

        Date d = new Date(year - 1900, month - 1, 1); // 2023.8.1

        int date = d.getDate() - dayOfWeek;
        d.setDate(date);

        System.out.printf("\t\t%d년 %02d월\n", year, month);
        System.out.println("┌─┬─┬─┬─┬─┬─┬─┐");
        System.out.println("│ 일 │ 월 │ 화│ 수│ 목 │ 금 │토 │");
        System.out.println("├────┼────┼────┼───┼────┼────┼───┤");

        for (int week = 0; week < 5; week++) {
            System.out.print("   │");

            for (int i = 0; i < 7; i++) {
                if (d.getMonth() + 1 != month || d.getDate() > lastDay) {
                    System.out.print("  │");
                } else {
                    System.out.printf("%2d│", d.getDate());
                }
                date = d.getDate() + 1;
                d.setDate(date);
            }
            System.out.println();
            if (d.getDate() > lastDay) {
                break;
            }

            System.out.println("├──┼──┼───┼───┼──┼──┼───┤");
        }

        System.out.println("└─┴─┴─┴─┴─┴─┴─┘");
    }

    private static int getLastDay(int year, int month) {
        Date d = new Date(year - 1900, month, 1);
        int date = d.getDate() - 1;
        d.setDate(date);
        return d.getDate();
    }

    private static int getDayOfWeek(int year, int month, int date) {
        Date d = new Date(year - 1900, month - 1, date);
        return d.getDay(); // 0(일)~6(토)
    }
}
