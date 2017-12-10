
package statistics;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    
    Matcher m;
    
    public QueryBuilder() {
        m = new HasAtLeast(-1, "goals");
    }
    
    public Matcher build() {
        Matcher temp = m;
        m = new HasAtLeast(-1, "goals");
        return temp;
    }
    
    QueryBuilder playsIn(String team) {
        this.m = new And(m,new PlaysIn(team));
        return this;
    }
    
    QueryBuilder or(Matcher... matchers) {
        this.m = new And(m, new Or(matchers));
        return this;
    }
    
    QueryBuilder not(Matcher matcher) {
        this.m = new And(m,new Not(matcher));
        return this;
    }
    
    QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(m,new HasFewerThan(value, category));
        return this;
    }
    
    QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(m,new HasAtLeast(value, category));
        return this;
    }
    
    QueryBuilder and(Matcher... matchers) {
        this.m = new And(m,new And(matchers));
        return this;
    }
    
    QueryBuilder oneOf (Matcher m1, Matcher m2) {
        this.m = new Or(m1,m2);
        return this;
    }
}
