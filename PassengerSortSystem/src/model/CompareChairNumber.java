package model;

import java.net.PasswordAuthentication;
import java.util.Comparator;

public class CompareChairNumber implements Comparator<Passenger> {

    @Override
    public int compare(Passenger o1, Passenger o2) {

        int o1ColumnDistance = distanceHall(o1.getColumn());
        int o2ColumnDistance = distanceHall(o2.getColumn());


        int comparator = Integer.compare(o2ColumnDistance,o1ColumnDistance) + o2.getRow().compareTo(o1.getRow());

        return comparator;

        /*if (o1.getColumn().equals(o2.getColumn())) {
            return o1.getRow().compareTo(o2.getRow());
        } else {
            int o1ColumnDistance = distanceHall(o1.getColumn());
            int o2ColumnDistance = distanceHall(o2.getColumn());
            return Integer.compare(o1ColumnDistance,o2ColumnDistance);
        }*/
    }

    private int distanceHall(String column) {
        switch (column) {
            case "C":
                return 0;
            case "D":
                return 2;
            case "B":
                return 4;
            case "E":
                return 6;
            case "A":
                return 8;
            case "F":
                return 10;
            default:
                return -1;
        }
    }
}
