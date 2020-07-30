import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWordList = scanner.nextLine();
        String secondWordList = scanner.nextLine();
        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        result.stream().forEach(word-> System.out.println(word));
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {

        validate(firstWordList);
        validate(secondWordList);

        List<String> firstList = Arrays.stream(firstWordList.split(","))
                .map(word->word.toUpperCase())
                .distinct()
                .collect(Collectors.toList());
        List<String> secondList = Arrays.stream(secondWordList.split(","))
                .map(word->word.toUpperCase())
                .distinct()
                .collect(Collectors.toList());
        return firstList.stream()
                .filter(word->secondList.contains(word))
                .collect(Collectors.toList());
    }

    public static void validate(String str){
        if(str.contains(",,") || str.matches("[a-zA-Z,]+")){
            throw new RuntimeException("input not valid");
        }
    }
}
