package butelka;

import java.util.Scanner;

public class Butelka {
    private double zawartosc;

    private double pojemnosc;

    Butelka(double ileLitrow, double pojemnosc) {
        this.zawartosc = Math.min(ileLitrow, pojemnosc);
        this.pojemnosc = pojemnosc;
    }

    public double getZawartosc() {
        return this.zawartosc;
    }

    public double getPojemnosc() {
        return pojemnosc;
    }

    public double getMiejsce() {
        return this.pojemnosc - this.zawartosc;
    }

    void wlej(double ilosc) {
        if (ilosc <= this.getMiejsce()) {
            this.zawartosc += ilosc;
        } else {
            this.zawartosc = this.pojemnosc;
        }
    }

    void wylej(double ilosc) {
        if (ilosc <= this.zawartosc) {
            this.zawartosc -= ilosc;
        } else {
            System.out.println("Chcesz za dużo wylać");
        }
    }
    void przelej(double ilosc, Butelka gdzie) {
        if (ilosc <= gdzie.getMiejsce() && ilosc <= this.zawartosc) {
            this.wylej(ilosc);
            gdzie.wlej(ilosc);
            System.out.println("1 wariant");
        } else if (ilosc <= gdzie.getMiejsce() && ilosc >= this.zawartosc) {
            gdzie.wlej(this.zawartosc);
            this.wylej(this.zawartosc);
            System.out.println("2 wariant");
        } else if (ilosc > gdzie.getMiejsce() && ilosc <= this.zawartosc) {
            this.wylej(gdzie.getMiejsce());
            gdzie.wlej(this.getMiejsce());
            System.out.println("3 wariant");
        } else if (ilosc > gdzie.getMiejsce() && ilosc >= this.zawartosc) {
            if (gdzie.getMiejsce() >= this.zawartosc) {
                gdzie.wlej(this.zawartosc);
                this.wylej(this.zawartosc);
                System.out.println("4 wariant");
            } else if (gdzie.getMiejsce() < this.zawartosc) {
                this.wylej(gdzie.getMiejsce());
                gdzie.wlej(gdzie.getMiejsce());
                System.out.println("5 wariant");
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile stworzyć butelek");
        int liczbaButelek = scanner.nextInt();
        Butelka[] butelka = new Butelka[liczbaButelek];
        for (int i = 0; i < butelka.length; ++i) {
            System.out.println("Podaj zawartość butelki numer " + (i + 1));
            double zawartosc = scanner.nextDouble();
            System.out.println("Podaj pojemność butelki numer " + (i + 1));
            double pojemnosc = scanner.nextDouble();
            if (zawartosc >= pojemnosc) {
                System.out.println("Niemożliwa zawartość");
                return;
            }

            butelka[i] = new Butelka(zawartosc, pojemnosc);
        }
        System.out.println("Co chcesz zrobić? (wlać/wylać/przelać)");
        String funkcja = scanner.nextLine();
        switch (funkcja){
            case "wlać":
                System.out.println("Wlać");
                break;
            case "wylać":
                System.out.println("Wylać");
                break;
            case "przelać":
                System.out.println("Przelać");
                break;
            default:
                System.out.println("Coś nie pykło");
        }

    }


}