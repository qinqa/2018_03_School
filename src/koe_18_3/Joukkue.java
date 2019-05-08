/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koe_18_3;

public class Joukkue implements Comparable<Joukkue>{
    private String nimi;
    private Integer voitot;
    private Integer tappiot;
    private Integer tasapelit;
    private Integer pisteet;
    
    public Joukkue(String nimi) {
        this.nimi=nimi;
        this.voitot=0;
        this.tappiot=0;
        this.tasapelit=0;
        this.pisteet=0;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public Integer getVoitot() {
        return this.voitot;
    }
    
    public Integer getTappiot() {
        return this.tappiot;
    }
    
    public Integer getTasapelit() {
        return this.tasapelit;
    }
    
    public Integer getPisteet() {
        return this.pisteet;
    }
    
    public void setVoitot() {
        this.voitot = this.voitot + 1;
        this.setPisteet(3);
    }
    
    public void setTasapelit() {
        this.tasapelit = this.tasapelit + 1;
        this.setPisteet(1);
    }
    
    public void setTappiot() {
        this.tappiot = this.tappiot + 1;
    }
    
    public void setPisteet(int piste) {
        this.pisteet = this.pisteet + piste;
    }
    
    public String toString() {
        return this.nimi + " " + this.voitot + " " + this.tappiot + " " + this.tasapelit + " " + this.pisteet;
    }

    @Override
    public int compareTo(Joukkue joukkue1) {
        return joukkue1.getPisteet().compareTo(this.getPisteet());
    }
}
