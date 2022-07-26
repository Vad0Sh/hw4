package task2;

public class Currency {
    private int r030;
    private String txt;
    private int rate;
    private String cc;
    private String exechangedate;

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExechangedate() {
        return exechangedate;
    }

    public void setExechangedate(String exechangedate) {
        this.exechangedate = exechangedate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "r030=" + r030 +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                ", cc='" + cc + '\'' +
                ", exechangedate='" + exechangedate + '\'' +
                '}';
    }
}
