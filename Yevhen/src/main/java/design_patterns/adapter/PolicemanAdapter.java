package design_patterns.adapter;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class PolicemanAdapter extends Policeman {
   private Militioner militioner;

    public PolicemanAdapter(Militioner militioner){
        super(militioner.getName(), militioner.getAge());
        this.militioner = militioner;

    }

    @Override
    public void makeLaw() {
        militioner.makeLaw();
    }
}
