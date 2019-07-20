package user_recognize_txt;

public class Audio {
    private int volume;
    private Double snr;
    private int clipped;
    private Double rms;
    private int trunc;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Double getSnr() {
        return snr;
    }

    public void setSnr(Double snr) {
        this.snr = snr;
    }

    public int getClipped() {
        return clipped;
    }

    public void setClipped(int clipped) {
        this.clipped = clipped;
    }

    public Double getRms() {
        return rms;
    }

    public void setRms(Double rms) {
        this.rms = rms;
    }

    public int getTrunc() {
        return trunc;
    }

    public void setTrunc(int trunc) {
        this.trunc = trunc;
    }
}
