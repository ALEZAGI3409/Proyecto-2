public class TanqueNormal extends Tanque{
    
    public TanqueNormal(){
        super.salud = 10;
    }

    @Override
    public String toString(){
        return "TN-"+super.getSalud();
    }
}