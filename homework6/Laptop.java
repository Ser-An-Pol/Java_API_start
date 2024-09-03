import java.util.Objects;

public class Laptop {
    private String Name;
    private int OZU;
    private int PZU;
    private String OS;
    private String Color;

    public Laptop(String name, int OZU, int PZU, String OS, String color) {
        Name = name;
        this.OZU = OZU;
        this.PZU = PZU;
        this.OS = OS;
        Color = color;
    }

    public String getName() {
        return Name;
    }

    public int getOZU() {
        return OZU;
    }

    public int getPZU() {
        return PZU;
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return Color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return OZU == laptop.OZU && PZU == laptop.PZU && Objects.equals(Name, laptop.Name)
                && Objects.equals(OS, laptop.OS) && Objects.equals(Color, laptop.Color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, OZU, PZU, OS, Color);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Name='" + Name + '\'' +
                ", OZU=" + OZU +
                ", PZU=" + PZU +
                ", OS='" + OS + '\'' +
                ", Color='" + Color + '\'' +
                '}' + "\n";
    }
}
