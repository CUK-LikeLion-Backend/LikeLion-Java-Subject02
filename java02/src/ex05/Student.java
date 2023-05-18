package ex05;

import java.io.* ;
import java.util.Random ;

class UnsupportFunctionException extends RuntimeException{
    private final int ERR_CODE;
    UnsupportFunctionException(String msg, int ERR_CODE) {
        super(msg);
        this.ERR_CODE = ERR_CODE;
    }
    public int getErrCode() { return ERR_CODE;}
    public String getMessage() { return super.getMessage()+","+ERR_CODE;}
}

public class Student {
    public static void main(String[] args) throws IOException {
        int grade = 0 , majorCount = 0, fCount=0;
        try(BufferedReader reader = new BufferedReader(new FileReader("src/ex05/input.txt"))){
            String str;
            double[] randomGrade = {0,3.0,3.5,4.0,4.5};
            while((str = reader.readLine()) != null){
                String[] tmp = str.split(" ");
                // 3: 전공/교양 확인
                if(tmp[3].equals("전선") || tmp[3].equals("전기")){
                    Random random = new Random();
                    double tmpGrade = randomGrade[random.nextInt(5)];
                    if(tmpGrade == 0) ++fCount; //F 학점인 경우
                    if(fCount >=3 ) throw new UnsupportFunctionException("학사경고임",3);
                    if(tmpGrade >= 5) throw new UnsupportFunctionException("학점이 옳게 부여되지 않았습니다.",1);
                    grade += tmpGrade;
                    ++majorCount;
                }
            }
            if(majorCount < 0) {
                throw new UnsupportFunctionException("수강하는 강의가 3개 미만입니다.",2);
            }
        }
        // wirter 객체는 따로 close()를 호출하지 않아도 try를 벗어나는 순간 close()가 자동으로 호출된다.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/ex05/output.txt"))){
            double finalGrade = grade / majorCount ;
            writer.write(String.format("%.1f",finalGrade)) ;
        }catch (ArithmeticException e){
            System.out.println("수강 과목이 없어유");
        }

    }

}
