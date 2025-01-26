package stepic.textAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer{
    @Override
    protected String[] getKeywords(){
        String[] smile = {":(", "=(", ":|"};
        return smile;
    }

    @Override
    protected Label getLabel(){
        return Label.NEGATIVE_TEXT;
    }
}
