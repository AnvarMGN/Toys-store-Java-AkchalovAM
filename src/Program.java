import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Program {
    public static void main(String[] args) {

       // Добавим массивы

       int[] ids = {1,2,3,4,5,6,7,8,9,10,11,12};
       String[] names = {"Lego", "Robot", "Doll", "Ball", "Car", "Puzzle", "Bear", "Batman", "Candies", "Barbie", "Doll 2", "Kangaroo" };
       double[] frequencies = {0.2, 0.2, 0.6, 0.3, 0.5, 0.1, 0.65, 0.8, 0.4, 0.9, 0.7, 1.0};

        // Добавим игрушки в toysQueue

        PriorityQueue toysQueue = new PriorityQueue<>((t1,t2) -> Double.compare(((Toy) t2).getFrequency(), ((Toy) t1).getFrequency()));

        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toysQueue.add(toy);
        }

        // Добавим игрушки из toysQueue в resultList

        List<Toy> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Toy currenToy = (Toy) toysQueue.poll();
            resultList.add(currenToy);
        }

        // Сохраним resultList в "result.txt" с помощью BufferedWriter.

        String fileName = "result.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Toy toy : resultList) {
                writer.write(String.format("Id: %d, Name: %s, Frq: %.2fn; \n", toy.getId(), toy.getName(), toy.getFrequency()));
            }
        } catch (Exception e) {
            System.err.format("IOException: %s%n", e);
        }

    }
}

