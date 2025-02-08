public class Player {
    private String name;
    private String color;
    private int countSquare = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setCountSquare(int countSquare) {
        this.countSquare = countSquare;
    }

    public int getCountSquare() {
        return countSquare;
    }
}
