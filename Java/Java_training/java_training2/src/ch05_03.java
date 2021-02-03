import java.util.Scanner;

abstract class Converter {
    abstract protected double convert(double src);
    abstract protected String srcString();
    abstract protected String destString();
    protected double ratio;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(srcString() + "을 " + destString() + "로 바꿉니다.");
        System.out.print(srcString() + "을 입력하세요>> ");
        double val = scanner.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과: " + res + destString() + "입니다");
        scanner.close();
    }
}

class Won2Dollar extends Converter {
    public Won2Dollar(double ratio) {
        this.ratio = ratio;
    }

    @Override
    protected double convert(double src) {
        return src / ratio;
    }

    @Override
    protected String srcString() {
        return "원";
    }

    @Override
    protected String destString() {
        return "달러";
    }

}
public class ch05_03 {
    public static void main(String args[]) {
        Won2Dollar toDollar = new Won2Dollar(1200);
        toDollar.run();
    }

}
