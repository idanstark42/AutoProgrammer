package situations;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class Operations{

    private Situation situation;
    public Operations(Situation situation){
        this.situation = situation;
    }

    public Situation subSituation(String... names){
        Situation result = new Situation();
        for(String name : names){
            result.add(situation.get(name));
        }
        return result;
    }

    public void join(Situation situation) {
        for(InstanceState object : situation.objects){
            situation.remove(situation.get(object.instance.name));
            situation.add(object);
        }
    }

}