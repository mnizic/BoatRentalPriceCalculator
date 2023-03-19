package org.nizic.calculator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<PriceListItem> priceList = readFromCsv("cjenik.csv");
            List<String> quartersList = readQuartersFromCsv("cjenik.csv");
            checkArgs(args);
            printAmount(priceList, quartersList, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static void printAmount(List<PriceListItem> priceList, List<String> quartersList, String[] args) {
        System.out.println("Vessel with ID " + args[0] + " for the departure date '" + args[1] + "' for a duration of " + args[2] + " days.");
        System.out.println("AMOUNT: " + calculateCost(priceList, quartersList, args));
    }

    private static List<String> readQuartersFromCsv(String fileName) {
        List<String> quartersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String row = br.readLine();
            String[] splitQuarters = row.split(",");

            for (String q : splitQuarters) {
                if (!q.equals("")) quartersList.add(q);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return quartersList;
    }

    private static double calculateCost(List<PriceListItem> priceList, List<String> quartersList, String[] args) {
        int id = Integer.parseInt(args[0]);
        Date date = setDate(args[1]);
        int days = Integer.parseInt(args[2]);

        PriceListItem vessel = priceList.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);

        if (vessel == null) {
            System.out.println("ID not found.");
            return 0;
        }

        int quarter = findQuarter(date, quartersList);
        int weeklyPrice = findWeeklyPrice(vessel, quarter);
        double dailyAmount = Double.parseDouble(String.valueOf(weeklyPrice))/7;
        return (double)Math.round(dailyAmount * days * 100)/100;
    }

    private static int findQuarter(Date date, List<String> quartersList) {
        int count = 0;
        for (String quarter : quartersList) {
            count++;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                Date from = dateFormat.parse(quarter.split("-")[0]);
                Date to = dateFormat.parse(quarter.split("-")[1]);
                if (date.compareTo(from) >= 0 && date.compareTo(to) <= 0) {
                    return count;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    private static int findWeeklyPrice(PriceListItem vessel, int quarter) {
        if(quarter == 1) return vessel.getFirstQuarterPrice();
        if(quarter == 2) return vessel.getSecondQuarterPrice();
        if(quarter == 3) return vessel.getThirdQuarterPrice();
        if(quarter == 4) return vessel.getFourthQuarterPrice();
        return 0;
    }

    private static Date setDate(String dateString) {
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            date = dateFormat.parse(dateString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }

    private static List<PriceListItem> readFromCsv(String fileName) throws Exception {
        List<PriceListItem> priceList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String row = "";
            int lineNumber = 0;

            while ((row = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue;
                String[] data = row.split(",");
                if (data.length != 7) continue;
                priceList.add(new PriceListItem(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return priceList;
    }

    private static void checkArgs(String[] args) throws Exception {
        if (args.length != 3) throw new Exception("Incorrect number of args.");
        if (!args[0].matches("\\d+")) throw new Exception("First argument is not a number.");
        if (!args[1].matches("^(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[0-2])\\.(19|20)\\d{2}$"))
            throw new Exception("Second argument has invalid format. (dd.MM.yyyy)");
        if (!args[2].matches("\\d+")) throw new Exception("Third argument is not a number.");
        if (args[0].equals("0")) throw new Exception("ID cannot be 0.");
    }
}