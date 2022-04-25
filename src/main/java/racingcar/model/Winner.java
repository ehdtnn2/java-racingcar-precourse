package racingcar.model;

import java.util.List;

public class Winner {

    private List<String> names;

    public Winner(List<String> names) {
        this.names = names;
    }

    public boolean isSolo() {
        return names.size() == 1;
    }

    public int size() {
        return names.size();
    }

    public String get(int i) {
        return names.get(i);
    }
}
