package stepic.textAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer{
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text){
        for(String word : getKeywords()){
            if(text.indexOf(word) >= 0){
                return getLabel();
            }
        }
        return Label.OK;
    }
}
