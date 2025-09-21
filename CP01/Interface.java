public class main {
    public static void main(String[] args) {
            //prac1
            Card card = new Card("Ace", PlayingCard.HEART);
            System.out.println("Card Number: "+card.getCardNumber());
            System.out.println("Card Kind: "+ card.getCardKind());
            System.out.println("SPADE value: "+PlayingCard.SPADE);
            System.out.println("DIAMOND value: "+PlayingCard.DIAMOND);
            System.out.println("HEART value: "+PlayingCard.HEART);
            System.out.println("CLOVER value: "+PlayingCard.CLOVER);

            //prac2
            A a = new A();
            a.autoPlay(new B());

            //prac3
            A2 a2 = new A2();
            a2.autoPlay(new B2());
            a2.autoPlay(new C2());
    }
}

//prac1
class Card implements PlayingCard{
    private String cardNumber;
    private int cardKind;
    
    public Card(String cardNumber, int cardKind) {
        this.cardNumber = cardNumber;
        this.cardKind = cardKind;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public String getCardKind() {
        if(cardKind == SPADE) {
            return "SPADE";
        } else if(cardKind == DIAMOND) {
            return "DIAMOND";
        } else if(cardKind == HEART) {
            return "HEART";
        } else if(cardKind == CLOVER) {
            return "CLOVER";
        } else {
            return "UNKNOWN";
        }
    }
}
interface PlayingCard{
    public static final int SPADE = 4;
    final int DIAMOND = 3;
    static int HEART = 2;
    int CLOVER = 1;
    
    public abstract String getCardNumber();
    public abstract String getCardKind();
}

//prac2
class A{
    void autoPlay(B b) {
        b.play();
    }
}

class B{
    public void play() {
        System.out.println("play in B");
    }
}

class C{
    public void play() {
        System.out.println("play in C");
    }
}

//prac3
class A2{
    void autoPlay(I i) {
        i.play();
    }
}

interface I{
    public void play();
}
class B2 implements I{
    public void play() {
        System.out.println("play in B");
    }
}

class C2 implements I {
    public void play() {
        System.out.println("play in C");
    }
}