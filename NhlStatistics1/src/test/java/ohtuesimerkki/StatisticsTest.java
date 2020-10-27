
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };

    Statistics stats;
    
    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchTest() {
        assertTrue(stats.search("Robotnik")==null);
        assertTrue(stats.search("Yzerman").getName().equals("Yzerman"));
    }
    
    @Test
    public void teamTest() {
        ArrayList<Player> correct = new ArrayList<Player>();
        correct.add(new Player("Semenko", "EDM", 4, 12));
        correct.add(new Player("Kurri",   "EDM", 37, 53));
        correct.add(new Player("Gretzky", "EDM", 35, 89));
        
        List<Player> result = stats.team("EDM");
        for (int i = 0; i < result.size(); i++) {
            assertTrue(result.get(i).getName().equals(correct.get(i).getName()));
            assertTrue(result.get(i).getTeam().equals(correct.get(i).getTeam()));
            assertTrue(result.get(i).getPoints() == (correct.get(i).getPoints()));
            assertTrue(result.get(i).getGoals() == (correct.get(i).getGoals()));
        }
    }
    
    @Test
    public void topScorersTest() {
        List<Player> correctTop = new ArrayList<Player>();
        
        correctTop.add(new Player("Gretzky", "EDM", 35, 89)); //124
        correctTop.add(new Player("Lemieux", "PIT", 45, 54)); //99
        correctTop.add(new Player("Yzerman", "DET", 42, 56)); //98
        correctTop.add(new Player("Kurri",   "EDM", 37, 53)); //90
        correctTop.add(new Player("Semenko", "EDM", 4, 12)); //16
        
        List<Player> topResults = stats.topScorers(correctTop.size()-1);
        
        for (int i = 0; i < topResults.size(); i++) {
            assertTrue(topResults.get(i).getName().equals(correctTop.get(i).getName()));
        }
    }
}
