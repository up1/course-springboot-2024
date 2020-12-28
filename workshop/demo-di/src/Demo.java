import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        MyRandom random = new Random5();
        GenerateService g = new GenerateService();
        g.random = random;
        int result = g.getNumber();
        System.out.println(result); // 50
    }
}

class Random5 implements MyRandom {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class GenerateService {
    MyRandom random;
    public int getNumber() {
        int randomNumber = random.nextInt(10);
        return randomNumber * 10;
    }
}
