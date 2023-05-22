package ex05;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private List<String[]> rows;

    public static void main(String[] args) {
        Student student = new Student();
        String paths = "D:\\lionstudy\\lion.csv";
        String outputFilePath = "D:\\lionstudy\\output.csv";  // 출력 파일 경


        try {
            student.readCSV(paths);  // CSV 파일 읽기
            student.addValueToRows();  // 값 추가
            student.assignGrades(); // 점수에 따른 학점 추가
            student.calculateAverageGrade(outputFilePath);
            System.out.println("CSV 파일 처리 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAverageGrade(String outputFilePath) throws Exception {
        int fCount = 0;
        double totalGrade = 0.0;

        for (String[] row : rows) {
            double grade = Double.parseDouble(row[4]);
            if (row[5].equals("F")) {
                fCount++;
            }
            totalGrade += grade;
        }

        if (fCount >= 3) {
            throw new Exception("전체 성적에 F 학점이 3개 이상입니다.");
        }

        double averageGrade = totalGrade / rows.size();
        String averageGradeString = String.format("%.1f", averageGrade);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(averageGradeString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCSV(String filePath) throws IOException {
        rows = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                rows.add(line);
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public void assignGrades() throws Exception {
        if (rows.size() < 3) {
            throw new Exception("수강하는 강의가 3개 미만입니다.");
        }

        for (String[] row : rows) {
            System.out.println("행값:"+ row[0]+ row[1] +row[2]+row[3]+row[4]);
            String grade;
            switch (row[4]) {
                case "4.5":
                    grade = "A";
                    break;
                case "4.0":
                    grade = "B";
                    break;
                case "3.5":
                    grade = "C";
                    break;
                case "3.0":
                    grade = "D";
                    break;
                case "0.0":
                    grade = "F";
                    break;
                default:
                    throw new Exception("올바르지 않은 학점입니다.");
            }
            row[5] = grade;
        }
    }

    private void addValueToRows() throws Exception {
        Random random = new Random();
        int numRows = rows.size(); // 현재 행의 개수
        int numColumns = rows.get(0).length; // 열의 개수 (전체 행이 동일한 열 개수를 가지고 있다고 가정)

        for (int i = 0; i < numRows; i++) {
            String[] row = rows.get(i);

            String[] newRow;
            if (row.length <= numColumns) {
                // 열의 개수가 numColumns보다 작거나 같은 경우, 배열의 크기를 늘립니다
                newRow = new String[numColumns + 3];
                System.arraycopy(row, 0, newRow, 0, numColumns);
            } else {
                // 열의 개수가 numColumns보다 큰 경우, 배열의 크기는 유지됩니다
                newRow = row;
            }

            double[] grades = {0.0, 3.0, 3.5, 4.0, 4.5};
            int randomIndex = random.nextInt(grades.length);
            double randomValue = grades[randomIndex];
            newRow[numColumns] = String.valueOf(randomValue); // 새로운 열에 값을 추가합니다

            rows.set(i, newRow); // 수정된 행을 리스트에 저장합니다
        }
    }


}

