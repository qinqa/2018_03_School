/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koe_18_3;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author Thomas
 */
public class Koe_18_3 {
    Scanner lukija = new Scanner(System.in);
    TreeMap<String, Integer> abcLista = new TreeMap<>();
    List<String> kaikkiRivit = new ArrayList<>();
    List<Joukkue> joukkueLista = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Koe_18_3().ohjelma();
    }
    
    public void ohjelma() {
        
        System.out.print("Syötä luettava tiedosto: ");
        String tiedosto = lukija.nextLine();
        
        try(Scanner tiedostoLukija = new Scanner(new File(tiedosto))) {
            
            while(tiedostoLukija.hasNextLine()) {
                String rivi = tiedostoLukija.nextLine();
                kaikkiRivit.add(rivi);
                String[] osa = rivi.split(";");
                
                //Joukkueet aakkosjärjestykseen puumappiin
                if(!abcLista.containsKey(osa[0])) {
                    abcLista.put(osa[0], 0);
                }
                if(!abcLista.containsKey(osa[1])) {
                    abcLista.put(osa[1], 0);
                }
            }
            
            //Kutsutaan kahta erillist tulostus metodia
            joukkueLista();
            sarjataulukko();
        } catch(Exception e) {
            System.out.println("*** Tiedostoa ei löydy! ***");
        }
    }
    
    public void joukkueLista() {
        List<String> nimet = abcLista.keySet().stream().sorted().collect(Collectors.toList());
        for(int i=0;i<nimet.size();i++) {
            //Tulostetaan joukkueen nimi
            System.out.println(nimet.get(i));
            //Luodaan joukkue olio
            Joukkue joukkue = new Joukkue(nimet.get(i));
            joukkueLista.add(joukkue);
        }
    }
    
    public void sarjataulukko() {
    
        System.out.println("\nSarjataulukko");
        
        for(int i=0;i<kaikkiRivit.size();i++) {
            String rivi = kaikkiRivit.get(i);
            String[] osa = rivi.split(";");
            
            String joukkueYksi = osa[0];
            String joukkueKaksi = osa[1];
            
            for(int j=0;j<joukkueLista.size();j++) {
                //JOUKKUE I
                if(joukkueLista.get(j).getNimi().matches(joukkueYksi)) {
                    //Ajetaan tulokset olioon joukkueen osalta
                    if(Integer.valueOf(osa[2])>Integer.valueOf(osa[3])) {
                        joukkueLista.get(j).setVoitot();
                    } else if(Integer.valueOf(osa[2])<Integer.valueOf(osa[3])) {
                        joukkueLista.get(j).setTappiot();
                    } else {
                        joukkueLista.get(j).setTasapelit();
                    }
                }
                //JOUKKUE II
                if(joukkueLista.get(j).getNimi().matches(joukkueKaksi)) {
                    //Ajetaan tulokset olioon joukkueen osalta
                    if(Integer.valueOf(osa[2])<Integer.valueOf(osa[3])) {
                        joukkueLista.get(j).setVoitot();
                    } else if(Integer.valueOf(osa[2])>Integer.valueOf(osa[3])) {
                        joukkueLista.get(j).setTappiot();
                    } else {
                        joukkueLista.get(j).setTasapelit();
                    }
                }
            }
        }
        //Järjestetään joukkueLista pisteide mukaan ja käydään se lävitse
        Collections.sort(joukkueLista);
            
        for(int i=0;i<joukkueLista.size();i++) {
            System.out.println(joukkueLista.get(i).toString());
            //System.out.println(joukkueLista.get(i).getNimi() + " " + joukkueLista.get(i).getPisteet());
        }
    }
}
