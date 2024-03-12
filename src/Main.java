import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class УчебнаяГруппа {
    private String название;

    public УчебнаяГруппа(String название) {
        this.название = название;
    }

    public String получитьНазвание() {
        return название;
    }
}

class Поток implements Iterable<УчебнаяГруппа> {
    private List<УчебнаяГруппа> списокГрупп;

    public Поток() {
        списокГрупп = new ArrayList<>();
    }

    public void добавитьГруппу(УчебнаяГруппа группа) {
        списокГрупп.add(группа);
    }

    public List<УчебнаяГруппа> получитьСписокГрупп() {
        return списокГрупп;
    }

    @Override
    public Iterator<УчебнаяГруппа> iterator() {
        return списокГрупп.iterator();
    }
}

class StreamComparator {
    public static int сравнитьКоличествоГрупп(Поток поток1, Поток поток2) {
        int количествоГруппПоток1 = поток1.получитьСписокГрупп().size();
        int количествоГруппПоток2 = поток2.получитьСписокГрупп().size();

        return Integer.compare(количествоГруппПоток1, количествоГруппПоток2);
    }
}

public class Main {
    public static void main(String[] args) {
        Поток поток1 = new Поток();
        поток1.добавитьГруппу(new УчебнаяГруппа("Группа 1"));
        поток1.добавитьГруппу(new УчебнаяГруппа("Группа 2"));

        Поток поток2 = new Поток();
        поток2.добавитьГруппу(new УчебнаяГруппа("Группа 3"));
        поток2.добавитьГруппу(new УчебнаяГруппа("Группа 4"));
        поток2.добавитьГруппу(new УчебнаяГруппа("Группа 5"));

        int результатСравнения = StreamComparator.сравнитьКоличествоГрупп(поток1, поток2);

        if (результатСравнения < 0) {
            System.out.println("В потоке 2 больше групп");
        } else if (результатСравнения > 0) {
            System.out.println("В потоке 1 больше групп");
        } else {
            System.out.println("Количество групп в обоих потоках одинаково");
        }
    }
}