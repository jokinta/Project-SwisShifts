import java.io.*;
import java.lang.invoke.CallSite;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.util.TimeZone.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Shift> monthShifts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice: \nConvert your shifts-1\nSeacrh for shift-2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Date date = new Date();
                double monthHours = 0;
                System.out.print("Enter the name:");
                String name = scanner.nextLine();
                System.out.print("Enther the month:");
                int month = Integer.parseInt(scanner.nextLine());
                System.out.print("Enther the year:");
                int year = Integer.parseInt(scanner.nextLine());
                SimpleDateFormat sdf = new SimpleDateFormat("E dd.MM.yyyy");
                Calendar cal = new GregorianCalendar(year, month - 1, 1);
                System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {


                    System.out.printf("Enter shift for: %s ", sdf.format(cal.getTime()));
                    String shiftForSearch = scanner.nextLine();
                    String currentLine;
                    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Jokinta\\IdeaProjects\\Swissport\\src\\Shifts"));
                    while ((currentLine = reader.readLine()) != null) {
                        Shift shift = null;
                        String[] parts;
                        parts = currentLine.split(" ");
                        if (parts[0].equals(shiftForSearch)) {
                            shift = new Shift(parts[0], parts[1], parseDouble(parts[2]), parseDouble(parts[3]));
                            monthShifts.put(i, shift);
                            monthHours += shift.getWorkTime();
                        } else if ("*".equals(shiftForSearch) || "O".equals(shiftForSearch)) {
                            shift = new Shift(shiftForSearch);
                            monthShifts.put(i, shift);
                        }

                    }
                    cal.add(Calendar.DAY_OF_MONTH, 1);

                }
                cal.set(year, month - 1, 1);
                FileWriter fileWriter = new FileWriter(name + "." + month + "." + year);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {

                    System.out.print(sdf.format(cal.getTime()));
                    System.out.print("==");
                    System.out.println((Shift) monthShifts.get(i));
                    System.out.println("========================================================================================");
                    printWriter.print(sdf.format(cal.getTime()));
                    printWriter.print("||");
                    printWriter.println((Shift) monthShifts.get(i));
                    printWriter.println("========================================================================================");

                    cal.add(Calendar.DAY_OF_MONTH, 1);

                }
                printWriter.printf("This month you have %.1f working hours", monthHours);

                printWriter.close();

                System.out.printf("This month you have %.1f working hours", monthHours);
                break;
            case 2:
                System.out.print("Enter shift for search:");
                String shiftForSearch = scanner.next();
                String currentLine;
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Jokinta\\IdeaProjects\\Swissport\\src\\Shifts"));
                while ((currentLine = reader.readLine()) != null) {
                    Shift shift = null;
                    String[] parts;
                    parts = currentLine.split(" ");
                    if (parts[0].equals(shiftForSearch)) {
                        shift = new Shift(parts[0], parts[1],parseDouble(parts[2]),parseDouble(parts[3]));
                        System.out.println(shift);
                    }
                }

        }

    }
}