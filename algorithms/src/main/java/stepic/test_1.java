package stepic;

public class test_1 {
    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич", "Лука", "Кто-то"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        String out = printTextPerRole(roles, textLines);
        System.out.println(out);
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder out = new StringBuilder();
        for(String role : roles){
            role = role + ":";
            out.append(role);
            out.append("\n");
            for(int i=0; i < textLines.length; i++){
                if(textLines[i].startsWith(role)){
                    out.append(i+1);
                    out.append(")");
                    out.append(textLines[i].replaceFirst(role, ""));
                    out.append("\n");
                }
            }
            out.append("\n");
        }
        return out.toString();
    }
}
