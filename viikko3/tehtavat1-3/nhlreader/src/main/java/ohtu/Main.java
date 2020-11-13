/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.client.fluent.Request;
/**
 *
 * @author mluukkai
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        List<Player> players1 = new ArrayList<Player>();
        for (int i = 0; i < players.length; i++) {
            players1.add(players[i]);
        }
        Collections.sort(players1);
//        System.out.println("Oliot:");

        System.out.println("Players from FIN 2019");
        for (Player player : players1) {
            if (player.getNationality().equals("FIN")){
                System.out.println(player);
            }
        }   
    }
  
}
