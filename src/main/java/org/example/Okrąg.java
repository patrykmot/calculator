package org.example;
import java.util.ArrayList;
import java.util.List;
public class Okrąg {

    private double promien;


    public static void main(String[] args) {

        List<Okrąg> lista = new ArrayList<>();

        for(int i=1;i<=10000;i++){

            Okrąg krzywy = new Okrąg(i);
            lista.add(krzywy);

        }

        System.out.println("Zrobiłem "+lista.size()+" Okręgów");

    }

    public Okrąg(double promien) {
        this.promien = promien;

        System.out.println("Tutaj kontruktor okręgu o promieniu "+promien);

    }

}
