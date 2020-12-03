
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher returnThis = new And(matcher);
        this.matcher = new All();
        return returnThis;
    }

    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        matcher = new And(matcher, new Or(matchers));
        return this;
    }
    
}
