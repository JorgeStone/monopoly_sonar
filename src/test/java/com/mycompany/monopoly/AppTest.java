package com.mycompany.monopoly;

import java.util.Arrays;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
  /**
   * Rigorous Test :-)
   */
  @Test
  public void shouldAnswerWithTrue() {
    assertEquals(4, 2 + 2);
  }
  
  /**
   * Teste la bonne inialisation d'un plateau de jeu avec deux joueurs prédefinies
   */
  @Test
  public void test_initPlateau() {
    Plateau pl = new Plateau();
    LinkedList<Joueur> joeurs = new LinkedList<>(Arrays.asList(new Joueur("Jorge"), new Joueur("Isaias")));
    pl.initPlateau(joeurs);
    assertEquals(pl.getCases().size(),40);
    assertEquals(pl.getJoueurs().size(),2);
  }
    
   /**
   * Teste l'appropiation d'une gare pour la part d'un joueur
   */
  @Test
  public  void test_joueurs(){
      //Afin de tester la fonction donnant le nombre de gares qui appartienent à un joueur,
      //nous devons créer un joueur avec son poremier constructeur parce que celui-ci
      //contient un plateau de jeu comme attribut
      Plateau pl = new Plateau();
      Joueur j = new Joueur("Jorge", pl);
      LinkedList<Joueur> joueurs = new LinkedList<>(Arrays.asList(j));
      pl.initPlateau(joueurs);
      assertEquals(j.nbGares(),0);
      Achetable gare = (Achetable) pl.getCases().get(5); //casteo obligatorio
      gare.setProprietaire(j);
      assertEquals(j.nbGares(),1);
  }
  
}
