import javax.swing.*;
import java.util.List;

public class CardsProcessing extends JLabel {

    CardsForming cardsForming = new CardsForming();
    private static int score;
    private static int scorePc;

    public CardsProcessing() {
        view();
    }

    public void scoreCalc(List<int[]> Cards) {

        score = 0;

        for (int[] card : Cards) {
            switch (card[0]) {
                case 0 -> score += 6;
                case 1 -> score += 7;
                case 2 -> score += 8;
                case 3 -> score += 9;
                case 4 -> score += 10;
                case 5 -> score += 2;
                case 6 -> score += 3;
                case 7 -> score += 4;
                case 8 -> score += 11;
            }
        }
    }

    public void scoreCalcPc(List<int[]> Cards) {

        scorePc = 0;

        for (int[] card : Cards) {
            switch (card[0]) {
                case 0 -> scorePc += 6;
                case 1 -> scorePc += 7;
                case 2 -> scorePc += 8;
                case 3 -> scorePc += 9;
                case 4 -> scorePc += 10;
                case 5 -> scorePc += 2;
                case 6 -> scorePc += 3;
                case 7 -> scorePc += 4;
                case 8 -> scorePc += 11;
            }
        }
    }

    public void cardsOfPlayer() {
        cardsForming.checkCard(CardsForming.CardsPc, CardsForming.Cards,
                cardsForming.createRandomCard());
        scoreCalc(CardsForming.Cards);
        view();
    }

    public void scoreOfPlayers() {
        while (true) {
            if (scorePc <= 16) {
                cardsOfPc();
            } else {
                break;
            }
        }
        view();
    }

    public void cardsOfPc() {
        if (scorePc <= 16) {
            cardsForming.checkCard(CardsForming.Cards, CardsForming.CardsPc,
                    cardsForming.createRandomCard());
            scoreCalcPc(CardsForming.CardsPc);
        }
        view();
    }

    public void getWinner() {
        if ((score > scorePc && score <= Consts.COUNT_FOR_WIN) ||
                (scorePc > Consts.COUNT_FOR_WIN && score <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + "\n Очки противника: " + scorePc + "\n Вы победили!");
        } else if ((scorePc > score && scorePc <= Consts.COUNT_FOR_WIN) ||
                (score > Consts.COUNT_FOR_WIN && scorePc <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + "\n Очки противника: " + scorePc + "\n Вы проиграли!");
        } else {
            setText("Ваши очки: " + score + "\n Очки противника: " + scorePc + "\n Ничья!");
        }
    }

    public void view() {
        setText("Ваши очки: " + score + "\n Очки противника: " + scorePc);
    }
}
