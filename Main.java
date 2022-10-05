import LigaModel.Judoka;

import java.util.Date;

import static LigaModel.Judoka.Kyu.AMARILLO;

public class Main {
    public static void main(String[] args) {
        Judoka j1 = new Judoka("Luis", "Hinojosa", "2345", "234567","algo@der.com", "villa", (byte) 0, "-66",68,new Date(2000, 03, 24), AMARILLO, new Date(2012, 06,14));

    }
}