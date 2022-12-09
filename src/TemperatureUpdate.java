public class TemperatureUpdate {
    private double highTemp;
    private double lowTemp;
    private String tempScale;
    private static final int FREEZING_TEMP_F = 32;
    private static double highestTrackedTempF = 0;
    private static double lowestTrackedTempF = 0;
    private static boolean setFirstTemp = false;

    // Precondition: scale must be: "F" or "C"; anything else will default to "F"
    public TemperatureUpdate(double high, double low, String scale)
    {
        highTemp = high;
        lowTemp = low;

        if (scale.equals("F") || scale.equals("C"))
        {
            tempScale = scale;
        }
        else
        {
            tempScale = "F";
        }

        if (scale.equals("F"))
        {
            if (highTemp > highestTrackedTempF)
            {
                highestTrackedTempF = highTemp;
            }
            if (lowTemp < lowestTrackedTempF)
            {
                lowestTrackedTempF = lowTemp;
            }
        }
        if (scale.equals("C"))
        {
            if (convertCtoF(highTemp) > highestTrackedTempF)
            {
                highestTrackedTempF = convertCtoF(highTemp);
            }
            if (convertCtoF(lowTemp) < lowestTrackedTempF)
            {
                lowestTrackedTempF = convertCtoF(lowTemp);
            }
        }
        if (setFirstTemp == false)
        {
            highestTrackedTempF = highTemp;
            lowestTrackedTempF = lowTemp;
            setFirstTemp = true;
        }
    }

    // 1. Add your two static methods here:

    public static double convertCtoF(double temp)
    {
        return (temp * 9/5) + 32;
    }
    public static double convertFtoC(double temp)
    {
        return (temp - 32) * 5/9;
    }


    // 2. Add your two instance methods here:

    public void changeToC()
    {
        if (tempScale.equals("F"))
        {
            convertFtoC(highTemp);
            convertFtoC(lowTemp);
            tempScale = "C";
        }
    }
    public void changeToF()
    {
        if (tempScale.equals("C"))
        {
            convertCtoF(highTemp);
            convertCtoF(lowTemp);
            tempScale = "F";
        }
    }


    // 3. Add your private static helper rounding "utility" method here:

    private static double roundToNearestTenth(double num)
    {
        num = Math.round(num * 10.0) / 10.0;
        return num;
    }

    // 4. Complete the toString method below (using your static helper method)
    //    so it returns a String that prints like:

    //    High Temperature: 67.4 F (or C)
    //    Low Temperature: 58.3 F (or C)

    public String toString()
    {
        if (tempScale.equals("F"))
        {
            return "High Temperature: " + roundToNearestTenth(highTemp) + " F\nLow Temperature: " + roundToNearestTenth(lowTemp) + " F";
        }
        else
        {
            return "High Temperature: " + roundToNearestTenth(highTemp) + " C\nLow Temperature: " + roundToNearestTenth(lowTemp) + " C";
        }
    }

    public double getHighTemp()
    {
        return highTemp;
    }

    public double getLowTemp()
    {
        return lowTemp;
    }

    public String getTempScale()
    {
        return tempScale;
    }

    public static double getHighestTrackedTempF()
    {
        return highestTrackedTempF;
    }

    public static double getLowestTrackedTempF()
    {
        return lowestTrackedTempF;
    }

    public boolean belowFreezing()
    {
        if (tempScale.equals("C"))
        {
            if (convertCtoF(highTemp) < FREEZING_TEMP_F || convertCtoF(lowTemp) < FREEZING_TEMP_F)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        if (tempScale.equals("F"))
        {
            if (highTemp < FREEZING_TEMP_F || lowTemp < FREEZING_TEMP_F)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    public static boolean sawFreezing()
    {
        if (highestTrackedTempF < FREEZING_TEMP_F || lowestTrackedTempF < FREEZING_TEMP_F)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
