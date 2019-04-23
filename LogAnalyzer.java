/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    
    //Calculate monthly and daily counts
    private int[] dayCounts;
    private int[] monthCounts;
    
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String fileName)  //7.12
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        //Create the array object to hold the daily and monthly access counts
        dayCounts = new int[29];
        monthCounts = new int[13];
        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);
    }
    /**
     * Return the busiest hour
     * Edited code from neonachronism's loganalyzer
     */
    public int busiestHour()            
    {
       int maxH = hourCounts[0];
       int counter = 0;
       int index = 0;
       for(int hourCount : hourCounts){
           if(maxH < hourCount){ 
               maxH = hourCount;
               counter = index;          
            }
            index++;
       }
       return counter;
    }
    /**
     * Return the busiest two hours
     *  
     */
    public int busiest2Hour()            
    {
       int firstHour = 0;
       int secondHour = 0;
       
       for(int i = 0; i< hourCounts.length; i++){
           if(firstHour < hourCounts[i]){ 
               firstHour = hourCounts[i];
               secondHour = firstHour;          
            }
            
       }
       return firstHour;
    }
    /**
     * Return the quietest hour
     */
    public int quietestHour(){
        int minH = hourCounts[9999];
        int counter = 0;
        int index = 0;
        for(int hourCount : hourCounts){
            if(minH > hourCount){
                minH = hourCount;
                counter = index;
            }
            index++;
        }
        return counter;
       }
    /**
     * Return the busiest day
     */
    public int busiestDay(){
        int maxD = dayCounts[0];
        int counter = 0;
        int index = 0;
        for (int dayCount : dayCounts){
            if(maxD < dayCount){
                maxD = dayCount;
                counter = index;
            }
            index++;
        }
      
        return  counter; 
    }
    /**
     * Return the quietest day
     */
    public int quietestDay(){
        int maxD = dayCounts[0];
        int counter = 0;
        int index = 0;
        for (int dayCount : dayCounts){
            if(maxD < dayCount){
                maxD = dayCount;
                counter = index;
            }
            index++;
        }
      
        return  counter; 
    }
      /**
     * Return the quietest month
     */
    public int quietestMonth(){
        int maxM = monthCounts[0];
        int counter = 0;
        int index = 0;
        for (int monthCount : monthCounts){
            if(maxM < monthCount){
                maxM = monthCount;
                counter = index;
            }
            index++;
        }
      
        return  counter; 
    }
    /**
     * Return the busiest month
     */
    public int busiestMonth(){
        int maxM = monthCounts[0];
        int counter = 0;
        int index = 0;
        for (int monthCount : monthCounts){
            if(maxM < monthCount){
                maxM = monthCount;
                counter = index;
            }
            index++;
        }
      
        return  counter; 
    }
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
        
    }
    /**
     * Return the number of accesses recorded in the log file.
     */
     public int numberOfAccesses()
     {
       int total = 0;
       // Add the value in each element of hourCounts to // total.
       for(int hour = 0; hour < hourCounts.length; hour++){
           total+= hourCounts[hour];}
       return total;
    
    }
    /**
     * Return the total accesses per month
     */
    public int totalAccessPerMonth(){
        int total = 0;
        //Add the value in each element of hourCounts to //total.
        for(int month = 0;month < monthCounts.length; month++){
            total+= monthCounts[month];}
            return total;
    }
    /**
     * Return average accesses per month
     */
    public int avgAccessesPerMonth(){
     int avg = 0;
     for(int month = 0; month < monthCounts.length; month++){
     
    }
}
}