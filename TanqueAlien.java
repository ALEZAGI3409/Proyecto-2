public class TanqueAlien extends Tanque{
    
    public TanqueAlien(){
        super.salud = 20;
    }

    @Override
    public String toString(){
        return "TA-"+super.getSalud();
    }
}
