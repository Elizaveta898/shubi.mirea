package Pr5.Task6789;

public class Shop implements Printable {
    private String name;
    private String publisher;
    private int issueNumber;

    public Shop(String name, String publisher, int issueNumber) {
        this.name = name;
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    @Override
    public void print() {
        System.out.println("Журнал: '" + name + "'");
        System.out.println("Издатель: " + publisher);
        System.out.println("Номер выпуска: " + issueNumber);
        System.out.println("---------------");
    }

    // Геттеры
    public String getName() { return name; }
    public String getPublisher() { return publisher; }
    public int getIssueNumber() { return issueNumber; }
}