
public class T2time {
    static final int T2DAYSECONDS = 13*3600+27*60+16; //48436 secs/day
    private int seconds = 0; //valid range [0, T2DAYSECONDS-1]
    public T2time(int secs) {
        if (secs < 0 || secs >= T2DAYSECONDS)
            throw new IllegalArgumentException("0 <= secs < T2DAYSECONDS");
        this.seconds = secs;
    }
    public T2time(int h, int m, int s) {
        this(h*3600 + m*60 + s);
    }
    public int asSeconds() { return seconds; }

    /**
     * @return this.seconds formatted as "HH:MM:SS"
     */
    public String toString() {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = (seconds % 3600) % 60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }

    /**
     * @pre arg != null
     * @return new T2time with Sum of this and arg mod T2DAYSECONDS
     * @post this == old this
     */
    public T2time add(T2time arg) {
        int sum = (this.seconds + arg.asSeconds()) % T2DAYSECONDS;
        return new T2time(sum);
    }
}
