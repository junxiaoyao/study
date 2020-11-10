package work;

public class Util {
    public static String jsonStringConvert(String s) {
        char[] temp = s.toCharArray();
        int n = temp.length;
        for (int i = 0; i < n; i++) {
            if (temp[i] == ':' && temp[i + 1] == '"') {
                for (int j = i + 2; j < n; j++) {
                    if (temp[j] == '"') {
                        //如果该字符为双引号,下个字符不是逗号或大括号,替换
                        if (temp[j + 1] != ',' && temp[j + 1] != '}') {
                            //将json字符串本身的双引号以外的双引号变成单引号
                            temp[j] = '\'';
                        } else if (temp[j + 1] == ',' || temp[j + 1] == '}') {
                            break;
                        }
                    }
                }
            }
        }
        String r = new String(temp);
        return r;
    }

    public static void main(String[] args) {
        String s=Util.jsonStringConvert("{\n"
                + "  \"eventId\": 19427,\n"
                + "  \"eventItemId\": 149,\n"
                + "  \"cityId\": 1,\n"
                + "  \"regionId\": 3,\n"
                + "  \"streetId\": 1406,\n"
                + "  \"longitude\": 23.33359,\n"
                + "  \"latitude\": 113.62993,\n"
                + "  \"address\": \"黄埔区\",\n"
                + "  \"eventLevel\": \"A\",\n"
                + "  \"occurTime\": \"2019-12-16 11:35:06\",\n"
                + "  \"contactName\": \"陈秋燕\",\n"
                + "  \"contactPhone\": \" \",\n"
                + "  \"creatorId\": 1497,\n"
                + "  \"creatorGroupId\": 1357,\n"
                + "  \"createTime\": \"2020-10-21 17:20:38\",\n"
                + "  \"dealGroup\": \"1166,1167\",\n"
                + "  \"eventTitle\": \"广州市南炬汽车用品实业有限公司12·16一般火灾事故\",\n"
                + "  \"eventCategory\": \"1289\",\n"
                + "  \"source\": \"cstz\",\n"
                + "  \"eventInfo\": \"2019年12月16日18时22分许，增城区中新镇三迳村工业园内的广州市南炬汽车用品实业有限公司（以下简称南炬公司，对外使用“广州卫斯理化工科技有限公司”牌子）戳罐作业产生的易燃气体遇 SR 型热收缩炉（俗称过膜机）开关火花发生闪燃，引燃了厂区内部分仓库中的产品和物料发生燃爆，造成 5 名员工受伤，部分仓库结构仓内物品受损。\",\n"
                + "  \"contactId\": null,\n"
                + "  \"extend\": \"{\\\"eventItemId\\\":\\\"18001\\\"}\",\n"
                + "  \"isAnonymous\": null,\n"
                + "  \"isReply\": null\n"
                + "}\n");
        String s2="{\n"
                + "  \"eventId\":\"19427\",\n"
                + "  \"eventTitle\":\"广州市南炬汽车用品实业有限公司12·16一般火灾事故\",\n"
                + "  \"eventItemId\":\"149\",\n"
                + "  \"eventCategory\":\"1289\",\n"
                + "  \"eventLevel\":\"A\",\n"
                + "  \"source\":\"cstz\",\n"
                + "  \"occurTime\":\"2019-12-16 11:35:06\",\n"
                + "  \"eventInfo\":\"2019年12月16日18时22分许，增城区中新镇三迳村工业园内的广州市南炬汽车用品实业有限公司（以下简称南炬公司，对外使用“广州卫斯理化工科技有限公司”牌子）戳罐作业产生的易燃气体遇 SR 型热收缩炉（俗称过膜机）开关火花发生闪燃，引燃了厂区内部分仓库中的产品和物料发生燃爆，造成 5 名员工受伤，部分仓库结构仓内物品受损。\",\n"
                + "  \"cityId\":\"1\",\n"
                + "  \"regionId\":\"3\",\n"
                + "  \"streetId\":\"1406\",\n"
                + "  \"address\":\"黄埔区\",\n"
                + "  \"longitude\":23.33359,\n"
                + "  \"latitude\":113.62993,\n"
                + "  \"contactName\":\"陈秋燕\",\n"
                + "  \"contactPhone\":\" \",\n"
                + "  \"contactEmail\":null,\n"
                + "  \"creatorId\":\"1497\",\n"
                + "  \"creatorGroupId\":\"1357\",\n"
                + "  \"isReply\":0,\n"
                + "  \"isAnonymous\":0,\n"
                + "  \"contactPost\":null,\n"
                + "  \"contactId\":null,\n"
                + "  \"extend\":\"{\\\"eventItemId\\\":\\\"18001\\\"}\",\n"
                + "  \"dealGroup\":\"1166,1167\",\n"
                + "  \"attachments\":[\n"
                + "  ]\n"
                + "}";
        System.out.println(Util.jsonStringConvert(s2));
    }
}
