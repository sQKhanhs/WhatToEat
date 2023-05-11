package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SearchByPrice implements Search {
    private ArrayList<String[]> priceList = new ArrayList<>();

    @Override
    public void search(String dishName) {
        try {
            File file = new File("C:\\Users\\Public\\Documents\\Restaurant\\");
            String[] fileList = file.list();
            for (String restaurantUser : fileList) {
                String[] restaurantPrice = new String[3];
                ArrayList<Integer> priceCompare = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\Restaurant\\"
                        + restaurantUser + "\\" + "information.txt"));
                String line = bufferedReader.readLine();
                String[] dishNameRead = line.split(":");
                bufferedReader.readLine();
                if (dishNameRead[1].equalsIgnoreCase(" " + dishName)) {
                    String restaurantName = bufferedReader.readLine();
                    restaurantPrice[1] = restaurantName;
                    String restaurantAddress = bufferedReader.readLine();
                    restaurantPrice[2] = restaurantAddress;
                    String oderLine;
                    bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Public\\Documents\\Restaurant\\"
                            + restaurantUser + "\\" + "menu.txt"));
                    while ((oderLine = bufferedReader.readLine()) != null) {
                        if (oderLine.endsWith("VND")) {
                            String[] price = oderLine.split(" ");
                            int priceNumber = Integer.parseInt(price[0]);
                            priceCompare.add(priceNumber);
                        }
                    }
                    Collections.sort(priceCompare);
                    restaurantPrice[0] = Integer.toString(priceCompare.get(0));
                    priceList.add(restaurantPrice);
                }
            }
            Collections.sort(priceList, new PriceComparator());
            for (String[] restaurant : priceList) {
                System.out.println(restaurant[1]);
                System.out.println(restaurant[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
