package lab08_handout;

import java.util.*;

enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES; }
enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING; }

class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public Suit getSuit(){
        return suit;
    }
    public Rank getRank(){
        return rank;
    }

    // TODO: Overriding 애너테이션을 추가한 뒤 오류를 고쳐보자.
    @Override
    public String toString() {
        return getSuit()+"_"+getRank();
    }
}


public class CardMain {
    public static void main(String[] args) {
        System.out.println("카드의 종류");
        System.out.println("---------------------------------");
        for(Suit suit:Suit.values()){
            System.out.println(suit);
        }
        System.out.println("---------------------------------");

        System.out.println("카드의 랭크");
        System.out.println("---------------------------------");
        for(Rank rank:Rank.values()){
            System.out.println(rank);
        }
        System.out.println("---------------------------------");

        ArrayList<Card> allCards = new ArrayList<>();
        // TODO: 모든 카드를 포함한 allCards 초기화. 위의 출력부분을 참고해보자.
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                allCards.add(new Card(suit, rank));
            }
        }
        System.out.println("총 "+allCards.size()+" 개의 카드가 생성되었습니다.");
        System.out.println(allCards);

        int numHandCard = 6;
        int numFourcards = 0;
        for(int i=0;i<1000000;i++){
            Collections.shuffle(allCards);

            HashMap<Rank, Integer> cardMap = new HashMap<>();
            // TODO: 위의 HashMap 을 이용하여 포카드가 있는지 검사해보자.
            for(int j=0;j<numHandCard;j++){
                Rank rank = allCards.get(j).getRank();
                cardMap.put(rank, cardMap.getOrDefault(rank, 0)+1);
            }
            // TODO: shuffle 이후에 0번~numHandCard 까지의 index가 받은 카드라고 가정하자.
            // TODO: 예. numHandCard가 6 인 경우 allCards.get(0), allCards.get(1), ~ allCards.get(5)
            // TODO: 각 Rank(숫자)에 해당하는 카드의 수를 HashMap에 업데이트하고, 검사는 아래의 코드에서 수행.
            for(int numCard:cardMap.values()){
                if(numCard==4){
                    numFourcards += 1;
                }
            }
        }
        //0.000695 또는 0.0695%, 100000번 중 69.5번, 1000000번 중 695번
        System.out.println(String.format("총 1000000번 중 포카드 출현 횟수: %d, (%.4f%%)", numFourcards, numFourcards/1000000.0*100));
    }
}
