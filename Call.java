package book;

public class Call {
    private Subscriber outgoing;
    private Subscriber incoming;
    private DateTime dateTime;
    private int duration;

    public Call() {
    }

    public Call(Subscriber outgoing, Subscriber incoming, DateTime dateTime, int duration) {
        this.outgoing = outgoing;
        this.incoming = incoming;
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public Subscriber getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(Subscriber outgoing) {
        this.outgoing = outgoing;
    }

    public Subscriber getIncoming() {
        return incoming;
    }

    public void setIncoming(Subscriber incoming) {
        this.incoming = incoming;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return outgoing + " " + incoming + " " + dateTime + " " + duration;
    }
}
