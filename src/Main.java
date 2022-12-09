public class Main
{
    public static void main(String[] args)
    {
        TemperatureUpdate temp1 = new TemperatureUpdate(68.5, 56.7, "F");
        tempTest(temp1);

        TemperatureUpdate temp2 = new TemperatureUpdate(74.2, 60.5, "F");
        tempTest(temp2);

        TemperatureUpdate temp3 = new TemperatureUpdate(27.65, 10.5, "C");
        tempTest(temp3);

        TemperatureUpdate temp4 = new TemperatureUpdate(21.3, 9.8, "C");
        tempTest(temp4);

        TemperatureUpdate temp5 = new TemperatureUpdate(43.5, 29.8, "F");
        tempTest(temp5);

        TemperatureUpdate temp6 = new TemperatureUpdate(31.8, 30.2, "F");
        tempTest(temp6);

        TemperatureUpdate temp7 = new TemperatureUpdate(13.8, 2.4, "C");
        tempTest(temp7);

        TemperatureUpdate temp8 = new TemperatureUpdate(5.9, -3.65, "C");
        tempTest(temp8);

        // static variables maintain their current values
        System.out.println("==============================");
        tempTest(temp1);
    }

    public static void tempTest(TemperatureUpdate temp)
    {
        // FINISH ME!
        // use instance method getters
        System.out.println("High temp: " + temp.getHighTemp());
        System.out.println("Low temp: " + temp.getLowTemp());
        System.out.println("Scale: " + temp.getTempScale());
        System.out.println("Below freezing? " + temp.belowFreezing());

        // use static method getters
        System.out.println("Highest tracked temp (F): " + TemperatureUpdate.getHighestTrackedTempF());
        System.out.println("Lowest tracked temp (F): " + TemperatureUpdate.getLowestTrackedTempF());
        System.out.println("Ever saw freezing?: " + TemperatureUpdate.sawFreezing());
        System.out.println("-----------");


    }
}
