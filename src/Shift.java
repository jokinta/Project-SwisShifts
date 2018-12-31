public class Shift {
    private String pass;
    private String time;
    private double workTime;
    private double pause;
    private String symbol;
    public Shift(String pass,String time, double workTime, double pause ) {
        this.pass = pass;
        this.time = time;
        this.workTime = workTime;
        this.pause = pause;
    }
    public Shift(String symbol ){
        this.symbol=symbol;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getWorkTime() {
        return this.workTime;
    }

    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }

    public double getPause() {
        return this.pause;
    }

    public void setPause(double pause) {
        this.pause = pause;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }



    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shift: ")
                .append(getPass())
                .append("||")
                .append("Worktime: ")
                .append(getTime())
                .append("||")
                .append("Work-hours: ")
                .append(getWorkTime())
                .append("||")
                .append("Pause-time: ")
                .append(getPause())
                .append("||");
        if("*".equals(getSymbol())){
            return new String("Day off||");
        }else if("O".equals(getSymbol())){
            return new String("Rest||");
        } else{
            return sb.toString();
        }
    }
}
