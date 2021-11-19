package com.example.projectandroidtest;

public class Matiere {
    public int Francais;
    public int Maths;
    public int Physique;
    public int Chemie;
    public int Histoire;
    public int Geographie;
    public int Anglais;
    public int Espagnol;
    public int Allemand;

    public Matiere(int francais, int maths, int physique, int chemie, int histoire, int geographie, int anglais, int espagnol, int allemand) {
        Francais = francais;
        Maths = maths;
        Physique = physique;
        Chemie = chemie;
        Histoire = histoire;
        Geographie = geographie;
        Anglais = anglais;
        Espagnol = espagnol;
        Allemand = allemand;
    }
    public Matiere() {
    }

    public int getFrancais() {return Francais;}
    public void setFrancais(int francais) {Francais = francais;}
    public int getMaths() {return Maths;}
    public void setMaths(int maths) {Maths = maths;}
    public int getPhysique() {return Physique;}
    public void setPhysique(int physique) {Physique = physique;}
    public int getChemie() {return Chemie;}
    public void setChemie(int chemie) {Chemie = chemie;}
    public int getHistoire() {return Histoire;}
    public void setHistoire(int histoire) {Histoire = histoire;}
    public int getGeographie() {return Geographie;}
    public void setGeographie(int geographie) {Geographie = geographie;}
    public int getAnglais() {return Anglais;}
    public void setAnglais(int anglais) {Anglais = anglais;}
    public int getEspagnol() {return Espagnol;}
    public void setEspagnol(int espagnol) {Espagnol = espagnol;}
    public int getAllemand() {return Allemand; }
    public void setAllemand(int allemand) {Allemand = allemand;}

    @Override
    public String toString() {
        return "Matiere{" +
                "Francais=" + Francais +
                ", Maths=" + Maths +
                ", Physique=" + Physique +
                ", Chemie=" + Chemie +
                ", Histoire=" + Histoire +
                ", Geographie=" + Geographie +
                ", Anglais=" + Anglais +
                ", Espagnol=" + Espagnol +
                ", Allemand=" + Allemand +
                '}';
    }
}
