import java.util.*;


public class Main {
    public static void main(String[] args){
        List<Integer> results = new ArrayList<>();
        newGame(results);
    }

    public static void newGame(List<Integer> results){
        Random random = new Random();
        int rndNumber = random.nextInt(101);
        System.out.println("Угадайте рандомное число от 0 до 100");
        numberCheck(rndNumber, 1, results);
        System.out.println("RESULT - Результаты\nNEW - Новая игра");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        if(input.equals("RESULT"))
        {
            numberResults(0, results);
        }
        else if(input.equals("NEW"))
        {
            newGame(results);
        }
    }

    public static void numberCheck(int rndNumber, int attempts, List<Integer> results){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число:");
        try {
            String input = scan.next();
            if(input.equals("RESULT"))
            {
                numberResults(0, results);
            }
            int number = Integer.parseInt(input);
            if(number != rndNumber)
            {
                if(number < rndNumber)
                {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                    numberCheck(rndNumber, attempts + 1, results);
                }
                else
                {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                    numberCheck(rndNumber, attempts + 1, results);
                }
            }
            else
            {
                System.out.println("Красавчик брат, ты угадал\nКолличество попыток:" + attempts);
                numberResults(attempts, results);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Введи число брат");
            numberCheck(rndNumber, attempts, results);
        }
    }

    public static void numberResults(int attempts, List<Integer> results){
        if (attempts != 0)
        {
            results.add(attempts);
        }
        else
        {
            results.sort(Comparator.naturalOrder());
            System.out.println("Лучший результат: " + results.get(0) + "\nРезультаты:" + results);
        }
    }
}