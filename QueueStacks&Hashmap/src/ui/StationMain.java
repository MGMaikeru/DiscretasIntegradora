package ui;
import exception.EmptyFieldException;
import model.Node;
import model.Stack;

import java.util.Scanner;

public class StationMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            Stack<Integer, Integer> stack = new Stack<>();
            int i = 1;
            boolean canOrder = true;

            for (int j = 0; j < n; j++) {
                int coach = scanner.nextInt();

                while (!stack.isEmpty() && stack.getTop2() == coach) {
                    try {
                        stack.pop();
                        i++;
                    } catch (EmptyFieldException e) {
                        e.printStackTrace();
                    }
                    coach = scanner.nextInt();
                }

                if (coach == i) {
                    i++;
                } else if (stack.isEmpty() || stack.getTop2() > coach) {
                    stack.push(new Node<>(coach, coach));
                } else {
                    canOrder = false;
                }
            }

            System.out.println(canOrder ? "Yes" : "No");
            System.out.println();
        }
    }


    public static String isValid(Stack<Integer, Integer> cIn, int[] per) {
        if (cIn.isEmpty())
            return "";
        Stack<Integer, Integer> station = new Stack<>();
        for (int i = 0; i < per.length; i++) {
            while (true) {
                if (!cIn.isEmpty()) {
                    if (station.isEmpty() || station.getTop2() != per[i]) {
                        station.push(cIn.pop2());
                    } else {
                        station.pop2();
                        break;
                    }
                } else if (!station.isEmpty()) {
                    if (station.getTop2() == per[i]) {
                        station.pop2();
                        break;
                    } else {
                        return "NO";
                    }
                }
            }
        }
        return (station.isEmpty() && cIn.isEmpty()) ? "YES":"NO";
    }
}
