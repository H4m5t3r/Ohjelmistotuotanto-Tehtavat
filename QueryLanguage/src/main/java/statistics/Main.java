package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));
        
        QueryBuilder query = new QueryBuilder();
        Matcher m = query.oneOf(
            query.playsIn("EDM")
                .hasAtLeast(40, "points").build(),

            query.playsIn("PHI")
                .hasAtLeast(10, "assists")
                .hasFewerThan(5, "goals").build()

            
        ).build();

//        Matcher m = new Or( new HasAtLeast(40, "goals"),
//                            new HasAtLeast(60, "assists")
//        );



        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }

}
