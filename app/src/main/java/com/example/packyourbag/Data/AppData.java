package com.example.packyourbag.Data;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.packyourbag.Constants.MyConstants;
import com.example.packyourbag.Database.RoomDB;
import com.example.packyourbag.Models.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {

    RoomDB database;
    String category;
    Context context;

    public static final String LAST_VERSION ="Last Version";
    public static final int NEW_VERSION =1;

    public AppData(RoomDB database) {
        this.database = database;
    }

    public AppData(RoomDB database, Context context) {
        this.database = database;
        this.context = context;
    }

    public List<Items> getBasicData()
    {
     category ="Basic Needs";
     List<Items>basicItem =new ArrayList<Items>();
     basicItem.clear();
     basicItem.add(new Items("Visa",category,false));
     basicItem.add(new Items("Passport",category,false));
     basicItem.add(new Items("Tickets",category,false));
     basicItem.add(new Items("Wallet",category,false));
     basicItem.add(new Items("Driving License",category,false));
     basicItem.add(new Items("Currency",category,false));
     basicItem.add(new Items("House Key",category,false));
     basicItem.add(new Items("Book",category,false));
     basicItem.add(new Items("Travel Pillow",category,false));
     basicItem.add(new Items("Eye Patch",category,false));
     basicItem.add(new Items("Umbrella",category,false));
     basicItem.add(new Items("Note Book",category,false));
     return basicItem;
    }



    public List<Items> getPersonalCareData(){
        String[] data = {"Tooth-brush", "Floss", "Mouthwash","Shaving Cream","Razor Blade",
        "Soap","Fiber","Shampoo","Hair conditioner","Brush","Comb","Hair Dryer","Curling Iron",
        "Hair Moulder","Hair clip","Moisturizer","Lip cream","Contact Lens","Perfume",
        "Deodorant","Makeup Material","Makeup Remover","Wet wipes","Pad","Eat stick","Cotton",
       "Nail polish","Nail polish remover","Tweezers","Nail Scissors","Nail Files","Suntan Cream"};
       return prepareItemsList(MyConstants.PERSONAL_CARE_CAMEL_CASE,data);
    }
    public List<Items> getClothingData(){
        String[] data = {"Stockings", "Underwear", "Pajamas","T-shirt","Casual Dress",
                "Evening Dress","Shirt","Cardigan","Vest","Jacket","Skirt","Trousers","Jeans",
                "Shorts","Suit","Coat","Rain coat","Glove","Hat",
                "Scarf","Bikini","Belt","Slipper","Sneakers","Casual Shoes","Heeled Shoes",
                "Sports Wear"};
        return prepareItemsList(MyConstants.CLOTHING_CAMEL_CASE,data);
    }

    public List<Items> getBabyNeedsData(){
        String[] data = {"Snap suit", "Outfit", "Jumpsuit","Baby Socks","Baby Hat",
                "Baby Pyjamas","Baby Bath towel","Muslin","Blanket","Dribble Bibs","Baby Laundry Detergent",
                "Baby Bottles","Baby Food Thermos", "Baby Bottle Brushes","Breast-Feeding Cover",
                "Breast Pump","Water Bottle","Storage Container", "Baby Food Spoon","Baby Soap",
                 " Baby Carrier","Toys","Tether","Playpen" };
        return prepareItemsList(MyConstants.BABY_NEEDS_CAMEL_CASE,data);
    }


    public List<Items> getHealthData(){
        String[] data = {"Aspirin", "Drugs used", "Vitamins Used","Lens Solution","Condom",
                "Hot Water Bag","Tincture of Iodine","Adhesive Plaster","First Aid Kit",
                "Replacement Lens","Pain Reliever", "Fever Reducer","Diarrhea Stopper",
                "Pain Relieve Spray" };
        return prepareItemsList(MyConstants.HEALTH_CAMEL_CASE,data);
    }

    public List<Items> getTechnologyData(){
        String[] data = {"Mobile Phone", "Phone Cover", "E-Book Reader","Camera","Camera Charger",
                "Portable Speaker","Ipad","Headphone","Laptop","Laptop Charger","Mouse",
                "Extension Cable","Data Transfer Cable", "Bttery","Power Bank",
                "DvD Player","Flash-Light","MP3 Player", "Mp3 Player Char","Voltage Adapter",
                " SD Card" };
        return prepareItemsList(MyConstants.TECHNOLOGY_CAMEL_CASE,data);
    }

    public List<Items> getFoodData(){
        String[] data = {"Snack", "Sandwich", "Juice","Tea Bags","Coffee",
                "Water","Thermos","Chips","Baby Food" };
        return prepareItemsList(MyConstants.FOOD_CAMEL_CASE,data);
    }
    public List<Items> getBeachSuppliesData(){
        String[] data = {"Sun Glasses", "Sea Bed", "Suntan Cream","Beach Umbrella","Swim Fins",
                "Beach Bag","Beach Towel","Beach Slippers","Waterproof Clock","Sunbed" };
        return prepareItemsList(MyConstants.BEACH_SUPPLIES_CAMEL_CASE,data);
    }

    public List<Items> getCarSuppliesData(){
        String[] data = {"Pump", "Car Jack", "Spare Car Key","Accident Record Set","Auto Refrigerator",
                "Car Cover","Car Charger","Window Sun Shades"};
        return prepareItemsList(MyConstants.CAR_SUPPLIES_CAMEL_CASE,data);
    }

    public List<Items> getNeedsData(){
        String[] data = {"Backpack", "Daily Bags", "Laundry Bag","Sewing Kit","Travel Lock",
                "Luggage Tag","Magazine","Sports Equipment","Important Numbers" };
        return prepareItemsList(MyConstants.NEEDS_CAMEL_CASE,data);
    }
    private List<Items> prepareItemsList(String[] data)
    {
        return null;
    }

    public List<Items>prepareItemsList(String category, String [] date)
    {
        String data = null ;
        List<String> list = Arrays.asList(data);
        List<Items>dataList =new ArrayList<>();
        dataList.clear();
        for(int i=0;i<list.size();i++)
        {
            dataList.add(new Items(list.get(i),category,false));
        }
        return dataList;
    }

    public List<List<Items>>getAllData()
    {
        List<List<Items>>listOfAllItem = new ArrayList<>();
        listOfAllItem.clear();
        listOfAllItem.add(getBasicData());
        listOfAllItem.add(getClothingData());
        listOfAllItem.add(getPersonalCareData());
        listOfAllItem.add(getBabyNeedsData());
        listOfAllItem.add(getHealthData());
        listOfAllItem.add(getTechnologyData());
        listOfAllItem.add(getFoodData());
        listOfAllItem.add(getBeachSuppliesData());
        listOfAllItem.add(getCarSuppliesData());
        listOfAllItem.add(getNeedsData());
        return listOfAllItem;
    }

    public void persistAllData(){
        List<List<Items>> listOfAllItems = getAllData();
        for(List<Items> list:listOfAllItems)
        {
            for(Items items:list)
            {
                database.mainDao().saveItem(items);
            }
        }
            System.out.println("Data added");
        }


        public void persistDataByCategory (String category,Boolean onlyDelete)
        {
            try{
                List<Items>list =deleteAndGetListByCategory(category,onlyDelete);
                if(!onlyDelete){
                           for(Items item : list){
                               database.mainDao().saveItem(item);
                           }
                    Toast.makeText(context,category+"Reset Successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,category+"Reset Successfully",Toast.LENGTH_SHORT).show();
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        }

        private List<Items> deleteAndGetListByCategory(String category,Boolean onlyDelete){
        if(onlyDelete)
        {
            database.mainDao().deleteAllByCategoryAndAddedBy(category,MyConstants.SYSTEM_SMALL);
        }
        else{
            database.mainDao().deleteAllByCategory(category);
        }
        switch(category){
                case MyConstants.BASIC_NEEDS_CAMEL_CASE:
                return getBasicData();

                case MyConstants .CLOTHING_CAMEL_CASE:
                return getClothingData();

                case MyConstants .PERSONAL_CARE_CAMEL_CASE:
                return getPersonalCareData();

                case MyConstants .BABY_NEEDS_CAMEL_CASE:
                return getBabyNeedsData();

                case MyConstants .HEALTH_CAMEL_CASE:
                return getHealthData();

                case MyConstants .TECHNOLOGY_CAMEL_CASE:
                return getTechnologyData();

                case MyConstants .FOOD_CAMEL_CASE:
                return getFoodData();

                case MyConstants .BEACH_SUPPLIES_CAMEL_CASE:
                return getBeachSuppliesData();

                 case MyConstants .CAR_SUPPLIES_CAMEL_CASE:
                return getCarSuppliesData();

                case MyConstants .NEEDS_CAMEL_CASE:
                return getNeedsData();

                default:
                    return  new ArrayList<>();

        }
        }
}
