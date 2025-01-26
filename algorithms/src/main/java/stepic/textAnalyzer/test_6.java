package stepic.textAnalyzer;

public class test_6 {
    public static void main(String[] args) {
        TextAnalyzer[] analyzers = new TextAnalyzer[]{ new NegativeTextAnalyzer(),
                new SpamAnalyzer(new String[]{"spam", "реклама"}), new TooLongTextAnalyzer(20)};
        System.out.println("Label: " + checkLabels(analyzers, "Пробный текст"));
        System.out.println("Label: " + checkLabels(analyzers, "Пробный текст spam"));
        System.out.println("Label: " + checkLabels(analyzers, "Пробный текст :("));
        System.out.println("Label: " + checkLabels(analyzers, "Пробный текст текст текст"));
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for(TextAnalyzer textAnalyzer : analyzers){
            Label label = textAnalyzer.processText(text);
            if(label != Label.OK){
                return label;
            }
        }
        return Label.OK;
    }
}
