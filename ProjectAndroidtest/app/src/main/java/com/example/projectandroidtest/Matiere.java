package com.example.projectandroidtest;

public class Matiere {
    public int francais;
    public int maths;
    public int physique;
    public int chemie;
    public int histoire;
    public int geographie;
    public int anglais;
    public int espagnol;
    public int allemand;

    public Matiere(int francais, int maths, int physique, int chemie, int histoire, int geographie, int anglais, int espagnol, int allemand) {
        this.francais = francais;
        this.maths = maths;
        this.physique = physique;
        this.chemie = chemie;
        this.histoire = histoire;
        this.geographie = geographie;
        this.anglais = anglais;
        this.espagnol = espagnol;
        this.allemand = allemand;
    }
    public Matiere(){}
    public int getFrancais() {return francais;}
    public void setFrancais(int francais) {this.francais = francais;}
    public int getMaths() {return maths;}
    public void setMaths(int maths) {this.maths = maths;}
    public int getPhysique() {return physique;}
    public void setPhysique(int physique) {this.physique = physique;}
    public int getChemie() {return chemie;}
    public void setChemie(int chemie) {this.chemie = chemie;}
    public int getHistoire() {return histoire;}
    public void setHistoire(int histoire) {this.histoire = histoire;}
    public int getGeographie() {return geographie;}
    public void setGeographie(int geographie) {this.geographie = geographie;}
    public int getAnglais() {return anglais;}
    public void setAnglais(int anglais) {this.anglais = anglais;}
    public int getEspagnol() {return espagnol;}
    public void setEspagnol(int espagnol) {this.espagnol = espagnol;}
    public int getAllemand() {return allemand; }
    public void setAllemand(int allemand) {this.allemand = allemand;}
}
