package cachemap;

import java.util.concurrent.TimeUnit;

/**
 * Provides a way to override the system time.
 * Useful for unit-testing purposes.
 */


public class Clock {
    private static Long time;

    /**
     * Returns the system time if no time has been explicitely
     * set using setTime(...)
     */
    public static long getTime() {
        if (time == null) {
            return System.currentTimeMillis();
        } else {
            return time;
        }
    }

    /**
     * Sets the time. This will cause getTime() to return the given time
     * instead of the system time.
     */
    public static void setTime(long time)  {


        Clock.time = time;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    /**
     * Clears the time. This will cause getTime() to return the system time.
     */
    public static void clearTime() {
        Clock.time = null;
    }
}
