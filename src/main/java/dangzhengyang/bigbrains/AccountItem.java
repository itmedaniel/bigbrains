package dangzhengyang.bigbrains;

public class AccountItem {
    private String name;
    private String category;
    private String content;
    private String note;
    private double amount;
    private String occuredTime;

    public AccountItem(String name, String category, String content, String note, double amount, String occuredTime) {
        this.name = name;
        this.category = category;
        this.content = content;
        this.note = note;
        this.amount = amount;
        this.occuredTime = occuredTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOccuredTime() {
        return occuredTime;
    }

    public void setOccuredTime(String occuredTime) {
        this.occuredTime = occuredTime;
    }
}