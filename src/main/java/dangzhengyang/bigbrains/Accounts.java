package dangzhengyang.bigbrains;

import java.util.Date;

public class Accounts {

    private String name;
    private String category;
    private String content;
    private String note;
    private float amount;
    private Date occuredTime;

    public Accounts(String name, String category, String content, String note, String amount, Date occuredTime) {
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
        category = category;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getOccuredTime() {
        return occuredTime;
    }

    public void setOccuredTime(Date occuredTime) {
        occuredTime = occuredTime;
    }
}
