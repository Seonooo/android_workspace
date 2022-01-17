package kr.or.dshrd.challenge.HelperClass;

public class ItemHelperClass {

    String no, title, content, date;

    public ItemHelperClass(String no, String title, String content, String date) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getNo(){return  no;}
    public String getTitle() {
        return title;
    }
    public String getContent() { return content; }
    public String getDate(){return  date; }

}
