package de.whs.ni37900.fpr.praktikum.sheet2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class MonthCalender {
    private static final int FIELD_SIZE = 5;

    private final LocalDate today;

    private final Locale locale;

    public MonthCalender() {
        today = LocalDate.now();
        locale = Locale.getDefault();
    }

    public MonthCalender(LocalDate today) {
        this.today = today;
        this.locale = Locale.getDefault();
    }

    public MonthCalender(LocalDate today, Locale locale) {
        this.today = today;
        this.locale = locale;
    }

    public static void main(String[] args) {
        new MonthCalender().print();
    }

    public LocalDate getToday() {
        return today;
    }

    public Locale getLocale() {
        return locale;
    }

    private DayOfWeek getFirstDayOfWeek() {
        return WeekFields.of(locale).getFirstDayOfWeek();
    }

    private LocalDate getFirstDayOfMonth() {
        return getToday().minusDays(getToday().getDayOfMonth() - 1);
    }

    private Month getMonth() {
        return getToday().getMonth();
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(header());
        sb.append("\n");

        int firstDayOfWeek = getFirstDayOfWeek().getValue();
        int firstDayOfMonth = getFirstDayOfMonth().getDayOfWeek().getValue();
        int shiftFirstDay = (7 - firstDayOfWeek + firstDayOfMonth) % 7;
        sb.append(pad("").repeat(shiftFirstDay));

        for (int i = 1; i <= getMonth().length(getToday().isLeapYear()); i++) {
            sb.append(pad("%d%s".formatted(i, getToday().getDayOfMonth() == i ? "*" : "")));

            if ((i + shiftFirstDay) % 7 == 0) sb.append("\n");
        }

        return sb.toString();
    }

    private String header() {
        return "%s%n%s".formatted(monthTitle(), weekdayNames());
    }

    private String monthTitle() {
        String month = "%s %d".formatted(getMonth().getDisplayName(TextStyle.FULL, getLocale()), getToday().getYear());

        return pad(month, DayOfWeek.values().length * FIELD_SIZE);
    }

    private String weekdayNames() {
        StringBuilder sb = new StringBuilder();

        DayOfWeek weekday = getFirstDayOfWeek();
        do {
            sb.append(pad(weekday.getDisplayName(TextStyle.FULL, locale).toUpperCase().substring(0, 3)));
            weekday = weekday.plus(1);
        } while (weekday != getFirstDayOfWeek());

        return sb.toString();
    }

    private String pad(String str) {
        return pad(str, FIELD_SIZE);
    }

    private String pad(String str, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        boolean front = true;

        while (sb.length() < length) {
            if (front) sb.insert(0, " ");
            else sb.append(" ");

            front = !front;
        }

        return sb.substring(0, length);
    }
}