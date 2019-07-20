package user_recognize_txt;

import java.util.List;

public class Result {
    private int conf;
    private int score;
    private double wpm;
    private double wpmf;
    private double cwpm;
    private double cwpmf;
    private double pps;
    private double rhytm;
    private double fluency;
    private double compl;
    private double compl_ph;
    private double acc;
    private double misp;
    private double misr;
    private double mism;
    private double skipped;
    private int words_read;
    private int words_correct;
    private double nativ;
    private double audio_duration;
    private List<Words> words;
    private Audio audio;
    private String code;

    public int getConf() {
        return conf;
    }

    public void setConf(int conf) {
        this.conf = conf;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getWpm() {
        return wpm;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public double getWpmf() {
        return wpmf;
    }

    public void setWpmf(double wpmf) {
        this.wpmf = wpmf;
    }

    public double getCwpm() {
        return cwpm;
    }

    public void setCwpm(double cwpm) {
        this.cwpm = cwpm;
    }

    public double getCwpmf() {
        return cwpmf;
    }

    public void setCwpmf(double cwpmf) {
        this.cwpmf = cwpmf;
    }

    public double getPps() {
        return pps;
    }

    public void setPps(double pps) {
        this.pps = pps;
    }

    public double getRhytm() {
        return rhytm;
    }

    public void setRhytm(double rhytm) {
        this.rhytm = rhytm;
    }

    public double getFluency() {
        return fluency;
    }

    public void setFluency(double fluency) {
        this.fluency = fluency;
    }

    public double getCompl() {
        return compl;
    }

    public void setCompl(double compl) {
        this.compl = compl;
    }

    public double getCompl_ph() {
        return compl_ph;
    }

    public void setCompl_ph(double compl_ph) {
        this.compl_ph = compl_ph;
    }

    public double getAcc() {
        return acc;
    }

    public void setAcc(double acc) {
        this.acc = acc;
    }

    public double getMisp() {
        return misp;
    }

    public void setMisp(double misp) {
        this.misp = misp;
    }

    public double getMisr() {
        return misr;
    }

    public void setMisr(double misr) {
        this.misr = misr;
    }

    public double getMism() {
        return mism;
    }

    public void setMism(double mism) {
        this.mism = mism;
    }

    public double getSkipped() {
        return skipped;
    }

    public void setSkipped(double skipped) {
        this.skipped = skipped;
    }

    public int getWords_read() {
        return words_read;
    }

    public void setWords_read(int words_read) {
        this.words_read = words_read;
    }

    public int getWords_correct() {
        return words_correct;
    }

    public void setWords_correct(int words_correct) {
        this.words_correct = words_correct;
    }

    public double getNativ() {
        return nativ;
    }

    public void setNativ(double nativ) {
        this.nativ = nativ;
    }

    public double getAudio_duration() {
        return audio_duration;
    }

    public void setAudio_duration(double audio_duration) {
        this.audio_duration = audio_duration;
    }

    public void setWords(List<Words> words) {
        this.words = words;
    }
    public List<Words> getWords() {
        return words;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }
    public Audio getAudio() {
        return audio;
    }

   /* public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }*/
}
