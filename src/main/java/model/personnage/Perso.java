package model.personnage;

public class Perso {
    private String name;
    private int End;
    private int For;
    private int Pv;

    public Perso() {
    }

    public Perso(String name, int End, int For, int Pv) {
        this.name = name;
        this.End = End;
        this.For = For;
        this.Pv = Pv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnd() {
        return End;
    }

    public void setEnd(int end) {
        End = end;
    }

    public int getFor() {
        return For;
    }

    public void setFor(int aFor) {
        For = aFor;
    }

    public int getPv() {
        return Pv;
    }

    public void setPv(int pv) {
        Pv = pv;
    }

    @Override
    public String toString() {
        return "Perso{" +
                "name='" + name + '\'' +
                ", End=" + End +
                ", For=" + For +
                ", Pv=" + Pv +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Perso perso = (Perso) o;
        return End == perso.End && For == perso.For && Pv == perso.Pv && name.equals(perso.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + End;
        result = 31 * result + For;
        result = 31 * result + Pv;
        return result;
    }
}
