package task2;

import java.util.List;

public class NBU {
    private List<Currency> currencyList;

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public String toString() {
        return "NBU{" +
                "currencyList=" + currencyList +
                '}';
    }
}
