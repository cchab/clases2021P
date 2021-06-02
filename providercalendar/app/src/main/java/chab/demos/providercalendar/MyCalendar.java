package chab.demos.providercalendar;

public class MyCalendar {
    long id;
    String displayName, accountName, ownerName;

    public MyCalendar(long id, String displayName, String accountName, String ownerName){
        this.id = id;
        this.displayName = displayName;
        this.accountName = accountName;
        this.ownerName = ownerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
